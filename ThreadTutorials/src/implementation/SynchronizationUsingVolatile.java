package implementation;

public class SynchronizationUsingVolatile extends Thread {
	//volatile indicates to the thread that the value of running can be changed by multiple threads
	public volatile boolean running  = true;
	
	public void run(){
		while(running){
			System.out.println("Hello");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown(){
		running = false;
	}
}
