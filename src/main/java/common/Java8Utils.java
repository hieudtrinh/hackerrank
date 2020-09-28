package common;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Java8Utils {

  // Function to find minimum value in a List in Java 8 and above
  public static Integer findMin(List<Integer> list) {
    return list.stream() // Stream<Integer>
        .mapToInt(v -> v) // IntStream
        .min() // OptionalInt
        .orElse(Integer.MAX_VALUE); // Integer
  }

  // Function to find minimum value in a List in Java 8 and above
  public static Integer findMin_min_get(List<Integer> list) {
    return list.stream() // Stream<Integer>
            .min(Comparator.naturalOrder()) // Optional<Integer>
            .get(); // Integer
  }

  // Function to find minimum value in a List in Java 8 and above
  public static Integer findMin_min_get2(List<Integer> list) {
    return list.stream() // Stream<Integer>
        .min(Integer::compare) // Optional<Integer>
        .get(); // Integer
  }

  // Function to find minimum value in a List in Java 8 and above
  public static Integer findMin_reduce_get(List<Integer> list) {
    return list.stream() // Stream<Integer>
        .reduce(Integer::min) // Optional<Integer>
        .get(); // Integer
  }

  // Function to find minimum value in a List in Java 8 and above
  public static Integer findMin_reduce(List<Integer> list) {
    return list.stream().reduce(Integer.MAX_VALUE, Integer::min);
  }

  // Function to find minimum value in a List in Java 8 and above
  public static Integer findMin_Collectors_minBy(List<Integer> list) {
    return list.stream().min(Comparator.naturalOrder()).get();
//    return list.stream().collect(Collectors.minBy(Comparator.naturalOrder())).get();
  }

  // Function to find minimum value in a List in Java 8 and above
  public static Integer findMin_Collectors_summarizing(List<Integer> list) {
    return list.stream().collect(Collectors.summarizingInt(Integer::intValue)).getMin();
  }

  // Function to find minimum value in a List in Java 8 and above
  public static Integer findMin_Collectors_reducing(List<Integer> list) {
    return list.stream().reduce(Integer::min).get();
//    return list.stream().collect(Collectors.reducing(Integer::min)).get();
  }

  // Function to find minimum value in a List in Java 8 and above
  public static Integer findMin_StreamSorted(List<Integer> list) {
    return list.stream().sorted().findFirst().get();
  }

  // Function converting a string of digit into a set of digit
  public static Set<Integer> toSetOfDigit(String s) {
//    return s.chars().filter(c->Character.isDigit(c)).mapToObj(c->c-'0').collect(Collectors.toSet());
    return s.chars().filter(Character::isDigit).mapToObj(c->c-'0').collect(Collectors.toSet());
  }
}
