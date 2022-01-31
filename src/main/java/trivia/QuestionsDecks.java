package trivia;

import java.util.*;

public class QuestionsDecks {

  private Map<String, Deck> decks = new HashMap<>();
  private String[] availableCategories = {"Pop", "Science", "Sports", "Rock"};

  public QuestionsDecks() {
    Arrays.stream(availableCategories)
            .forEach(category -> decks.put(category, new Deck(category)));
  }

  public void createThisManyQuestions(int numberOfQuestions) {
    decks.forEach(((category, deck) -> deck.createQuestions(numberOfQuestions)));
  }

  public void pullQuestionFromCategory(String category) {
    Deck deck = decks.get(category);
    deck.pullQuestion();
  }

  private class Deck {
    private String category;
    private LinkedList questions = new LinkedList();

    public Deck(String category) {
      this.category = category;
    }

    public void createQuestions(int numberOfQuestions) {
      for (int i = 0; i < numberOfQuestions; i++) {
        questions.addLast(category + " Question " + i);
      }
    }

    public void pullQuestion() {
        System.out.println(questions.removeFirst());
    }

  }

}
