class Producer implements Runnable {
    private SharedBuffer buffer;

    public Producer(SharedBuffer buffer){
        this.buffer = buffer;
    }
    public void run(){
        int value = 0;
        try{
            while(true){
                buffer.produce(value++);
                Thread.sleep(5);
            }
        } catch (InterruptedException e) {}
        }
    }
