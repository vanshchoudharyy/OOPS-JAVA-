class Numberthread extends Thread{
    @Override
    public void run(){
        for(int i=1;i<=5;i++){
            System.out.println("number" +i);
        }
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                System.out.println(e);
            }
    }
}

