package trivia;

// REFACTOR ME
public class GameBetter implements IGame {
   GameControl gameControl = new GameControl();
   QuestionsDecks questionsDecks = new QuestionsDecks();
   Board board = new Board();
   
   public GameBetter() {
      for (int i = 0; i < 50; i++) {
         questionsDecks.createQuestions(i);
      }
   }

   public boolean isPlayable() {
      return (howManyPlayers() >= 2);
   }

   public boolean add(String playerName) {
      gameControl.addPlayer(new Player(playerName));

      System.out.println(playerName + " was added");
      System.out.println("They are player number " + gameControl.numberOfPlayers());
      return true;
   }

   public int howManyPlayers() {
      return gameControl.numberOfPlayers();
   }

   public void roll(int roll) {
      gameControl.printCurrentPlayer();
      System.out.println("They have rolled a " + roll);

      if (gameControl.isCurrentUserInPenaltyBox() && roll % 2 != 0) {
            gameControl.letCurrentUserOutFromPenaltyBox();
         } else if (gameControl.isCurrentUserInPenaltyBox()) {
            gameControl.currentUserStaysInPenaltyBox();
         }

      if (!gameControl.isCurrentUserInPenaltyBox()){
         gameControl.moveCurrentUserFor(roll);
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
      if (!gameControl.isCurrentUserInPenaltyBox()) {
         System.out.println("Answer was correct!!!!");
         gameControl.addPursesToCurrentUser();

         winner = gameControl.didPlayerWin();
      }
      gameControl.handDiceToTheNextPlayer(gameControl.numberOfPlayers());
      return winner;
   }

   public boolean wrongAnswer() {
      System.out.println("Question was incorrectly answered");
      gameControl.sendCurrentUserToPenaltyBox();
      gameControl.handDiceToTheNextPlayer(gameControl.numberOfPlayers());
      return true;
   }

}
