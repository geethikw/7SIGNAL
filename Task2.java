package Kata;

//This file contains the Kata task 2,3

import java.util.Scanner;

public class Task2 {
	private static Scanner in;
	public static void main(String[] args) {
		String s;
		Task2 t1=new Task2();
		
		System.out.print("Enter the String:");//getting input String of any length from console
		in = new Scanner(System.in);
		s = in.next();
		System.out.println("Sum:"+t1.Add(s));

		return;
	}	

	private int Add(String numbers) {
		
	int stsum = 0;
	String nums= numbers;
	if(nums.length() == 0) {	
		return 0;	
	} else {
		String numb = nums.replaceAll("[\\\\r\\\\n]+", ","); // replce \n in the string with , for splitting
		String[] numlist=numb.split(",");			
		for(int i=0; i < numlist.length; i++) {
		stsum += Integer.parseInt(numlist[i]);
		}
	return stsum ;
		
	}
  }
	
	
}
