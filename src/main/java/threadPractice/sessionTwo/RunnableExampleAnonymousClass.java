package threadPractice.sessionTwo;

public class RunnableExampleAnonymousClass {
  public static void main(String[] args) {
    //
    Runnable runnable =
        new Runnable() {
          @Override
          public void run() {
            System.out.println("Thread name: " + Thread.currentThread().getName());
            for (int i = 0; i < 10; i++) {
              System.out.println("From Child Thread Runnable: " + i);
            }
          }
        };

    Thread thread = new Thread(runnable);
    thread.start();
  }
}
