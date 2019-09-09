package Part2;

public class Driver {

	Utility ut = new Utility();

	public static void main(String[] args) {

	}

	public void pass(String original, String mutated, String[] bank) {
		String bank1[]= {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
		ut.validator("AACCGGTT","AAACGGTA",bank1);
	}
}
