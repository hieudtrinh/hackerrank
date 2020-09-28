package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTest {
  public static void main(String[] args) {
    //        List<String> list = Arrays.asList("ab","bc");
    //        List<String> list = new ArrayList<>(Arrays.asList("ab","bc"));
    //        System.out.println(list);
    //        list.remove(1);
    //        System.out.println(list);

    //        Set<int[]> s1 = new HashSet<>();
    //        Set<int[]> s2 = new HashSet<>();
    //        System.out.println(s1.equals(s2));
    //
    //        s1.add(new int[] {2});
    //        s2.add(new int[] {2});
    //        System.out.println(s1.equals(s2));

    //    Set<List<Integer>> s1 = new HashSet<>();
    //    Set<List<Integer>> s2 = new HashSet<>();
    //    s1.add(new ArrayList<>(10));
    //    s2.add(new ArrayList<>(10));
    //    System.out.println(s1.equals(s2));
    int[][] intervals = Utils.toArrayIntArray("[[1,2],[3,5],[6,7],[8,10],[12,16]]");

    List<int[]> list = new ArrayList(Arrays.asList(intervals));
    System.out.println(list.size());

    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i)[0]);
      if (list.get(i)[0] < 6) {
        list.remove(i);
      }
    }
    System.out.println(list.size());
    System.out.println(list);
  }
}
