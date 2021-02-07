package threadPractice.test.lock;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
  ReentrantLock lock = new ReentrantLock();

  private void printLoop() throws Exception {
    //    synchronized (this) {
    //      for (int i = 0; i < 5; i++) {
    //        System.out.println(Thread.currentThread().getName() + "  i= " + i);
    //        sleep(500);
    //        if (i == 3) throw new Exception("wtf");
    //      }
    //    }
    lock.lock();
    try {
      for (int i = 0; i < 5; i++) {
        System.out.println(Thread.currentThread().getName() + "  i= " + i);
        sleep(500);
        if (i == 3) throw new Exception("wtf");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      lock.unlock();
    }
  }

  public static void main(String[] args) {
    TestLock testLock = new TestLock();

    Thread t1 =
        new Thread(
            () -> {
              try {
                testLock.printLoop();
              } catch (Exception e) {
                e.printStackTrace();
              }
            },
            "t1");
    Thread t2 =
        new Thread(
            () -> {
              try {
                testLock.printLoop();
              } catch (Exception e) {
                e.printStackTrace();
              }
            },
            "t2");
    Thread t3 =
        new Thread(
            () -> {
              try {
                testLock.printLoop();
              } catch (Exception e) {
                e.printStackTrace();
              }
            },
            "t3");
    Thread t4 =
        new Thread(
            () -> {
              try {
                testLock.printLoop();
              } catch (Exception e) {
                e.printStackTrace();
              }
            },
            "t4");

    t1.start();
    t2.start();
    t3.start();
    t4.start();
  }

  private void sleep(long ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
