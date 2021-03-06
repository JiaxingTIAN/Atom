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
        //Java 8 support for anonymous function just like lambda
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
        
        Queue<Integer> heap = new PriorityQueue<>( (a, b) -> b - a);    //Decreasing order
        heap.offer(4);
        heap.offer(6);
        heap.offer(3);
        heap.forEach(System.out::print);    //643
        
        // String to be scanned to find the pattern.
      String line = "This order was placed for QT3000! OK?";
      String pattern = "(.*)(\\d+)(.*)";

      // Create a Pattern object
      Pattern r = Pattern.compile(pattern);

      // Now create matcher object.
      Matcher m = r.matcher(line);
      if (m.find( )) {
         System.out.println("Found value: " + m.group(0) );
         System.out.println("Found value: " + m.group(1) );
         System.out.println("Found value: " + m.group(2) );
      }else {
         System.out.println("NO MATCH");
      }

    }
    
    class animate implements Runnable{
        Thread myThread;
        private Lock myLock = new ReentrantLock();
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
            //Old way:
            List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
            for(Integer n: list) {
                System.out.println(n);
            }
            //New way:
            list.forEach(n -> System.out.println(n));
            //or we can use :: double colon operator in Java 8
            list.forEach(System.out::println);
            myLock.unlock();
        }
    }
    
    //A Java abstract class is a class that can't be instantiated. That means you cannot create new instances of an abstract class. 
    //It works as a base for subclasses. At least one class must be abstract
    abstract class Book{
        String title;
        abstract void setTitle(String s);
        String getTitle(){
            return title;
        }
    }

    class MyBook extends Book{
        void setTitle(String s){
            title=s;
        }
    }

    // A interface only has the signature and fields
    // All method must be abstract
    interface AdvancedArithmetic {
        public abstract int divisorSum(int n);
    }

    class MyCalculator implements AdvancedArithmetic {
        public int divisor_sum(int n) {
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) ans += i;
            }
            return ans;
        }
    }
}

