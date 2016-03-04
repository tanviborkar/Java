package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import implementation.ThreadPoolImpl;

public class ThreadPoolTest {

	public static void main(String[] args) {
		ExecutorService exServ = Executors.newFixedThreadPool(3);
		for(int i=0;i<5;i++){
			exServ.submit(new ThreadPoolImpl(i));
		}
		exServ.shutdown();
		try {
			exServ.awaitTermination(1, TimeUnit.NANOSECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
		
}
