package Kata;

//This file contains the kata task 1st step with String test.

import java.util.Scanner;

public class Task1 {
	static String test="1,4";
	//private static Scanner in;
	public static void main(String[] args) {
		Task1 t1=new Task1();
		System.out.println("Sum:"+t1.Add(test));
		return;
	}	

	private int Add(String numbers) {
	int stsum = 0;
	String[] numlist;
	String nums= numbers;
	if(nums.length() == 0) {	
		return 0;	
	}else {
		numlist=nums.split(",");			
		
		for(int i=0; i < numlist.length; i++) {
		stsum += Integer.parseInt(numlist[i]);
		}
	return stsum ;
	}
  }
	
	
}
