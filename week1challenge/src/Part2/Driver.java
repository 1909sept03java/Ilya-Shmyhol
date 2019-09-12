package Part2;

public class Driver {

	static Utility ut = new Utility();

	public static void main(String[] args) {

		String bank1[]= {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
		System.out.println(ut.validator("AACCGGTT","AACCGGTA",bank1));
}
}
