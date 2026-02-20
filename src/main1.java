public class main1{
    public static void main(String[] args){
        SharedBuffer buffer = new SharedBuffer();

        Thread producer = new Thread(new Producer(buffer));
        Thread consumer = new Thread(new Consumer(buffer));

        producer.start();
        consumer.start();
    }
}