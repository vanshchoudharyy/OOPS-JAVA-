public class Main {
    public static void main(String[] args) {

        Thread t1obj = new Thread(() -> {
            System.out.println("hello from thread 1");
        });
        Thread t2obj = new Thread(() -> {
            System.out.println("hello from thread 2 ");
        });
        Thread t1 = new Thread(t1obj);
        Thread t2 = new Thread(t2obj);
        t1.start();
        t2.start();
    }
}