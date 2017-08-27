package Kata;


//This file contains the Kata task 9 allow multiple delimiters
public class Task9 {
	//test Strings
	static String test1="\\[**][%][&&&]\n4%4\n5&&&6**7"; //different delimiters
	static String test2="";
	static String test3="4,4\n5,7,6";
	static String test4="\\[*][%][&]\n4%4\n5&6*7";
	int k=0; 
	int errorflag=0;

	public static void main(String[] args) {
		Task9 t1=new Task9();
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
	   
      if(delimiter.startsWith("[")==true) {
    	
    	 String newdel=delimiter.replaceAll("\\]\\[", ",").replaceAll("\\]", "").replaceAll("\\[", "");
     	 
    	 String[] delarray=newdel.split(",");
    	
     	 numb = numbers.substring(len+2);
     	
    	 numb1 = numb.replaceAll("[\\n]+", ",");	
    	  
		   for(int i=0;i<delarray.length;i++) {
			   char[] newdel1 = delarray[i].toCharArray();
			   int r=0, dellen=newdel1.length;
			   char[] newdel2 = new char[2*(dellen)];   
			   char t= '\\' ;	   
			   for(int j=0;j<dellen-1;j++) {
				   newdel2[r++]= t;
				   newdel2[r++]=newdel1[j];   
			   }
			   newdel2[r++]= t;
			   newdel2[2*(dellen)-1]= newdel1[dellen-1];
			   deli=String.valueOf(newdel2);
			  
			   numb2 = numb1.replaceAll(deli, ",");
			   numb1= numb2;  
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
