package threadPractice.sessionThree;

public class Test {
  public static void main(String[] args) throws InterruptedException {
    System.out.println("Process Start : " + Thread.currentThread().getName());
    Runnable runnable =
        () -> {
          for (int i = 0; i < 10; i++) {
            System.out.println(" i: " + i);
            try {
              Thread.sleep(10);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        };

    Thread thread = new Thread(runnable);
    thread.start();
    thread.join(60);
    System.out.println("Process End : " + Thread.currentThread().getName());
  }
}
