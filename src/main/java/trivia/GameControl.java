package trivia;

public class GameControl {

  public int currentPlayerIndex = 0;

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

}
