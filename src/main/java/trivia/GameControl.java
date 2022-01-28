package trivia;

public class GameControl {
  private Player[] gamePlayers = new Player[6];
  public int currentPlayerIndex = 0;
  public int gamePlayersIndex = 0;

  public void handDiceToTheNextPlayer(int playersSize) {
    nextPlayer();
    if (isLastPlayer(playersSize)) {
      firstPlayer();
    }
  }

  private void firstPlayer() {
    this.currentPlayerIndex = 0;
  }

  private int nextPlayer() {
    return this.currentPlayerIndex++;
  }

  private boolean isLastPlayer(int playersSize) {
    return this.currentPlayerIndex == playersSize;
  }

  public boolean isCurrentUserInPenaltyBox() {
    return gamePlayers[currentPlayerIndex].isInPenaltyBox();
  }

  public void moveCurrentUserFor(int roll) {
    gamePlayers[currentPlayerIndex].moveFor(roll);
    System.out.println(getCurrentPlayer()
            + "'s new location is "
            + getCurrentUserPosition());
  }

  public int getCurrentUserPosition() {
    return gamePlayers[currentPlayerIndex].getPosition();
  }

  public void addPursesToCurrentUser() {
    gamePlayers[currentPlayerIndex].incPurses();
    System.out.println(getCurrentPlayer()
            + " now has "
            + getCurrentUserPurses()
            + " Gold Coins.");
  }

  public int getCurrentUserPurses() {
    return gamePlayers[currentPlayerIndex].getPurses();
  }

  public void sendCurrentUserToPenaltyBox() {
    gamePlayers[currentPlayerIndex].goToPenaltyBox();
    System.out.println(getCurrentPlayer() + " was sent to the penalty box");
  }

  public boolean didPlayerWin() {
    return !(gamePlayers[currentPlayerIndex].getPurses() == 6);
  }

  public void addPlayer(Player playerInGame) {
    gamePlayers[gamePlayersIndex] = playerInGame;
    gamePlayersIndex++;
  }

  public String getCurrentPlayer() {
    return gamePlayers[currentPlayerIndex].getName();
  }

  public int numberOfPlayers() {
    return gamePlayersIndex;
  }

  public void letCurrentUserOutFromPenaltyBox() {
    System.out.println(getCurrentPlayer() + " is getting out of the penalty box");
    gamePlayers[currentPlayerIndex].leavePenaltyBox();
  }

  public void currentUserStaysInPenaltyBox() {
    System.out.println(getCurrentPlayer() + " is not getting out of the penalty box");
  }

  public void printCurrentPlayer() {
    System.out.println(getCurrentPlayer() + " is the current player");
  }
}
