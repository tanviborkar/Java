package implementation;

public class ThreadPoolImpl implements Runnable {
	private int id;
	
	public ThreadPoolImpl(int id){
		this.id = id;
	}
	
	public void run(){
		System.out.println("Starting task "+id);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Completed task "+id);
	}
}
