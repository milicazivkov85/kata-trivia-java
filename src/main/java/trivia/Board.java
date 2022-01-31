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

  public TriviaCategory getCategoryInPlace(int placeOnBoard) {
    if (placeOnBoard == 0) return TriviaCategory.POP;
    if (placeOnBoard == 4) return TriviaCategory.POP;
    if (placeOnBoard == 8) return TriviaCategory.POP;
    if (placeOnBoard == 1) return TriviaCategory.SCIENCE;
    if (placeOnBoard == 5) return TriviaCategory.SCIENCE;
    if (placeOnBoard == 9) return TriviaCategory.SCIENCE;
    if (placeOnBoard == 2) return TriviaCategory.SPORTS;
    if (placeOnBoard == 6) return TriviaCategory.SPORTS;
    if (placeOnBoard == 10) return TriviaCategory.SPORTS;
    return TriviaCategory.ROCK;
  }
}
