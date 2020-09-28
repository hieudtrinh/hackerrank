package warm_up.jump_on_the_cloud;

public class JumpOnTheCloud {
  public int jumpingOnClouds(int[] c) {
    // Idea:
    // 1) try to jump 2 steps first
    // 2) if not possible, try to jump 1 step, if not possible error
    // NOTE: It is always possible to win the game

    int steps = 0;
    for (int i = 0; i < c.length - 2; ) {
      if (c[i + 2] == 0) {
        i += 2;
      } else if (c[i + 1] == 0) {
        i += 1;
      } else {
        return -1;
      }
      steps++;
    }
    return steps;
  }
}
