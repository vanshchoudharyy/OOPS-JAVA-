class Resource {
    public synchronized void method1(Resource r){
        System.out.println("thread 1 locked resorce 1");
        try{
            Thread.sleep(5000);
        }catch (Exception e){}
        System.out.println("thread 1 is waiting for resource 2");
        r.method2(this);
    }
    public synchronized void method2(Resource r){
        System.out.println("thread 2 locked resource 2");
        try{
            Thread.sleep(2000);
        }catch(Exception e){}
        System.out.println("thread 2 waiting for resource 2");
        r.method1(this);
    }
}