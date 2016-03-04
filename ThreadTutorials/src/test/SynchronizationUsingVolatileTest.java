package test;

import java.util.Scanner;

import implementation.SynchronizationUsingVolatile;

public class SynchronizationUsingVolatileTest {

	public static void main(String[] args) {
		SynchronizationUsingVolatile thread = new SynchronizationUsingVolatile();
		thread.start();
		
		System.out.println("Press return to stop thread execution");
		Scanner input = new Scanner(System.in);
		input.nextLine();
		input.close();
		
		thread.shutdown();
	}
}
