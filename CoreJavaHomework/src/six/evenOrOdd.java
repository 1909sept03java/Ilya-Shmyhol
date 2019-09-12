package six;

public class evenOrOdd {
	public static void main(String[] args) {

		System.out.println("3 is : "+divideByTwo(3));
		
	}
	
	static String divideByTwo(int n){
		if(n==0) {
			return "even";
		}
		if(n==1) {
			return "odd";
		}
		return divideByTwo(n-2);
	}
	

}
