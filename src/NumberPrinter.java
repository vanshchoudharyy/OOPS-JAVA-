class NumberPrinter {
    int number = 1;
    int max = 10;

    public synchronized void printodd(){
        while(number <= max ){
            if(number%2 == 0){
                try{
                    Thread.sleep(4000);
                    wait();
                }catch (Exception e) {}
            }else{
                System.out.println("Thread 1 is odd" + number);
                number++;
                notify();
            }
        }
    }
    public synchronized void printeven(){
        while(number <= max){
            if(number%2 == 1){
                try{
                    Thread.sleep(4000);
                    wait();
                }catch (Exception e) {}
            }else {
                System.out.println("Thread 2 is odd" + number);
                notify();
                number++;
            }
        }
    }
}