package trivia;

import java.util.*;

import static java.util.Arrays.stream;

public class QuestionsDecks {

  private Map<TriviaCategory, Deck> decks = new HashMap<>();

  public void createThisManyQuestions(int numberOfQuestions) {
    stream(TriviaCategory.values())
            .forEach(category -> {
              Deck deck = new Deck(category);
              deck.createThisManyQuestions(numberOfQuestions);
              decks.put(category, deck);
            });
  }

  public void pullQuestionFromCategory(TriviaCategory category) {
    Deck deck = decks.get(category);
    deck.pullQuestion();
  }

  private class Deck {

    private TriviaCategory category;
    private LinkedList questions = new LinkedList();

    public Deck(TriviaCategory category) {
      this.category = category;
    }

    public void createThisManyQuestions(int numberOfQuestions) {
      for (int i = 0; i < numberOfQuestions; i++) {
        questions.addLast(category + " Question " + i);
      }
    }

    public void pullQuestion() {
        System.out.println(questions.removeFirst());
    }

  }

}
