package arrays.merge_sort_counting_inversions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MergeSortCountingInversionsTest {

  @Test
  public void testCountInversions() {
    // 1 1 1 2 2
    // ans = 0
    // 2 1 3 1 2
    // ans = 4
    MergeSortCountingInversions solution =
            new MergeSortCountingInversions();
    int[] arr1 = {1,1,1,2,2};
    long ans1 = 0;
    int[] arr2 = {2,1,3,1,2};
    long ans2 = 4;
    assertEquals(solution.countInversions(arr1), ans1);
    assertEquals(solution.countInversions(arr2), ans2);
  }
}