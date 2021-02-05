package threadPractice.sessionOne;

public class TestDemo {
  public static void main(String[] args) {
    //
    // System.out.println("Hello : thread name: " + Thread.currentThread().getName());

    MyThread myThread = new MyThread();
    myThread.start();
    //    myThread.run();

    for (int i = 0; i < 10; i++) {
      System.out.println("Main Thread: " + i);
    }
  }
}
