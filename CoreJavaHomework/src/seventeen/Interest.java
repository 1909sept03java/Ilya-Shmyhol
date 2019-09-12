package seventeen;

import java.util.Scanner;

public class Interest {
	public static void main(String[] args) {

	    Scanner input = new Scanner(System.in);
	    System.out.println("Please enter principal");
	    double principal=input.nextDouble();
	    System.out.println("Please enter rate");
	    double rate=input.nextDouble();
	    System.out.println("Please enter time");
	    double time=input.nextDouble();

	    System.out.println("Your simple interest is "+(principal*rate*time));

	}

}
