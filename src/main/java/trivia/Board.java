package trivia;

public class Board {

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
