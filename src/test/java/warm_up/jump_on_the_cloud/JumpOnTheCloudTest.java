package warm_up.jump_on_the_cloud;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class JumpOnTheCloudTest {

  @Test
  public void testJumpingOnClouds() {
    int[] c = {0, 0, 1, 0, 0, 1, 0};
    JumpOnTheCloud solution = new JumpOnTheCloud();
    assertEquals(solution.jumpingOnClouds(c), 4);
  }
}
