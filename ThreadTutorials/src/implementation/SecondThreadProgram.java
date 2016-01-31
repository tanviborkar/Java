package implementation;

public class SecondThreadProgram extends Thread {
	private Thread threadObj;
	private String threadName;
	private String msgForDisplay;
	
	public SecondThreadProgram(String threadName, String msgForDisplay) {
		this.threadName = threadName;
		this.msgForDisplay = msgForDisplay;
		System.out.println("Creating thread "+threadName);
	}

	public void run(){
		System.out.println("Running thread "+threadName);
		for(int i=0; i<5; i++){
			System.out.println(msgForDisplay);
			try {
				threadObj.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Exiting thread "+threadName);
	}
	
	public void start(){
		System.out.println("Starting thread "+threadName);
		if(threadObj == null){
			threadObj = new Thread(this, threadName);
			threadObj.start();
		}
	}
}
