package trivia;

public class GameControl {
  private PlayerInGame[] gamePlayers = new PlayerInGame[6];
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
    return gamePlayers[currentPlayerIndex].isInPenaltyBox;
  }

  public void moveCurrentUserFor(int roll) {
    gamePlayers[currentPlayerIndex].moveFor(roll);
  }

  public int getCurrentUserPosition() {
    return gamePlayers[currentPlayerIndex].position;
  }

  public void addPursesToCurrentUser() {
    gamePlayers[currentPlayerIndex].purses++;
  }

  public int getCurrentUserPurses() {
    return gamePlayers[currentPlayerIndex].purses;
  }

  public void sendCurrentUserToPenaltyBox() {
    gamePlayers[currentPlayerIndex].isInPenaltyBox = true;
  }

  public boolean didPlayerWin() {
    return !(gamePlayers[currentPlayerIndex].purses == 6);
  }

  public void addPlayer(PlayerInGame playerInGame) {
    gamePlayers[gamePlayersIndex] = playerInGame;
    gamePlayersIndex++;
  }

  public String getCurrentPlayer() {
    return gamePlayers[currentPlayerIndex].name;
  }

  public int numberOfPlayers() {
    return gamePlayersIndex;
  }
}
