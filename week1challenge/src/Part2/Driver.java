package Part2;

public class Driver {
	public static void main(String[] args) {
		Utility ut=new Utility();
		String bank[]= {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
		
		ut.validator("AACCGGTT","AAACGGTA",bank);
	}
}
