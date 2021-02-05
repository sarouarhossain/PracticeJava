package threadPractice.sessionTwo;

public class RunnableExampleLambdaExpression {
  public static void main(String[] args) {
    //
    Runnable runnable =
        () -> {
          System.out.println("Thread name: " + Thread.currentThread().getName());
          for (int i = 0; i < 10; i++) {
            System.out.println("From Child Thread Runnable: " + i);
          }
        };

    Thread thread = new Thread(runnable);
    thread.start();
  }
}
