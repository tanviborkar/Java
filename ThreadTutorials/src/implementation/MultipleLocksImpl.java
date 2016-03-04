package implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MultipleLocksImpl {
	//Class to randomly generate a number
	Random random = new Random();
	
	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();
	
	//use two different locks to restrict simultaneous access to two different functions
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	
	//function to add elements to list1
	public void stageOne(){
		//ensures that only the thread having lock1 can modify list1
		synchronized(lock1){
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list1.add(random.nextInt(1000));
		}
	}
	
	//function to add elements to list one
	public void stageTwo(){
		//ensures that only the thread having lock2 can modify list2
		synchronized(lock2){
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list2.add(random.nextInt(1000));
		}
	}
	
	//function to call the two stages of the project
	public void process(){
		for(int i=0; i<1000; i++){
			stageOne();
			stageTwo();
		}
	}
	
	public void main(){
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				process();
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				process();
			}
		});
		
		long startTime = System.currentTimeMillis();
		t1.start();	
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Running Time: "+(endTime - startTime));
		System.out.println("List1 size: "+list1.size() +"; List2 size: "+list2.size());
	}
}
