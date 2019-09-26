import java.io.*;
import java.lang.Math;
import java.util.Scanner;

import com.sun.source.tree.Scope;

public class BinaryTableConstructor {
	
	public static File outFile = null;
	public static FileWriter fileWriterVar = null;
	public static PrintWriter printWriterVar = null;
	public static Scanner inputVar = null;
	public static int High, Low, Counter;
	public static float Decimal;
	
	public static void main(String[] args) throws IOException {
		
			inputVar = new Scanner (System.in);
			System.out.print("Name of output file: ");
			String fileName = inputVar.nextLine()+".txt";
			
			outFile = new File (fileName);
			fileWriterVar = new FileWriter (outFile); //(outFile, true) appends text to file
			printWriterVar = new PrintWriter (fileWriterVar);
			
			System.out.println("*******************************************************************************\n" +
						"************************************WELCOME************************************\n" + 
						"*******************************************************************************\n" +
						"This Program will show you a binary table and convert decimals in a separate file");
						
			System.out.print("Input the highest binary degree exponent: ");
			
		/*
		 * // do{ // if(inputVar.hasNextInt()) { // High = inputVar.nextInt(); //
		 * if(High < 0) { // System.out.print("try again\t"); // inputVar.hasNext(); //
		 * } // } // else{ // High = -1; // System.out.print("try again\t"); //
		 * inputVar.next(); // } // } while(High<0);
		 */			
			High = tryAgain(High,1) + 1;
				
			//System.out.printf("%.0f\n",Math.pow(2, High));
			
			System.out.print("Input the lower binary degree less than 0: ");
			//Low = inputVar.nextInt();
			Low = tryAgain(Low,-1);
			//System.out.println(Math.pow(2,  Low));
			
//			printBinTable(High, Low);
			
			for (int i=0 ; i<=1; i++) {
				for (int j=High ; j>=Low; j--){
					if (i==0) {
						if (j==High) printWriterVar.print("exp\t\t");
						else printWriterVar.print( j + "\t");
					}
					if (i==1) {
						if (j==High) printWriterVar.print("base 2\t\t");
						else if (j >= 0) printWriterVar.printf("%.0f\t", Math.pow(2, j));
						else printWriterVar.print(Math.pow(2, j)+"\t");
					}						
				}
				printWriterVar.println();
			}
			System.out.print("How many numbers would you like to convert: ");
			//Counter = inputVar.nextInt();
			Counter = tryAgain(Counter, 1);
			
			while(Counter > 0) {
				
				System.out.print("Please enter a value to turn into binary: ");
//				Decimal = inputVar.nextFloat();
				Decimal = tryAgainF(Decimal,1);
				
									
					while (Decimal >= Math.pow(2, High)) {
						System.out.print("Enter a number lower than " + Math.pow(2,  High)+": ");
//						Decimal = inputVar.nextFloat();
						Decimal = tryAgainF(Decimal,1);
					}
				for (int j=High ; j>=Low; j--){
					if(j==High) printWriterVar.print(Decimal+"\t\t");
					if(j<High) {
						if(Decimal>=Math.pow(2, j)) {
							printWriterVar.print("1\t");
							Decimal -= Math.pow(2, j);
						}
						else {
							printWriterVar.print("0\t");
							}
					}
				}
				printWriterVar.println();
				

			
				Counter--;	
			}//end of while loop counter
			System.out.println("Open the new file created \'"+fileName+"\'\ngoodbye..");
			printWriterVar.close();
			inputVar.close();

	}
	
	public static void printBinTable(int High, int Low) {
		for (int i=0 ; i<=1; i++) {
			for (int j=High ; j>=Low; j--){
				if (i==0) {
					if (j==High) System.out.print("exp\t\t");
					else System.out.print( j + "\t");
				}
				if (i==1) {
					if (j==High) System.out.print("base 2\t\t");
					else if (j >= 0) System.out.printf("%.0f\t", Math.pow(2, j));
					else System.out.print(Math.pow(2, j)+"\t");
				}						
			}
			System.out.println();
		}
	}
	
	public static int tryAgain(int a, int b) {
		do{
			if(inputVar.hasNextInt()) {
				a = inputVar.nextInt();
				if(a*b < 0 || a==0) {
					System.out.print("try again\t");
					inputVar.hasNext();
				}
			}					
			else{
					a = 0;
					System.out.print("not an integer\t");
					inputVar.next();
				}
			} while(a*b<=0);
		return a;
	}

	public static float tryAgainF(float a, int b) {
		do{
			if(inputVar.hasNextFloat()) {
				a = inputVar.nextFloat();
				if(a*b < 0) {
					System.out.print("try again\t");
					inputVar.hasNext();
				}
			}					
			else{
					a = 0;
					System.out.print("not a number\t");
					inputVar.next();
				}
			} while(a*b<=0);
		return a;
	}
}


	
