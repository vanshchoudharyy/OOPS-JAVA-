public class Main {
    public static void main(String[] args){
        NumberPrinter np = new NumberPrinter();
        Thread t1 = new Thread(() -> np.printodd());
        Thread t2 = new Thread(() -> np.printeven());

        t1.start();
        t2.start();
    }
}