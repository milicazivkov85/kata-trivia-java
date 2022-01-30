package trivia;

import java.util.ArrayList;
import java.util.List;

public class PlayersControl {

  private Player active;

  private List<Player> players = new ArrayList<>();

  public Player getActive() {
    return active;
  }

  public void includePlayer(Player player) {
    if (active == null) {
      active = player;
    }
    players.add(player);
  }

  public int count() {
    return players.size();
  }

  public void nextPlayer() {
    int activePlayerIndex = players.indexOf(active);
    if (activePlayerIndex == count() - 1) {
      active = players.get(0);
    } else {
      active = players.get(activePlayerIndex + 1);
    }
  }

}
