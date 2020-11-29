package sorting.comparator;

import java.util.Comparator;

public class DemoComparator {
  static class Player {
    String name;
    int score;

    public Player(String name, int score) {
      this.name = name;
      this.score = score;
    }

    public String toString() {
      return name + " " + score;
    }
  }

  static class Checker implements Comparator<Player> {
    public int compare(Player a, Player b) {
      return a.score != b.score ? b.score - a.score : a.name.compareToIgnoreCase(b.name);
    }
  }
}
