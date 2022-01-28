package trivia;

import java.util.ArrayList;

// REFACTOR ME
public class GameBetter implements IGame {
   ArrayList players = new ArrayList();
   PlayerInGame[] gamePlayers = new PlayerInGame[6];
   GameControl gameControl = new GameControl();
   QuestionsDecks questionsDecks = new QuestionsDecks();
   Board board = new Board();
   
   boolean isGettingOutOfPenaltyBox;

   public GameBetter() {
      for (int i = 0; i < 50; i++) {
         questionsDecks.createQuestions(i);
      }
   }

   public boolean isPlayable() {
      return (howManyPlayers() >= 2);
   }

   public boolean add(String playerName) {
      Player player = new Player(playerName);
      players.add(player);
      gamePlayers[howManyPlayers()-1] = new PlayerInGame();

      System.out.println(playerName + " was added");
      System.out.println("They are player number " + players.size());
      return true;
   }

   public int howManyPlayers() {
      return players.size();
   }

   public void roll(int roll) {
      
      
      System.out.println(players.get(gameControl.currentPlayerIndex) + " is the current player");
      System.out.println("They have rolled a " + roll);

      if (gamePlayers[gameControl.currentPlayerIndex].isInPenaltyBox) {
         if (roll % 2 != 0) {
            isGettingOutOfPenaltyBox = true;

            System.out.println(players.get(gameControl.currentPlayerIndex) + " is getting out of the penalty box");

            gamePlayers[gameControl.currentPlayerIndex].moveFor(roll);

            System.out.println(players.get(gameControl.currentPlayerIndex)
                               + "'s new location is "
                               + gamePlayers[gameControl.currentPlayerIndex].position);
            System.out.println("The category is " + currentCategory());
            askQuestion();
         } else {
            System.out.println(players.get(gameControl.currentPlayerIndex) + " is not getting out of the penalty box");
            isGettingOutOfPenaltyBox = false;
         }

      } else {
         gamePlayers[gameControl.currentPlayerIndex].moveFor(roll);

         System.out.println(players.get(gameControl.currentPlayerIndex)
                            + "'s new location is "
                            + gamePlayers[gameControl.currentPlayerIndex].position);
         System.out.println("The category is " + currentCategory());
         askQuestion();
      }

   }

   private void askQuestion() {
      questionsDecks.pullQuestion(currentCategory());
   }

   private String currentCategory() {
      int placeOnBoard = gamePlayers[gameControl.currentPlayerIndex].position;
      return board.getCategoryInPlace(placeOnBoard);
   }



   public boolean wasCorrectlyAnswered() {
      if (gamePlayers[gameControl.currentPlayerIndex].isInPenaltyBox) {
         if (isGettingOutOfPenaltyBox) {
            System.out.println("Answer was correct!!!!");
            gamePlayers[gameControl.currentPlayerIndex].purses++;
            System.out.println(players.get(gameControl.currentPlayerIndex)
                               + " now has "
                               + gamePlayers[gameControl.currentPlayerIndex].purses
                               + " Gold Coins.");

            boolean winner = didPlayerWin();
            gameControl.handDiceToTheNextPlayer(players.size());

            return winner;
         } else {
            gameControl.handDiceToTheNextPlayer(players.size());
            return true;
         }


      } else {

         System.out.println("Answer was corrent!!!!");
         gamePlayers[gameControl.currentPlayerIndex].purses++;
         System.out.println(players.get(gameControl.currentPlayerIndex)
                            + " now has "
                            + gamePlayers[gameControl.currentPlayerIndex].purses
                            + " Gold Coins.");

         boolean winner = didPlayerWin();
         gameControl.handDiceToTheNextPlayer(players.size());

         return winner;
      }
   }

   public boolean wrongAnswer() {
      System.out.println("Question was incorrectly answered");
      System.out.println(players.get(gameControl.currentPlayerIndex) + " was sent to the penalty box");
      gamePlayers[gameControl.currentPlayerIndex].isInPenaltyBox = true;

      gameControl.handDiceToTheNextPlayer(players.size());
      return true;
   }


   
   private boolean didPlayerWin() {
      return !(gamePlayers[gameControl.currentPlayerIndex].purses == 6);
   }
}
