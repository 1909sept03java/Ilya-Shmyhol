package twentytwo;

interface FuncDouble {

	void abstractM(double m);

}

interface FuncInterface {
	// An abstract function
	void abstractFun(int x);
	// A non-abstract (or default) function

	default void normalFun() {
		System.out.println("Wrong Answer");
	}
}

public class Lambda {
	public static void main(String args[]) {
		FuncInterface fobj = (int x) -> System.out.println(2 * x);
		// This calls above lambda expression and prints 10.
		fobj.abstractFun(5);

		FuncDouble num = (double n) -> System.out.println(15.5 * n);
		num.abstractM(3);
	}
}
