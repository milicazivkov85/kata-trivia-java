package trivia;

import java.util.ArrayList;

// REFACTOR ME
public class GameBetter implements IGame {
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
      gameControl.addPlayer(new PlayerInGame(playerName));

      System.out.println(playerName + " was added");
      System.out.println("They are player number " + gameControl.numberOfPlayers());
      return true;
   }

   public int howManyPlayers() {
      return gameControl.numberOfPlayers();
   }

   public void roll(int roll) {
      System.out.println(gameControl.getCurrentPlayer() + " is the current player");
      System.out.println("They have rolled a " + roll);

      if (gameControl.isCurrentUserInPenaltyBox() && roll % 2 != 0) {
            isGettingOutOfPenaltyBox = true;
            System.out.println(gameControl.getCurrentPlayer() + " is getting out of the penalty box");
         } else if (gameControl.isCurrentUserInPenaltyBox()) {
            System.out.println(gameControl.getCurrentPlayer() + " is not getting out of the penalty box");
            isGettingOutOfPenaltyBox = false;
         }

      if (!gameControl.isCurrentUserInPenaltyBox() || isGettingOutOfPenaltyBox){
         gameControl.moveCurrentUserFor(roll);

         System.out.println(gameControl.getCurrentPlayer()
                            + "'s new location is "
                            + gameControl.getCurrentUserPosition());
         System.out.println("The category is " + currentCategory());
         askQuestion();
      }

   }

   private void askQuestion() {
      questionsDecks.pullQuestion(currentCategory());
   }

   private String currentCategory() {
      int placeOnBoard = gameControl.getCurrentUserPosition();
      return board.getCategoryInPlace(placeOnBoard);
   }

   public boolean wasCorrectlyAnswered() {
      boolean winner = true;
      if (!gameControl.isCurrentUserInPenaltyBox() || isGettingOutOfPenaltyBox) {
         System.out.println("Answer was correct!!!!");
         gameControl.addPursesToCurrentUser();
         System.out.println(gameControl.getCurrentPlayer()
                            + " now has "
                            + gameControl.getCurrentUserPurses()
                            + " Gold Coins.");

         winner = gameControl.didPlayerWin();
      }
      gameControl.handDiceToTheNextPlayer(gameControl.numberOfPlayers());
      return winner;
   }

   public boolean wrongAnswer() {
      System.out.println("Question was incorrectly answered");
      System.out.println(gameControl.getCurrentPlayer() + " was sent to the penalty box");
      gameControl.sendCurrentUserToPenaltyBox();
      gameControl.handDiceToTheNextPlayer(gameControl.numberOfPlayers());
      return true;
   }

}
