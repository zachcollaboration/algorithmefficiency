package org.algorithmefficiency;

import java.util.Scanner;

/***
 * Computes the Factorial of a number
 * */
public class FactorialAlgorithmMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scannerInput = new Scanner(System.in);

		// Value to search
		System.out.print(" Please enter the value to compute the factorial  : ");
		Integer key = null;

		try {
			key = scannerInput.nextInt();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Algorithm algorithm = new Algorithm();
		algorithm.computeFactorial(key);
		
		scannerInput.close();	}

}
