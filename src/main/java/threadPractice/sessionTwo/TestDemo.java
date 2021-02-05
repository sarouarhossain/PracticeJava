package threadPractice.sessionTwo;

public class TestDemo {
  public static void main(String[] args) {
    //
    //    Thread myThread = new MyThread();
    //    myThread.start();
    Runnable runnable = new MyRunnable();
    Thread thread = new Thread(runnable);
    // thread.start();
    thread.run();

    for (int i = 0; i < 10; i++) {
      System.out.println("From Main Thread: " + i);
    }
  }
}
