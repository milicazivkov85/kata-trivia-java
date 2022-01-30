package trivia;

public class Player {

  private String name;
  private int positionOnBoard;
  private int coins;

  public Player(String name) {
    this.name = name;
  }

  public void moveFor(int roll) {
    this.positionOnBoard = Board.move(this.positionOnBoard, roll);
    System.out.println(name
            + "'s new location is "
            + positionOnBoard);
  }

  public int getPositionOnBoard() {
    return this.positionOnBoard;
  }

  public void getsCoin() {
    this.coins++;
    System.out.println(name
            + " now has "
            + coins
            + " Gold Coins.");
  }

  public int getCoins() {
    return this.coins;
  }

  @Override
  public String toString() {
    return this.name;
  }

}
