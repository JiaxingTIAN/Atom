public class Solution{
    //Synchronized method cannot be called by different thread at same time
    //All synchronized method of a instance share the same lock
    //Static synchronized methods of same class cannot be called at same time
    //Reentrant locking, the thread that holds the lock can acquire the same lock
    //A thread can call a synchronized method recursivly and can itself call other synchronized methods within the same object
    public static synchronized void printMap(Map mp) {  //Obtain the lock of the class
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
    }
    public static void main(String[] args){
        Map<String, Integer> syncMap = Collections.synchronizedMap(new TreeMap<>());
        synchronized(syncMap){     //Obtian the lock of the syncList
            syncList.add("Star");
            syncList.add("Loves");
            syncList.add("Offers");
        }
        synchronized(this){     //Obtain the lock of this (class - if static/instance - if instance method)
            //Synchronized block
        }
   
        Map<String, Object> map = ...;
        //If you're only interested in the keys, you can iterate through the keySet() of the map:
        for (String key : map.keySet()) {
            // ...
        }
        //If you only need the values, use values():

        for (Object value : map.values()) {
            // ...
        }
        //Finally, if you want both the key and value, use entrySet():
        for(Entry<String, Object> entry:map.entrySet()){
            String key = entry.getKey();
            Object value = entry.getValue();
            //...do something
            System.out.printIn("The key is " + entry.getKey() + "\n The value is" + entry.getValue());
        }
        //Java 8 support for anomyous function
        Runnable runnable = () -> {
        try {
            String name = Thread.currentThread().getName();
            System.out.println("Foo " + name);
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Bar " + name);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
};

Thread thread = new Thread(runnable);
thread.start();
        
    }
    
    class animate implements Runnable{
        Thread myThread;
        private Lock myLock;
        public animate(){
        };
        public void animateStart(){
            //Create the object and it starts run the thread with run()
            myThread = new Thread(this);
            myThread.start();
            //myThread.stop(); wait(), notify();
        }
        @Override
        public void run(){
            myLock.lock();
            Thread.sleep(3000); //sleep static method of Thread
            myLock.unlock();
        }
    }
}

