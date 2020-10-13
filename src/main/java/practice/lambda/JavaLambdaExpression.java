package practice.lambda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

interface PerformOperation {
  boolean check(int a);
}

class MyMath {
  public boolean checker(PerformOperation p, int num) {
    return p.check(num);
  }
  public PerformOperation isOdd() {
    return a -> a % 2 != 0;
  }

  public PerformOperation isPrime() {
    return a -> BigInteger.valueOf(a).isProbablePrime(1);
  }
  public PerformOperation isPalindrome() {
    return a ->
        Integer.toString(a).equals(new StringBuilder(Integer.toString(a)).reverse().toString());
  }
}

public class JavaLambdaExpression {
  // input
  /*
5
1 4
2 5
3 898
1 3
2 12
     */
  // output:
  // EVEN
  // PRIME
  // PALINDROME
  // ODD
  // COMPOSITE
  public static void main(String[] args) throws IOException {
    MyMath ob = new MyMath();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    PerformOperation op;
    boolean ret;
    String ans = null;
    while (T-- > 0) {
      String s = br.readLine().trim();
      StringTokenizer st = new StringTokenizer(s);
      int ch = Integer.parseInt(st.nextToken());
      int num = Integer.parseInt(st.nextToken());
      if (ch == 1) {
        op = ob.isOdd();
        ret = ob.checker(op, num);
        ans = (ret) ? "ODD" : "EVEN";
      } else if (ch == 2) {
        op = ob.isPrime();
        ret = ob.checker(op, num);
        ans = (ret) ? "PRIME" : "COMPOSITE";
      } else if (ch == 3) {
        op = ob.isPalindrome();
        ret = ob.checker(op, num);
        ans = (ret) ? "PALINDROME" : "NOT PALINDROME";
      }
      System.out.println(ans);
    }
  }
}
