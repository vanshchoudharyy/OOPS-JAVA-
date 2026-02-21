class BasicThreadExample{
    public static void main(String[] args){
        Runnable task = () -> {
            for(int i = 1; i<=5 ; i++){
                System.out.println(Thread.currentThread().getName()+ "," +i);
            }
        };
        Thread t1= new Thread(task, "thread-1");
        Thread t2= new Thread(task, "thread-2");

        t1.start();
        t2.start();
    }
}