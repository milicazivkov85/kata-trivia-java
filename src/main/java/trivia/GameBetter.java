package trivia;

// REFACTOR ME
public class GameBetter implements IGame {
   public static final int WINNING_COINS = 6;
   private PlayersControl players = new PlayersControl();
   private QuestionsDecks questionsDecks = new QuestionsDecks();
   private Jail jail = new Jail();
   private Board board = new Board();
   
   public GameBetter() {
      questionsDecks.createThisManyQuestions(50);
   }

   public boolean isPlayable() {
      return (players.count() >= 2);
   }

   public boolean add(String playerName) {
      players.includePlayer(new Player(playerName));

      System.out.println(playerName + " was added");
      System.out.println("They are player number " + players.count());
      return true;
   }

   public void roll(int roll) {
      System.out.println(players.getActive() + " is the current player");
      System.out.println("They have rolled a " + roll);

      if (jail.hasImprisoned(players.getActive())) {
         jail.tryToGetOut(players.getActive(), roll);
         if (jail.hasImprisoned(players.getActive())) {
            return;
         }
      }

      players.getActive().moveFor(roll);
      askQuestion();
   }

   private void askQuestion() {
      TriviaCategory category = currentCategory();
      System.out.println("The category is " + category);
      questionsDecks.pullQuestionFromCategory(category);
   }

   private TriviaCategory currentCategory() {
      int placeOnBoard = players.getActive().getPositionOnBoard();
      return board.getCategoryInPlace(placeOnBoard);
   }

   public boolean wasCorrectlyAnswered() {
      boolean notAWinner = true;
      if (!jail.hasImprisoned(players.getActive())) {
         System.out.println("Answer was correct!!!!");
         players.getActive().getsCoin();

         notAWinner = !isActivePlayerAWinner();
      }
      players.nextPlayer();
      return notAWinner;
   }

   private boolean isActivePlayerAWinner() {
      return players.getActive().getCoins() == WINNING_COINS;
   }

   public boolean wrongAnswer() {
      System.out.println("Question was incorrectly answered");
      jail.imprison(players.getActive());
      players.nextPlayer();
      return true;
   }

}
