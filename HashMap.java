public class Solution{
    //Synchronized method cannot be called by different thread at same time
    //Static synchronized methods of same class cannot be called at same time
    public static synchronized void printMap(Map mp) {
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
    }
    public static void main(String[] args){
        Map<String, Integer> syncList = Collections.synchronizedMap(new TreeMap<>());
        synchronized(syncList){
            syncList.add("Star");
            syncList.add("Loves");
            syncList.add("Offers");
        }
        synchronized(this){
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
        
    }
    
    class animate implements Runnable{
        Thread myThread;
        private Lock myLock;
        public animate(){
            //Create the object and it starts run the thread with run()
            myThread = new Thread(this);
            myThread.start();
        }
        @Override
        public void run(){
            myLock.lock();
            Thread.sleep(3000); //sleep static method of Thread
            myLock.unlock();
        }
    }
}

