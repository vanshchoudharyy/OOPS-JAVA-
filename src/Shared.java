class Shared {
    synchronized void waitMethod() {
        System.out.println("waiting...");
        try {
            wait();
        } catch (Exception e) {
        }
        System.out.println("resumed");
    }

    synchronized void notifyMethod() {
        System.out.println("notifying...");
        notify();
    }
}