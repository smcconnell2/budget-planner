package utils;

import java.util.Currency;
import java.util.Scanner;

/**
 * 
 * @author steve
 *Creates a static Scanner object to read in user input and to handle
 *basic user input checks to ensure proper type of information is 
 *entered by the user.
 */
public class ScannerClass {
	public static Scanner scan;
	public Currency test;
	
	
	private static Scanner getScanner() {
		if(scan == null) {
			scan = new Scanner(System.in);
		}
		return scan;
	}
	
	public static String readString() {
		String line = getScanner().nextLine();
		
		// Regex: check if line is blank
		return line;
	}
	
	public static char readChar() {		
		return readString().charAt(0);
	}
	/**
	 * Attempts to read a number from the user. If an invalid entry is entered by the
	 * user than a negative number is returned.
	 * @return
	 */
	public static int readInt() {
		String line = readString();
		int value;
		
		try {
			value = Integer.parseInt(line);
		}catch(NumberFormatException e) {
			// handle some kind of error message
			
			value = -1;
		}
		
		return value;
	}
	
	public static double readDouble() {
		
		return 0.0;
	}
}
