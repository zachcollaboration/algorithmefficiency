package org.algorithmefficiency;

import java.util.Scanner;

/***
 * Computes the Fibonacci by calling the 
 * nthFibonacci
 * */
public class FibonacciAlgorithmMain {

	public static void main(String[] args) {

		Scanner scannerInput = new Scanner(System.in);

		// Value to search
		System.out.print(" Please enter the value to compute Fibonacci  : ");
		Integer key = null;

		try {
			key = scannerInput.nextInt();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Algorithm algorithm = new Algorithm();
		algorithm.nthFibonacci(key);
		
		scannerInput.close();	}

}
