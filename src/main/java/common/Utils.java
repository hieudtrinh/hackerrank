package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Utils {
  public static List<Integer> toList(int[] nums) {
    return Arrays.stream(nums).boxed().collect(Collectors.toList());
  }

  public static String toString(int[] nums) {
    return toList(nums).toString();
  }

  public static Set<List<Integer>> toSetOfList(int[][] nums) {
    return Arrays.stream(nums).map(Utils::toList).collect(Collectors.toSet());
  }

  public static List<List<Integer>> toListOfList(int[][] nums) {
    return Arrays.stream(nums).map(Utils::toList).collect(Collectors.toList());
  }

  public static String toString(int[][] nums) {
    return Arrays.stream(nums).map(Utils::toList).collect(Collectors.toList()).toString();
  }

  /**
   * @param s [[1,2], [3,4]]
   * @return a list of list of Integer
   */
  public static List<List<Integer>> toListOfList(String s) {
    s = s.trim();
    if (s.charAt(0) == '[') {
      s = s.substring(1, s.length() - 1);
    }
    String[] tokens = s.split("[ ]*],*");
    List<List<Integer>> list = new ArrayList<>();
    for (String ss : tokens) {
      list.add(new ArrayList<>(toList(ss.trim() + "]")));
    }
    return list;
  }

  public static List<List<String>> toListOfListOfString(String s) {
    s = s.trim();
    if (s.charAt(0) == '[') {
      s = s.substring(1, s.length() - 1);
    }
    String[] tokens = s.split("],*[ ]*");
    List<List<String>> list = new ArrayList<>();
    for (String ss : tokens) {
      list.add(new ArrayList<>(toListOfString(ss.trim() + "]")));
    }
    return list;
  }

  /**
   * @param s [[1,2], [3,4]]
   * @return a set of list of Integer
   */
  public static Set<List<Integer>> toSetOfList(String s) {
    s = s.trim();
    if (s.charAt(0) == '[') {
      s = s.substring(1, s.length() - 1);
    }
    String[] tokens = s.split("],*");
    Set<List<Integer>> set = new HashSet<>();
    for (String ss : tokens) {
      set.add(new ArrayList<>(toList(ss.trim() + "]")));
    }
    return set;
  }

  /**
   * @param s = [1, 3, 4, null]
   * @return List<Integer> list = Arrays.asList(1,3,4,null);
   */
  public static List<Integer> toList(String s) {
    s = s.trim();
    if (s.charAt(0) == '[') {
      s = s.substring(1, s.length() - 1);
    }
    String[] tokens = s.split(",[ ]*");
    List<Integer> list = new ArrayList<>();
    for (String n : tokens) {
      n = n.trim();
      if (n.length() > 0) {
        list.add("null".equalsIgnoreCase(n) ? null : Integer.parseInt(n));
      }
    }
    return list;
  }

  /**
   * @param s = ["1", "3", "4", "null"]
   * @return List<Integer> list = Arrays.asList(1,3,4,null);
   */
  public static List<String> toListOfString(String s) {
    s = s.trim();
    if (s.charAt(0) == '[') {
      s = s.substring(1, s.length() - 1);
    }
    String[] tokens = s.split(",[ ]*");
    List<String> list = new ArrayList<>();
    for (String n : tokens) {
      n = n.trim();
      if (n.length() > 0) {
        list.add(n);
      }
    }
    return list;
  }

  /**
   * @param s = [1, 3, 4, null]
   * @return Set<Integer> list = Set<Integer>(Arrays.asList(1,3,4,null));
   */
  public static Set<Integer> toSet(String s) {
    s = s.trim();
    if (s.charAt(0) == '[') {
      s = s.substring(1, s.length() - 1);
    }
    String[] tokens = s.split(",[ ]*");
    Set<Integer> set = new HashSet<>();
    for (String n : tokens) {
      n = n.trim();
      set.add("null".equalsIgnoreCase(n) ? null : Integer.parseInt(n));
    }
    return set;
  }

  public static int[][] toArrayIntArray(String s) {
    List<List<Integer>> lists = toListOfList(s);
    int i = 0;
    int[][] nums = new int[lists.size()][];
    for (List<Integer> l : lists) {
      nums[i++] = l.stream().mapToInt(a -> a).toArray();
    }
    return nums;
  }

  public static int[] toArrayInt(String s) {
    return toList(s).stream().mapToInt(i -> i).toArray();
  }

  public static Integer[] toArrayInteger(String s) {
    return toList(s).toArray(new Integer[0]);
  }

  public static char[][] to2DCharArray(String[] words) {
    int len = words[0].length();
    char[][] board = new char[words.length][len];
    for (int i=0; i<words.length; i++) {
      if (len != words[i].length()) {
        return null;
      }
      board[i] = words[i].toCharArray();
    }
    return board;
  }
}
