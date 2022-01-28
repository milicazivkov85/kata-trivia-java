package trivia;

public class Player {

  private String name;
  private int position;
  private int purses;

  public Player(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return this.name;
  }
}
