/*answer:
2
-2
2
-2
3
-3
4
-4
3
-3
5
-5
6
-6
4
-4
7
-7
5
-5
8
-8
9
-9
6
-6
7
-7
10
-10
8
-8
11
-11
9
-9
12
-12
13
-13
10
-10
11
-11
14
-14
12
-12
13
-13
15
-15
16
-16
14
-14
17
-17
15
-15
18
-18
19
-19
16
-16
17
-17
18
-18
20
-20
19
-19
21
-21
Thread Ti finished, the value of shared is now 21Thread Ti finished, the value of shared is now -2120
-20
21
-21
Thread Ti finished, the value of shared is now 21Thread Ti finished, the value of shared is now -21*/

//I tried twice, I think this one is better even is not perfect.Thank you. 






public class MyThread extends Thread {
	String name;
	 static int counter = 0;
	
	public MyThread(String name) {
		this.name = name;
	}
	
	public void run() {
		
		int shared1 = 0;
		int shared2= 0;
		int local_1=0;
		int local_2=0;
		
		
		
		for (int i=0;i<20;i++){
			counter++;
			
			//System.out.println("Counter = " + counter);

		
			
			//int local_i=shared;
			try {
				Thread.sleep((long)(Math.random()*500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			 local_1=local_1+1;
			 local_2=local_2-1;
				//for(i=1;i<3;i++){
					
			int amount_1=1;
			int amount_2=-1;
				//amount_i=amount_i-2;
			shared1=local_1+amount_1;
			shared2=local_2+amount_2;
			
			System.out.println(shared1);
			System.out.println(shared2);
			
			}
		System.out.print("Thread Ti finished, the value of shared is now "+ shared1);
		System.out.print("Thread Ti finished, the value of shared is now "+ shared2);
			

			
		}
		

	
	public static void main(String[] args) throws InterruptedException {
		MyThread T1 = new MyThread("A");
		MyThread T2 = new MyThread("B");
		T1.start();
		//threadA.join();		// wait for threadA to finish
		T2.start();
		T1.join();		// wait for threadA to finish
		T2.join();		// wait for threadB to finish

		
	}

}