package two;

public class Fibonacci {
	
	public static void main(String[] args) {
		Fib(25);
	}
	/*
	 * 
	 */
	public static void Fib(int n){
		int i=0;
		int b=i;
		System.out.println(i);
		Fib(i+1,b,n--);
	}
	public static void Fib(int i,int b,int n){
		if(n==1) return;
		b=i+b;
		System.out.println(b);
		Fib(b,i,n-1);
	}
	
	
}
