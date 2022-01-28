package trivia;

public class PlayerInGame {
  public int position;
  public int purses;
  public boolean isInPenaltyBox = false;

  public void moveFor(int roll) {
    this.position += roll;
    if (this.position > 11) {
      this.position -=12 ;
    }
  }
}
