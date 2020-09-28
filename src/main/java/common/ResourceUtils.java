package common;

import java.io.File;
import java.util.Objects;

public class ResourceUtils {
  public static File getFileFromResource(String name) {
    return new File(Objects.requireNonNull(ResourceUtils.class.getClassLoader().getResource(name)).getFile());
  }

  public static void main(String[] args) {
    System.out.println(Integer.MAX_VALUE);
    System.out.println(Integer.MIN_VALUE);
  }
}
