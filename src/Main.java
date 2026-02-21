public class Main {
    public static void main(String[] args) {

        EvenThread even = new EvenThread();
        OddThread odd = new OddThread();

        Thread t1 = new Thread(even);
        Thread t2 = new Thread(odd);
        t1.start();
        t2.start();
    }
}