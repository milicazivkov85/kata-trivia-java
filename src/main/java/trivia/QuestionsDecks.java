package trivia;

import java.util.LinkedList;

public class QuestionsDecks {

  LinkedList popQuestions = new LinkedList();
  LinkedList scienceQuestions = new LinkedList();
  LinkedList sportsQuestions = new LinkedList();
  LinkedList rockQuestions = new LinkedList();

  void createQuestions(int i) {
     popQuestions.addLast("Pop Question " + i);
     scienceQuestions.addLast(("Science Question " + i));
     sportsQuestions.addLast(("Sports Question " + i));
     rockQuestions.addLast("Rock Question " + i);
  }

  public void pullQuestion(String currentCategory) {
    if (currentCategory == "Pop")
      System.out.println(popQuestions.removeFirst());
    if (currentCategory == "Science")
      System.out.println(scienceQuestions.removeFirst());
    if (currentCategory == "Sports")
      System.out.println(sportsQuestions.removeFirst());
    if (currentCategory == "Rock")
      System.out.println(rockQuestions.removeFirst());
  }

}
