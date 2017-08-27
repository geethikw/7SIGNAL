package Kata;

import java.util.Arrays;

//This file contains the Kata task 8 allow multiple delimiters
public class Task8 {
	//test Strings
	static String test1="\\[*][%][&]\n4%4\n5%6*7"; //different delimiters
	static String test2="0";
	static String test3="1,4\n4,8,6";
	int k=0; 
	int errorflag=0;

	public static void main(String[] args) {
		Task8 t1=new Task8();
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
		 String deli = "",numb="",numb1 = "",numb2="",numlist[];		
		 int index1=numbers.indexOf("\\");
		 int index2=numbers.indexOf("\n");
	
		 String delimiter = numbers.substring(index1+1, index2); 
		 System.out.println("Delimiter:"+delimiter);
	   	   
		 int len=delimiter.length();
		 char[] del= delimiter.toCharArray();
		 char[] delarray = new char[len/3] ;
	   
      if(del[0]=='[') {
    	  int y=0;
    	  for(int i=0;i<del.length-1;i++) {
    		  delarray[y]= del[i+1];
    		  y++;
    		  i=i+2;
    	  }
     	   numb = numbers.substring(len+2);
    	   numb1 = numb.replaceAll("[\\n]+", ",");		   
		
		   for(int i=0;i<delarray.length;i++) {
		   numb2 = numb1.replaceAll("\\"+delarray[i], ",");
		   numb1=numb2;   
		  }
		   numlist=numb1.split(",");
		  
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
	   }else {
		   char[] newdel = new char[2*(len)];
		   int y=0;
		   char t= '\\' ;	   
		   for(int j=0;j<len-1;j++) {
			   newdel[y++]= t;
			   newdel[y++]=del[j];   
		   }
		   newdel[y++]= t;
		   newdel[2*(len)-1]= del[len-1];
		   deli=String.valueOf(newdel);
		   numb = numbers.substring(index2+1);
		   numb1 = numb.replaceAll("[\\n]+", delimiter);
		   numlist=numb1.split(deli);
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
