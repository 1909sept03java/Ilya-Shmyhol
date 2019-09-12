package fourteen;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class SwitchCase {
	public static void main(String[] args) {
		cases(1);
	}

	static void cases(int i){
		switch(i) {
		case 1: sqrt();
			break;
		case 2: printDate();
			break;
		case 3: split();
			break;
		
		}
	}

	private static void split() {
		String str="I am learning Core Java";
		String [] arrayOfStrings=str.split("\\s+");
		for(int i=0;i<arrayOfStrings.length;i++) {
			System.out.println(arrayOfStrings[i]);
		}
	}

	private static void sqrt() {
		System.out.println("The square root of 42 is: "+Math.sqrt(42));		
	}

	/*
	 * Case 1: Find the square root of a number using the Math class method. Case 2:
	 * Display today’s date. Case 3: Split the following string and store it in a
	 * sting array. “I am learning Core Java”
	 */
	static void printDate() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
	}
}
