package implementation;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchImpl implements Runnable{
	private CountDownLatch latch;
	
	public CountDownLatchImpl(CountDownLatch latch){
		this.latch = latch;
	}
	
	public void run(){
		System.out.println("Thread Started");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		latch.countDown();
	}
}
