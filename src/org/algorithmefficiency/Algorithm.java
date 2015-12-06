package org.algorithmefficiency;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/*****
 * The Algorithms are here
 * */
public class Algorithm {
	
	private static int level = 0;
	private static PrintWriter writer;
	
	
	
	/***
	 * Recursive Binary Search
	 * */
	public void recursiveBinarySearch(Integer value){
		List<Integer> searchList = getSearchList();
		
		int foundPosition = -1;
		
		Integer lowerPosition = 0;
		Integer upperPosition = (searchList.size() - 1);
		foundPosition = recursiveBinarySearch(searchList, value, lowerPosition, upperPosition);
		
		if (foundPosition != -1){
			System.out.println(value+" found at Position  "+foundPosition);
		} else{
			System.out.println(value+" not found in the list");
		}
		
	}
	
	/****
	 * The recursive search method - it exists when either the value is found or
	 * is determined not to be in the list
	 * */
	private int recursiveBinarySearch(List<Integer> searchList, Integer value,
			Integer lowerPosition, Integer upperPosition) {
		// TODO Auto-generated method stub
		
		System.out.println(" Level "+level+" PPPPPPPP Lower Position "+lowerPosition+" Upper position "+upperPosition);
		level = level + 1;
		if (upperPosition < lowerPosition)
		{
			return -1;
		} else {
			
			//Calculate mid point
			Integer midpoint = lowerPosition + ((upperPosition - lowerPosition) / 2);
			
			//the value is in lower half
			if (searchList.get(midpoint) > value){
				return recursiveBinarySearch(searchList, value, lowerPosition, midpoint - 1);
			} else if (searchList.get(midpoint) < value){
				return recursiveBinarySearch(searchList, value, midpoint + 1, upperPosition);
			} else{
				return midpoint;
			}
		}
	}

	/***
	 * Factorial of N
	 * */
	public void computeFactorial(Integer value){
		
		System.out.println(" factorial("+(value)+") ");
		int factorial = calculateFactorial(value);
		
		System.out.println("The factorial of "+value+" is "+factorial);
		
		
	}
	
	private int calculateFactorial(Integer value) {
		int factorial;
		
		level = level + 1;

		if (value == 1){
			System.out.println(value);
			return 1;
		}
		
		System.out.println(value+" * factorial("+(value-1)+") ");
		
		factorial = calculateFactorial(value - 1) * value;
		
		return factorial;
	}

	/**
	 * Nth Fibonacci
	 * */
	public void nthFibonacci(Integer value){
		
		//System.out.println("Writing to a file starts here !!");
		PrintWriter writer;
		try {
			writer = new PrintWriter("fibonaccidata.txt", "UTF-8");
			int count = 0;
			//Generate Sequential Data for testing best case
			
			while (count < (value * 2)){
				//writer.print("*");
				count++;
			}
			writer.print("fib("+value+")");
			count = 0;
			while (count < (value * 2)){
				//writer.print("*");
				count++;
			}
			writer.println("");
			int result = fibonacci(value, writer);
			System.out.println(" Fibonacci of "+value+" is "+result);
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private int fibonacci(Integer value, PrintWriter writer) {
		//System.out.println(" Level "+level+" PPPPPPPP Fibonacci "+value);
		level =  level + 1;
		if (value == 0){
			System.out.println("");
			System.out.println("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
			System.out.println(" Level "+level+"  fib ("+value+")");
			System.out.println(" Level "+level+" -- is -- ");
			System.out.println(" Level "+level+"  fib ("+value+")");
			printOutTheValues(value, writer);
			return 0;
		}
		else if (value == 1){
			System.out.println("");
			System.out.println("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
			System.out.println(" Level "+level+"  fib ("+value+")");
			System.out.println(" Level "+level+" -- is -- ");
			System.out.println(" Level "+level+"  fib ("+value+")");
			printOutTheValues(value, writer);
			return 1;
		}
		System.out.println("");
		System.out.println("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
		System.out.println(" Level "+level+"  fib ("+value+")");
		System.out.println(" Level "+level+" -- is -- ");
		System.out.println(" Level "+level+"  fib ("+(value - 1)+")   ------------------- "+"  fib ("+(value - 2)+")");
		
		printOutTheValues(value, writer);
		
		return fibonacci(value - 1, writer) + fibonacci(value - 2, writer);
	}

	private void printOutTheValues(Integer value,PrintWriter writer) {
		// TODO Auto-generated method stub
		int count = 0;
		//Generate Sequential Data for testing best case
		
		while (count < (value * 2)){
			writer.print("*");
			count++;
		}
		writer.print("fib("+value+")");
		count = 0;
		while (count < (value * 2)){
			writer.print("*");
			count++;
		}
		writer.println("");
	}

	public List<Integer> getSearchList(){
		List<Integer> sortList = new ArrayList<Integer>();
		try (BufferedReader br = new BufferedReader(new FileReader("data.txt")))
		{

			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				//System.out.println(++count +": "+sCurrentLine);
				sortList.add(Integer.valueOf(sCurrentLine));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		//Sort the search list
		sortList = bubbleSort(sortList);
		
		return sortList;
	}
	
	private List<Integer> bubbleSort(List<Integer> sortList) {
		Boolean swapped = false;
		//System.out.println("Doing a bubble sort run !!!");
		int position = 0;
		while (position < sortList.size() - 1){
			
			if (sortList.get(position) > sortList.get(position + 1))
			{
				//swap
				Integer temporary = sortList.get(position);
				
				sortList.set(position, sortList.get(position + 1));
				sortList.set((position + 1), temporary);
				
				swapped = true;
				
			}
			
			position++;
		}
		
		if (swapped){
			bubbleSort(sortList);
		}
		
		
		return sortList;
	}

}
