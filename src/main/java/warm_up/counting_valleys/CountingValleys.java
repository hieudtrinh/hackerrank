package warm_up.counting_valleys;

public class CountingValleys {
  public int countingValleys(int steps, String path) {
    // idea:
    // 1) keep track of current level - cl initialize to 0
    // 2) if cl = 0 and the step is upward, we have walked pass 1 valley
    int cl = 0;
    int valleys = 0;

    for (char c : path.toCharArray()) {
      cl += c == 'U' ? 1 : -1;
      valleys += (cl == 0 && c == 'U') ? 1 : 0;
    }
    return valleys;
  }
}
