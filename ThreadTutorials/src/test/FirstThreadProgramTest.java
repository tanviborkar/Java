package test;

import implementation.FirstThreadProgram;

public class FirstThreadProgramTest {

	public static void main(String[] args) {
		FirstThreadProgram thread1 = new FirstThreadProgram("Thread 1", "I love Roger Federer");
		thread1.start();
		
		FirstThreadProgram thread2 = new FirstThreadProgram("Thread 2", "I love Harry Potter");
		thread2.start();
	}
}
