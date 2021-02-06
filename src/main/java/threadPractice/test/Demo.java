package threadPractice.test;

import java.time.Duration;
import java.time.Instant;

public class Demo {
  public static void main(String[] args) throws InterruptedException {
    //
    var timeBefore = Instant.now();
    // Thread.sleep(100);
    Runnable runnableOne =
        () -> {
          for (int i = 1; i <= 10; i++) {
            System.out.println("Thread name: " + Thread.currentThread().getName() + " i = " + i);
            sleep(500);
          }
        };

    Runnable runnableTwo =
        () -> {
          for (int j = 1; j <= 10; j++) {
            System.out.println("Thread name: " + Thread.currentThread().getName() + " j =" + j);
            sleep(500);
          }
        };

    Runnable runnableThree =
        () -> {
          for (int k = 1; k <= 10; k++) {
            System.out.println("Thread name: " + Thread.currentThread().getName() + " k =" + k);
            sleep(500);
          }
        };

    Thread threadOne = new Thread(runnableOne, "threadOne");
    Thread threadTwo = new Thread(runnableTwo, "threadTwo");
    Thread threadThree = new Thread(runnableThree, "threadThree");

    threadOne.start();
    threadTwo.start();
    threadThree.start();

    threadOne.join();
    threadTwo.join();
    threadThree.join();

    var timeAfter = Instant.now();
    System.out.println(
        "Total Execution Time: " + Duration.between(timeBefore, timeAfter).toMillis());
  }

  public static void sleep(long timeInMs) {
    try {
      Thread.sleep(timeInMs);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
