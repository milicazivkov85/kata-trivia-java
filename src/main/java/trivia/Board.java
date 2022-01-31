package trivia;

public class Board {

  private static final int TOTAL_PLACES = 12;

  public static int move(int position, int roll) {
    position += roll;
    if (position > TOTAL_PLACES - 1) {
      position -= TOTAL_PLACES;
    }
    return position;
  }

  public String getCategoryInPlace(int placeOnBoard) {
    if (placeOnBoard == 0) return "Pop";
    if (placeOnBoard == 4) return "Pop";
    if (placeOnBoard == 8) return "Pop";
    if (placeOnBoard == 1) return "Science";
    if (placeOnBoard == 5) return "Science";
    if (placeOnBoard == 9) return "Science";
    if (placeOnBoard == 2) return "Sports";
    if (placeOnBoard == 6) return "Sports";
    if (placeOnBoard == 10) return "Sports";
    return "Rock";
  }
}
