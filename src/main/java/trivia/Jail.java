package trivia;

import java.util.HashSet;
import java.util.Set;

public class Jail {

  private Set<Player> jail = new HashSet<>();

  public boolean hasImprisoned(Player player) {
    return jail.contains(player);
  }

  public void letOutPlayer(Player player) {
    System.out.println(player + " is getting out of the penalty box");
    jail.remove(player);
  }

  public void imprison(Player player) {
    jail.add(player);
    System.out.println(player + " was sent to the penalty box");
  }

  private boolean isGetOutOfJailRoll(int roll) {
    return roll % 2 != 0;
  }

  public void tryToGetOut(Player player, int roll) {
    if (this.isGetOutOfJailRoll(roll)) {
      this.letOutPlayer(player);
    } else {
      System.out.println(player + " is not getting out of the penalty box");
    }
  }
}
