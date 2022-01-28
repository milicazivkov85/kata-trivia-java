package trivia;

public class Player {
  public int position;
  public int purses;
  public boolean isInPenaltyBox = false;


  public String name;

  public Player(String name) {
    this.name = name;
  }


  public void moveFor(int roll) {
    this.position += roll;
    if (this.position > 11) {
      this.position -=12 ;
    }
  }

  @Override
  public String toString() {
    return this.name;
  }
}
