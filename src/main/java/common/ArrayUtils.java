package common;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayUtils {
  public static void reverse(int[] nums) {
    for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
      int n = nums[i];
      nums[i] = nums[j];
      nums[j] = n;
    }
  }

  public static void sortReverse(int[] nums) {
      Arrays.sort(nums);
      reverse(nums);
  }

  public static List<Integer> toList(int[] nums) {
    return Arrays.stream(nums).boxed().collect(Collectors.toList());
  }

  public static List<Long> toList(long[] nums) {
    return Arrays.stream(nums).boxed().collect(Collectors.toList());
  }
}
