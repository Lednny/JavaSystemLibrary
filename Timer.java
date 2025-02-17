import java.util.concurrent.TimeUnit;

public class Timer {
  public static void main(String[] args) {
    try {
      for (int i = 0; i < 2; i++) {
        TimeUnit.SECONDS.sleep(1);
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}