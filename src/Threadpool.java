import java.util.concurrent.*;
class MyRunnable implements Runnable{
public void run() {
    System.out.println("runnable is running" + Thread.currentThread().getClass());
}
}
class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("Callable is running by "
                + Thread.currentThread().getName());
        return 100;
    }
}