package arrays.array_manipulation;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayManipulationTest {

  @Test
  public void testArrayManipulation() {
    int n = 5;
    int[][] queries = {
            {1,2,100},
            {2,5,100},
            {3,4,100}
    };
    ArrayManipulation solution = new ArrayManipulation();
    assertEquals(solution.arrayManipulation(n, queries), 200);
  }
}