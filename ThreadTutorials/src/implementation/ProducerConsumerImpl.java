package implementation;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerImpl {
	private BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
	
	Random random = new Random();
	
	public void producer() throws InterruptedException{
		while(true){
			queue.put(random.nextInt(1000));
		}
	}
	
	public void consumer() throws InterruptedException{
		while(true){
			Thread.sleep(100);
			if(random.nextInt(10) == 1){
				Integer value = queue.take();
				System.out.println("Value Returned : "+value+"; Queue Size: "+queue.size());
			}
		}
	}
}
