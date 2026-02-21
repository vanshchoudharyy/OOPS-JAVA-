class MyThread implements Runnable{
    String message;

    MyThread(String message){
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(message);
    }
}