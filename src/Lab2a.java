import java.util.Arrays;

public class Lab2a {
	
	//multiplication with addition and loops, while loop method
	public static int MultLoop1(int a, int b){
		int total = 0;
		
		while(b > 0){
			total += a;
			b -= 1;
		}
		return total;
	}
	
	//multiplication with addition and loops, recursion loop method
	public static int MultLoop2(int a, int b){
		if(b == 0){
			return 0;
		}
		else{
			return a + MultLoop2(a, b-1);
		}
	}
	
	//multiplication with addition and loops, for loop method
	public static int MultLoop3(int a, int b){
		int total = 0;
		
		for(int i = 0; i < b; i++){
			total += a;
		}
		return total;
	}
	
	//find LCM with loops, while loop method
	public static int LCMLoop1(int a, int b){
		int c = (a>=b)? a:b;
		int d = (b>a)? a:b;
		int e = c;
		
		while(c % d != 0){
			c += e;
		}
		return c;
	}
	
	//find LCM with loops, for loop method
	public static int LCMLoop2(int a, int b){
		int c = (a>=b)? a:b;
		int d = (b>a)? a:b;
		int e = c;
		
		for( ; c%d != 0; c+=e){
			
		}
		return c;
	}
	
	//solves for square root
	public static double getSquare(int a){
		
		double sqrt = a/2.0;
		
		while(Math.abs((sqrt*sqrt)-a)>.0001){
			sqrt = (sqrt + (a/sqrt))/ 2.0;
		}
		return sqrt;
	}
	
	//prints character square art thing
	public static void charSquare(int a, int b, char c, char d, char e, char f){
		for(int i = 0; i<a; i++){
			
			for(int x = 0; x<a; x++){
				System.out.print(c);
			}
			System.out.print(' ');
			for(int y = 0; y<(b-(1+a)); y++){
				System.out.print(d);
			}
			System.out.println("");
		}
		System.out.println("");
		
		for(int i = 0; i<(b-(1+a)); i++){
			
			for(int x = 0; x<a; x++){
				System.out.print(e);
			}
			System.out.print(' ');
			for(int y = 0; y<(b-(1+a)); y++){
				System.out.print(f);
			}
			System.out.println("");
		}
	}
	
	//checks to see if two ints 10-99 share a digit or not
	public static boolean shareDigit(int a, int b){
		return(((a%10)==(b%10)) || ((a/10)==(b/10)) || ((a/10)==(b%10)) || 
				((b/10)==(a%10)));
	}
	
	//calculates whether or not a number has odd parity
	public static boolean oddParity(int a){
		int total = 0;
		while(a>0){
			total += a%10;
			a = a/10;
		}
		
		return((total%2==1));
	}
	
	//returns average of an array of doubles
	public static double mean(double[] data){
		int arrayLength = data.length;
		double total = 0;
		for(int i = 0; i<data.length; i++){
			total += data[i];
		}
		return total/arrayLength;
	}
	
	//returns number of words in a sentence given in an array of characters
	public static int countWords(char[] sent){
		int wordCount = 1;
		for(int i = 0; i<sent.length; i++){
			if(sent[i] == ','){
				wordCount += 1;
				i += 1;
			}
			else if(sent[i]== ' '){
				wordCount += 1;
			}
			else{
				
			}
		}
		return wordCount;
	}
	
	//returns TV's image signal given array of digital representation
	public static int[] highDef(int digRep[]){
		int[] iSig = new int[(3*(digRep.length))-2];
		int index = 0;
		
		for(int i=0; i<digRep.length-1; i++){
			int lowVal = digRep[i];
			int highVal = digRep[i+1];
			
			for(int x=0; x<3; x++){
				iSig[index] = (int)(lowVal + (highVal - lowVal)*(x/3.0));
				index += 1;
			}
		}
		iSig[iSig.length-1]=digRep[digRep.length-1];
		return iSig;
	}
	
	//strips punctuation from a character array
	public static String[] stripPunct(char[] sent){
		boolean[] punctLoc = new boolean[sent.length];
		int punctCount = 0;
		int wordCount = 1;
		for(int i = 0; i<sent.length; i++){
			if(sent[i]=='?'||sent[i]=='!'||sent[i]==','||sent[i]=='.'){
				punctLoc[i] = true;
				punctCount += 1;
			}
			else if(sent[i]==' '){
				punctLoc[i] = false;
				wordCount += 1;
			}
			else{
				punctLoc[i] = false;
			}
		}
		
		char[] newArr = new char[sent.length-punctCount];
		int index = 0;
		for(int i = 0; i<sent.length; i++){
			if(punctLoc[i]){
				
			}
			else{
				newArr[index] = sent[i];
				index += 1;
			}
		}
		
		String[] newSent = new String[wordCount];
		index = 0;
		int startChar = 0;
		for(int i = 0; i<newArr.length; i++){
			if(newArr[i]!=' '){
				
			}
			else{
				String temp = "";
				for(int x = startChar; x<newArr.length; x++){
					if(newArr[x]!=' '){
						temp = temp + newArr[x];
					}
					else{
						newSent[index] = temp;
						index += 1;
						break;
					}
					
				}
				startChar = i+1;
			}
		}
		
		String temp = "";
		for(int i = startChar;i<newArr.length; i++){
			temp = temp + newArr[i];
		}
		newSent[index] = temp;
		return newSent;
	}
	
	//takes an array of integers, calculates new array then returns string of digits saved
	public static String simpleCompression(int[] data){
		int[] newArr = new int[data.length];
		newArr[0] = data[0];
		for(int i = 1; i<data.length; i++){
			newArr[i] = data[i-1] - data[i];
		}
		int digitChange = arrayDigitCount(data) - arrayDigitCount(newArr) ;
		return("Saved " + digitChange + " in digits");
	}
	
	//counts number of digits in an array
	public static int arrayDigitCount(int[] data){
		int total = 0;
		for(int i : data){
			if(i < 0){
				i = i * -1;
			}
			int tempTotal = 0;
			while(i>0){
				tempTotal += 1;
				i = i/10;
			}
			total += tempTotal;
		}
		return total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Question 1, calls while loop method
		System.out.println("Question 1: ");
		System.out.println(MultLoop1(6, 5));
		
		//Question 1, calls recursive loop method
		System.out.println(MultLoop2(6,5));
		
		//Question 1, calls for loop method
		System.out.println(MultLoop3(6,5));
		System.out.println("");
		
		//Question 2, calls while loop method
		System.out.println("Question 2: ");
		System.out.println(LCMLoop1(12, 22));
		
		//Question 2, calls for loop method
		System.out.println(LCMLoop2(12, 22));
		System.out.println("");
		
		//Question 3, calls getSquare method
		System.out.println("Question 3: ");
		System.out.println(getSquare(121));
		System.out.println("");
		
		//Question 4, calls charSquare method
		System.out.println("Question 4: ");
		charSquare(8, 11, '*', '!', '+', '@');
		System.out.println("");
		
		//Question 5, calls shareDigit method
		System.out.println("Question 5: ");
		System.out.println(shareDigit(23, 12));
		System.out.println(shareDigit(26, 61));
		System.out.println(shareDigit(54, 56));
		System.out.println(shareDigit(78, 98));
		System.out.println(shareDigit(11, 37));
		System.out.println("");
		
		//Question 6, calls oddParity method
		System.out.println("Question 6: ");
		System.out.println(oddParity(4532120));
		System.out.println(oddParity(4532121));
		System.out.println("");
		
		//Question 7, calls mean method
		System.out.println("Question 7: ");
		double[]x = {10.0, 20.0, 30.0};
		System.out.println(mean(x));
		System.out.println("");
		
		//Question 8, calls countWords method
		System.out.println("Question 8: ");
		char[]sentence1 = {'T','h','e',' ','b','o','y',' ','w','a','s',' ','s','a','d','.'};
		System.out.println(countWords(sentence1));
		
		char[]sentence2 = {'A','h',',',' ','t','o',' ','b','e',' ','y','o','u','n','g','.'};
		System.out.println(countWords(sentence2));
		
		char[]sentence3 = {'D','o',' ','r','e',' ','m','i','.'};
		System.out.println(countWords(sentence3));
		System.out.println("");
		
		//Question 9, calls highDef method
		System.out.println("Question 9: ");
		int[]tv1 = {400, 500, 600};
		System.out.println(Arrays.toString(highDef(tv1)));
		
		int[]tv2 = {100, 200, 300, 400};
		System.out.println(Arrays.toString(highDef(tv2)));
		
		int[]tv3 = {1000, 4000, 7000};
		System.out.println(Arrays.toString(highDef(tv3)));
		System.out.println("");
		
		//Question 10, calls stripPunct method
		System.out.println("Question 10: ");
		char[]sentence4 = {'H','i',',',' ', 'I',' ','l','i','k','e',' ', 'y','o','u','.'};
		System.out.println(Arrays.toString(stripPunct(sentence4)));
		char[]sentence5 = {'C','I','S','C','1','8','1',' ','i','s',' ','e','a','s','y','!'};
		System.out.println(Arrays.toString(stripPunct(sentence5)));
		char[]sentence6 = {'G','O','!',' ','G','R','I','Z','Z','!',' ','G','O','!'};
		System.out.println(Arrays.toString(stripPunct(sentence6)));
		System.out.println("");
		
		//Question 11, calls simpleCompression method
		System.out.println("Question 11: ");
		int[]wavelengths1 = {6500, 6480, 6600, 6505};
		System.out.println(simpleCompression(wavelengths1));
		int[]wavelengths2 = {4283, 4296, 4344, 4348, 4355, 4367, 4392, 4391, 4380};
		System.out.println(simpleCompression(wavelengths2));
		int[]wavelengths3 = {500, 600, 589, 607, 608};
		System.out.println(simpleCompression(wavelengths3));
		
		
	}

}
