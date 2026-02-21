
class message implements Runnable{
    String message;
    message (String message){
        this.message = message;
    }
    @Override
    public void run() {
        System.out.println(message);
    }
}