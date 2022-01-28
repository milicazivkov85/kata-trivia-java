package trivia;

import java.util.ArrayList;

// REFACTOR ME
public class GameBetter implements IGame {
   ArrayList players = new ArrayList();
   PlayerInGame[] gamePlayers = new PlayerInGame[6];
   int currentPlayer = 0;
   boolean[] inPenaltyBox = new boolean[6];
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
      inPenaltyBox[howManyPlayers()] = false;

      System.out.println(playerName + " was added");
      System.out.println("They are player number " + players.size());
      return true;
   }

   public int howManyPlayers() {
      return players.size();
   }

   public void roll(int roll) {
      
      
      System.out.println(players.get(currentPlayer) + " is the current player");
      System.out.println("They have rolled a " + roll);

      if (inPenaltyBox[currentPlayer]) {
         if (roll % 2 != 0) {
            isGettingOutOfPenaltyBox = true;

            System.out.println(players.get(currentPlayer) + " is getting out of the penalty box");
            gamePlayers[currentPlayer].position = gamePlayers[currentPlayer].position + roll;
            if (gamePlayers[currentPlayer].position > 11) gamePlayers[currentPlayer].position = gamePlayers[currentPlayer].position - 12;

            System.out.println(players.get(currentPlayer)
                               + "'s new location is "
                               + gamePlayers[currentPlayer].position);
            System.out.println("The category is " + currentCategory());
            askQuestion();
         } else {
            System.out.println(players.get(currentPlayer) + " is not getting out of the penalty box");
            isGettingOutOfPenaltyBox = false;
         }

      } else {

         gamePlayers[currentPlayer].position = gamePlayers[currentPlayer].position + roll;
         if (gamePlayers[currentPlayer].position > 11) gamePlayers[currentPlayer].position = gamePlayers[currentPlayer].position - 12;

         System.out.println(players.get(currentPlayer)
                            + "'s new location is "
                            + gamePlayers[currentPlayer].position);
         System.out.println("The category is " + currentCategory());
         askQuestion();
      }

   }

   private void askQuestion() {
      questionsDecks.pullQuestion(currentCategory());
   }

   private String currentCategory() {
      int placeOnBoard = gamePlayers[currentPlayer].position;
      return board.getCategoryInPlace(placeOnBoard);
   }



   public boolean wasCorrectlyAnswered() {
      if (inPenaltyBox[currentPlayer]) {
         if (isGettingOutOfPenaltyBox) {
            System.out.println("Answer was correct!!!!");
            gamePlayers[currentPlayer].purses++;
            System.out.println(players.get(currentPlayer)
                               + " now has "
                               + gamePlayers[currentPlayer].purses
                               + " Gold Coins.");

            boolean winner = didPlayerWin();
            handDiceToTheNextPlayer();

            return winner;
         } else {
            handDiceToTheNextPlayer();
            return true;
         }


      } else {

         System.out.println("Answer was corrent!!!!");
         gamePlayers[currentPlayer].purses++;
         System.out.println(players.get(currentPlayer)
                            + " now has "
                            + gamePlayers[currentPlayer].purses
                            + " Gold Coins.");

         boolean winner = didPlayerWin();
         handDiceToTheNextPlayer();

         return winner;
      }
   }

   public boolean wrongAnswer() {
      System.out.println("Question was incorrectly answered");
      System.out.println(players.get(currentPlayer) + " was sent to the penalty box");
      inPenaltyBox[currentPlayer] = true;

      handDiceToTheNextPlayer();
      return true;
   }

   private void handDiceToTheNextPlayer() {
      nextPlayer();
      if (isLastPlayer()) {
         firstPlayer();
      }
   }

   private void firstPlayer() {
      currentPlayer = 0;
   }

   private int nextPlayer() {
      return currentPlayer++;
   }

   private boolean isLastPlayer() {
      return currentPlayer == players.size();
   }
   
   private boolean didPlayerWin() {
      return !(gamePlayers[currentPlayer].purses == 6);
   }
}
