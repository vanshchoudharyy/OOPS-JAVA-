public class Main {
    public static void main(String[] args) throws InterruptedException {
        Shared s = new Shared();

        Thread t1 = new Thread(() ->
                s.waitMethod());
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }
            s.notifyMethod();
        });
        t1.start();
        t2.start();
    }
}


