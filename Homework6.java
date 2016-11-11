//0. In homework5, the T1 and T2 is competing with each other, this is critical section.
//1.Running more than one thread inside the same application does not by itself cause problems. The problems arise when multiple threads access the same resources. For instance the same 
//memory (variables, arrays, or objects), systems (databases, web services etc.) or files.
//2.when multiple threads compete for the resource, it is critial condition
//3.It should be: once a single thread is executing it, no other threads can execute it until the first thread has left the critical section
//4.Use lock() to synchronized block

/*answer: In thread T2, shared = -1
In thread T1, shared = 1
In thread T1, shared = 2
In thread T2, shared = 1
In thread T1, shared = 3
In thread T1, shared = 4
In thread T1, shared = 5
In thread T1, shared = 6
In thread T2, shared = 4
In thread T1, shared = 5
In thread T1, shared = 6
In thread T2, shared = 4
In thread T2, shared = 3
In thread T1, shared = 5
In thread T2, shared = 2
In thread T1, shared = 3
In thread T1, shared = 4
In thread T2, shared = 2
In thread T1, shared = 3
In thread T2, shared = 1
In thread T1, shared = 2
In thread T1, shared = 3
In thread T2, shared = 1
In thread T2, shared = 0
In thread T1, shared = 2
In thread T2, shared = 1
In thread T2, shared = 0
In thread T1, shared = 3
In thread T2, shared = 2
In thread T1, shared = 4
In thread T1, shared = 5
In thread T1, shared = 6
In thread T2, shared = 3
In thread T1, shared = 4
Thread T1 finished, the value of shared is now 4
In thread T2, shared = 2
In thread T2, shared = 1
In thread T2, shared = 0
In thread T2, shared = -1
In thread T2, shared = -2
In thread T2, shared = -3
Thread T2 finished, the value of shared is now -3*/
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Homework6 extends Thread {

	static Integer shared = 0;		// the shared variable, initialized to 0
	Random rand = new Random();
	public Lock mLock = new ReentrantLock();
	
	public Homework6(String name) {
		super(name);			// name is an instance variable in the Thread class
	}
	
	public void run() { 
		for (int i = 0; i < 20; i++) {
			Integer local = shared;  				// Thread reads in the value of shared
			try {
				Thread.sleep(rand.nextInt(500));	// Sleep for a random length of time (between 0 and 500ms)
			} catch (InterruptedException e1) {		// to simulates complicated computations
				e1.printStackTrace();				// performed on the value of local_i
			}
			mLock.lock();
			try{
			if (getName().equals("T1")) { 
				synchronized(shared){// The result of the "complicated computation"
					shared = local + 1;				// is stored in the variable shared.
				}
			} else {							// The two threads compute different values.
				synchronized(shared){
					shared = local -1 ;
				}
			}
			} finally{
				mLock.unlock();
			}
	
			System.out.println("In thread " + getName() + ", shared = " + shared);		// After each round, output current value of shared
			try {
				Thread.sleep(rand.nextInt(500));	// Sleep for a random length of time to simulate doing something else
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
		}
		
		System.out.println("Thread " + getName() + " finished, the value of shared is now " + shared);
	}
	
	public static void main(String[] args) {
		Homework6 t1 = new Homework6("T1");			// create the two threads
		Homework6 t2 = new Homework6("T2");

		t1.start();									// start the two threads
		t2.start();	
	}

}