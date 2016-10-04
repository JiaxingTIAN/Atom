class XThread<T> extends Thread {
	T sample;	//Generic type
	
	XThread() {
	}
	XThread(String threadName) {
		super(threadName); // Initialize thread.
		System.out.println(this);
		start();
	}
	public void run() {
		//Display info about this particular thread
		System.out.println(Thread.currentThread().getName());
	}
	//If T is indicated by the class -> no need to re-indicate again in the method
	public void setT(T t){
		sample  = t;
	}
}

public class ThreadExample {
	AtomicBoolean autoBoolean = new AtomicBoolean();	//perform compound operation without synchronized block
	public static void main(String[] args) {
		Thread thread1 = new Thread(new XThread<String>(), "thread1");
		Thread thread2 = new Thread(new XThread<Integer>(), "thread2");
		//	    The below 2 threads are assigned default names
		Thread thread3 = new XThread<Integer>();
		Thread thread4 = new XThread<Double>();
		Thread thread5 = new XThread<String>("thread5");
		XThread t = thread1; 	//Reference no need to provide generic type
		//Start the threads
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		try {
	//The sleep() method is invoked on the main thread to cause a one second delay.
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
		}
		//Display info about the main thread
		System.out.println(Thread.currentThread());
	}
	//If not indicated by class, must add before return type
	public <T> void compare(T a, T b){
		return (int)a - (int) b;
	}
}

//Wait & Notify
//Main thread and thread b concurrent operate
//when main thread need result from b, it wait for b to complete
//b will notify if it is completed
public class ThreadA {
    public static void main(String[] args){
        ThreadB b = new ThreadB();
        b.start();
 
        synchronized(b){
            try{
                System.out.println("Waiting for b to complete...");
                b.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
 
            System.out.println("Total is: " + b.total);
        }
    }
}
 
class ThreadB extends Thread{
    int total;
    @Override
    public void run(){
        synchronized(this){
            for(int i=0; i<100 ; i++){
                total += i;
            }
            notify();
        }
    }
}
