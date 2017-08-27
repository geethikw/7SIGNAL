package Kata;


//This file contains the kata task 7, suport different delimiters //;\n
public class Task7 {
	//test Strings
	static String test1="\\****\n4****4\n5****6****7";
	static String test2="0";
	static String test3="1,4\n4";
	int k=0; 
	int errorflag=0;

	public static void main(String[] args) {
		Task7 t1=new Task7();
		int str_sum= t1.Add(test1);
		
		if(str_sum<0)
			System.out.println("Error occured: Negatives not allowed in the String.");
		else {
			System.out.println("Sum:"+str_sum);
		}
		return;
	}	

	@SuppressWarnings("null")
	private int Add(String numbers) {
	int stsum = 0;
	//System.out.println("This is the original string: "+ numbers);

	
	if(numbers.length() == 0) {	
		
		return 0;
		
	}else {
	int a ;
	if(numbers.contains("\\")==true) {
	int index2= numbers.indexOf("\n");
	
	   String delimiter = numbers.substring(1, index2); 
	   System.out.println("Delimiter:"+delimiter);
	   
	   int len=delimiter.length();
	   char[] del= delimiter.toCharArray();
	   char[] newdel = new char[2*(len)];
	   int y=0;
	   char t= '\\' ;
	   
	   for(int j=0;j<len-1;j++) {
		   newdel[y++]= t;
		   newdel[y++]=del[j];
		   
	   }
	   newdel[y++]= t;
	   newdel[2*(len)-1]= del[len-1];
	   String deli=String.valueOf(newdel);
	  // System.out.println(deli);
	   
	   String numb = numbers.substring(index2+1);
	   String numb1 = numb.replaceAll("[\\n]+", delimiter);
	   String[] numlist=numb1.split(deli);			
		
	   for(int i=0; i < numlist.length; i++) {
		   a=Integer.parseInt(numlist[i]);
		   if(a<0) {
				errorflag=1;
				System.out.print(a+",");
				k++;
			}else {
				if(a > 1000) {
					
				}else {
					stsum += a;
				}
			}
		}
	   
	}else{
		String numb = numbers.replaceAll("[\\n]+", ","); // replce \n in the string with , for splitting
		String[] numlist=numb.split(",");			
		for(int i=0; i < numlist.length; i++) {
		a =	Integer.parseInt(numlist[i]);
		if(a < 0) {
			errorflag=1;
			System.out.println(a+ ",");
			k++;
		}else {
			if(a > 1000) {
				
			}else {
				stsum += a;
			}
		}
	}
   }
	if(errorflag==1) {
		return -1;
	}else {
	return stsum ;
	}
}
}
	
}
