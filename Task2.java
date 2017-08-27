package Kata;

//This file contains the Kata task 2,3

import java.util.Scanner;

public class Task2 {
	
	static String test1="7,3\n7\n5,6,8";//test Strings
	static String test2="0";
	static String test3="1\n4\n4";

	public static void main(String[] args) {
		String s;
		Task2 t1=new Task2();
		System.out.println("Sum:"+t1.Add(test1));
		return;
	}	

	private int Add(String numbers) {
	int stsum = 0;
	
	String nums= numbers;
	if(nums.length() == 0) {	
		return 0;	
	}else {
		String numb = nums.replaceAll("[\\n]+", ",");// replce \n in the string with , for splitting
		String[] numlist=numb.split(",");			
		for(int i=0; i < numlist.length; i++) {
		stsum += Integer.parseInt(numlist[i]);
		}
	return stsum ;
	}
  }
	
	
}
