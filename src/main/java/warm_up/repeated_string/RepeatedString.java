package warm_up.repeated_string;

public class RepeatedString {
  long repeatedString(String s, long n) {
    // Idea:
    // 1) count number of 'a' in s
    // 2) count number of 'a' from 0-offset in s
    //    where offset is s.length() % n
    // NOTE: we can do both 1 and 2 in a single path

    long count = 0;
    long count2Offset = 0;
    int len = s.length();
    long offset = n % len;
    for (int i = 0; i < len; i++) {
      if (s.charAt(i) == 'a') {
        count++;
        if (i < offset) {
          count2Offset++;
        }
      }
    }
    // NOTE: this return has error because it perform '*' operation before
    //       the division.
    // return count * n / len + count2Offset;
    return count * (n / len) + count2Offset;
  }

  // also works
  public long repeatedString2(String s, long n) {
    long count = 0;
    char[] ar = s.toCharArray();
    for (char c : ar) {
      count += (c == 'a') ? 1 : 0;
    }
    // count=4, n=12, ar.length = 5
    // count*n/ar.length = 4*12/5 = 48/5 = 9
    // where n/ar.length * count = 12/5 * 4 = 2 * 4 = 8
    count = count * (n / ar.length);
    long offset = n % ar.length;

    for (int i=0; i<offset; i++) {
      count += (ar[i] == 'a')? 1 : 0;
    }
    return count;
  }
}
