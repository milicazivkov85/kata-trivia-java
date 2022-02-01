package trivia;

public enum TriviaCategory {

  POP,
  SCIENCE,
  SPORTS,
  ROCK;

  @Override
  public String toString() {
    return getPrettyTitle();
  }

  private String getPrettyTitle() {
    return this.name().substring(0, 1) + this.name().toLowerCase().substring(1);
  }
}
