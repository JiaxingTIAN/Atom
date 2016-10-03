class XThread extends Thread {

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
}

public class ThreadExample {

	public static void main(String[] args) {
		Thread thread1 = new Thread(new XThread(), "thread1");
		Thread thread2 = new Thread(new XThread(), "thread2");
		//	    The below 2 threads are assigned default names
		Thread thread3 = new XThread();
		Thread thread4 = new XThread();
		Thread thread5 = new XThread("thread5");
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
