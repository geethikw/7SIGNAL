package Kata;

//This file contains the kata task 1st step with String test.

import java.util.Scanner;

public class Task1 {
	static String test1="1,4,4,5";//test Strings
	static String test2="0";
	static String test3="1,4,4";

	public static void main(String[] args) {
		Task1 t1=new Task1();
		System.out.println("Sum:"+t1.Add(test1));
		return;
	}	

	private int Add(String numbers) {
	int stsum = 0,length=0;
	String[] numlist;
	String nums= numbers;
	if(nums.length() == 0) {	
		return 0;	
	}else {
		numlist=nums.split(",");
		if(numlist.length > 3) { //limit to length maximum only to 3
			length=3;
		}else {
			length=numlist.length;
		}
		for(int i=0; i < length; i++) {
			stsum += Integer.parseInt(numlist[i]);
			
		}
	return stsum ;
	}
  }
	
	
}
