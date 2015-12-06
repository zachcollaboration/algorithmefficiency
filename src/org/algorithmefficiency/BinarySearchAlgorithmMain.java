package org.algorithmefficiency;

import java.util.Scanner;

/****
 * Does Binary Search by calling the recursiveBinary Search from the
 * Algorithm class
 * */
public class BinarySearchAlgorithmMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scannerInput = new Scanner(System.in);

		// Value to search
		System.out.print(" Please enter the value to search  : ");
		Integer key = null;

		try {
			key = scannerInput.nextInt();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Algorithm algorithm = new Algorithm();
		algorithm.recursiveBinarySearch(key);
		
		scannerInput.close();

	}

}
