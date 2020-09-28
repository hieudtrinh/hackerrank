package common;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringUtils {
  public static Set<Character> toSetOfCharacter(String s, char excludeChar) {
    return s.chars()
        .filter(c -> c != excludeChar)
        .mapToObj(c -> (char) c)
        .collect(Collectors.toSet());
  }

  public static List<Integer> toListOfInteger(String s, String sep) {
    return Arrays.stream(s.split(sep))
        .mapToInt(item -> Integer.parseInt(item.trim()))
        .boxed()
        .collect(Collectors.toList());
  }

  public Map<Character, Integer> createFrequencyMap(String s) {
    Map<Character, Integer> freq = new HashMap<>();
    for (char c : s.toCharArray()) {
      freq.put(c, freq.getOrDefault(c, 0) + 1);
    }
    return freq;
  }

  public Map<Character, Long> createFrequencyMap2(String s) {
    return s.chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

  public static String runLengthEncode(String s) {
    StringBuilder sb = new StringBuilder();
    String regex = "(.)\\1+";
    Pattern pattern = Pattern.compile(regex);
    Matcher m = pattern.matcher(s);
    while (m.find()) {
      sb.append(m.group().charAt(0)).append(m.group().length());
    }
    return sb.toString();
  }

  public static String countAndSay(String s) {
    StringBuilder sb = new StringBuilder();
    // group any character by it consecutive count
    String regex = "(.)\\1*";
    Pattern pattern = Pattern.compile(regex);
    Matcher m = pattern.matcher(s);
    while (m.find()) {
      sb.append(m.group().length()).append(m.group().charAt(0));
    }
    return sb.toString();
  }
}
