public class Main {
    public static void main(String[] args) throws InterruptedException {
        Resource r1 = new Resource();
        Resource r2 = new Resource();

        Thread t1 = new Thread(() ->
                r1.method1(r2));
        Thread t2 = new Thread(() ->
                r2.method2(r1));
        t1.start();
        t2.start();
    }
}
