package playgames;

import java.util.Random;

public class RandomUtils {

  public static int generateRandom(int lower, int upper) {
    Random r = new Random();
    return r.nextInt(upper + 1) + lower;
  }
}
