package threadPractice.sessionOne;

public class MyThread extends Thread {
  //  @Override
  //  public synchronized void start() {
  //    super.start();
  //  }

  @Override
  public void run() {
    System.out.println("Hello from , thread name: " + Thread.currentThread().getName());
    for (int i = 0; i < 10; i++) {
      System.out.println("My Thread: " + i);
    }
  }
}
