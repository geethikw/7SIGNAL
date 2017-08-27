package Kata;

import java.util.Arrays;

//This file contains the kata task 4, suuport different delimiters //;\n


public class Task4 {
	//test Strings
	static String test1="\\;\n4;4\n5;6;7";
	static String test2="0";
	static String test3="1,4\n4";

	public static void main(String[] args) {
		Task4 t1=new Task4();
		System.out.println("Sum:"+t1.Add(test1));
		return;
	}	

	private int Add(String numbers) {
	int stsum = 0;
	//System.out.println("This is the original string: "+ numbers);

	
	if(numbers.length() == 0) {	
		
		return 0;
		
	}else {

	if(numbers.contains("\\")==true) {
	int index2= numbers.indexOf("\n");
	
	   String delimiter = numbers.substring(1, index2); 
	   String numb1 = numbers.substring(index2+1);
	   String numb = numb1.replaceAll("[\\n]+", delimiter);
	   String[] numlist=numb.split(delimiter);			
		
	   for(int i=0; i < numlist.length; i++) {
		stsum += Integer.parseInt(numlist[i]);
		}
	return stsum ;
	
	}else{
		
		String numb = numbers.replaceAll("[\\n]+", ","); // replce \n in the string with , for splitting
		String[] numlist=numb.split(",");			
		for(int i=0; i < numlist.length; i++) {
		stsum += Integer.parseInt(numlist[i]);
		}
	return stsum ;
	}
   }
}
	
}
