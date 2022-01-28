package trivia;

public class Player {
  private int position;
  private int purses;
  private boolean isInPenaltyBox;
  private String name;

  public Player(String name) {
    this.name = name;
  }

  public void moveFor(int roll) {
    this.position += roll;
    if (this.position > 11) {
      this.position -=12 ;
    }
  }

  public boolean isInPenaltyBox() {
    return this.isInPenaltyBox;
  }

  @Override
  public String toString() {
    return this.name;
  }

  public int getPosition() {
    return this.position;
  }

  public void incPurses() {
    this.purses++;
  }

  public int getPurses() {
    return this.purses;
  }

  public void goToPenaltyBox() {
    this.isInPenaltyBox = true;
  }

  public String getName() {
    return this.name;
  }

  public void leavePenaltyBox() {
    this.isInPenaltyBox = false;
  }
}
