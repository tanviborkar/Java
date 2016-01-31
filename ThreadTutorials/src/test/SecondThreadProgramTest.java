package test;

import implementation.SecondThreadProgram;

public class SecondThreadProgramTest {

	public static void main(String[] args) {
		SecondThreadProgram thread1 = new SecondThreadProgram("Thread 1", "I love Roger Federer");
		thread1.start();
		
		SecondThreadProgram thread2 = new SecondThreadProgram("Thread 2", "I love Harry Potter");
		thread2.start();
	}
}
