class OddThread implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i<=10; i= i+2){
            System.out.println("odd:" +i);
        }
        try{
            Thread.sleep(5000);
        }catch (Exception e) {}
    }
}
