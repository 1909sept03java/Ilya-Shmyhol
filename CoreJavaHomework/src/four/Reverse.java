package four;

public class Reverse {
	public static void main(String[] args) {
		System.out.println(factorail(6));
	}
	static int factorail(int n){
		int total=1;
		for(int i=n;i>0;i--) {
			total=total*i;
		}
		return total;
	}
}
