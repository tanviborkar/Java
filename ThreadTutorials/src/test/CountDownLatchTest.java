package test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import implementation.CountDownLatchImpl;

public class CountDownLatchTest {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(5);
		ExecutorService exServ = Executors.newFixedThreadPool(3);
		for(int i=0; i<5; i++){
			exServ.submit(new CountDownLatchImpl(latch));
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("All threads completed");
	}
}
