package test;

import implementation.ProducerConsumerImpl;

public class ProducerConsumerTest {

	public static void main(String[] args) {
		ProducerConsumerImpl prodObj = new ProducerConsumerImpl();
		
		Thread prodThread = new Thread(new Runnable(){
			public void run(){
				try {
					prodObj.producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread conThread = new Thread(new Runnable(){
			public void run(){
				try {
					prodObj.consumer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		prodThread.start();
		conThread.start();
		
		try {
			prodThread.join();
			conThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
