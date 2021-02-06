package threadPractice.sessionThree;

import java.time.Duration;
import java.time.Instant;

public class TestDemo {
  public static void main(String[] args) throws InterruptedException {
    //
    var startTime = Instant.now();

    Runnable runnableOne =
        () -> {
          for (int i = 1; i <= 10; i++) {
            System.out.println("Thread Name: " + Thread.currentThread().getName() + " i : " + i);
            sleep(500);
          }
        };

    Runnable runnableTwo =
        () -> {
          for (int j = 1; j <= 10; j++) {
            System.out.println("Thread Name: " + Thread.currentThread().getName() + " j : " + j);
            sleep(500);
          }
        };

    Runnable runnableThree =
        () -> {
          for (int k = 1; k <= 10; k++) {
            System.out.println("Thread Name: " + Thread.currentThread().getName() + " k : " + k);
            sleep(500);
          }
        };

    Thread threadOne = new Thread(runnableOne);
    Thread threadTwo = new Thread(runnableTwo);
    Thread threadThree = new Thread(runnableThree);

    threadOne.start();
    threadTwo.start();
    threadThree.start();

    threadOne.join();
    threadTwo.join();
    threadThree.join();
    var endTime = Instant.now();
    System.out.println("Total Execution time : " + Duration.between(startTime, endTime).toMillis());
  }

  public static void sleep(long sleepMs) {
    try {
      Thread.sleep(sleepMs);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
