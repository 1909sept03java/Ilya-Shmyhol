package Part2;

public class Utility {

	public int validator(String orginal, String mutated, String[] bank) {
		
		int mutations = 0;
		boolean found=false;
		
		for (int i = 0; i < 8; i++) {
			if (mutated.charAt(i) != orginal.charAt(i)) {
				mutations++;
			}
		}
		if (mutations > 0) {
			found=testBank(mutated, bank);
			if(found==true) {
				return mutations;
			}
			else return -1;
		} 
		else 
			return 0;

	}

	private boolean testBank(String mutated, String[] bank) {
		for (int f = 0; f < bank.length; f++) {
			for (int i = 0; i < 8; i++) {
				if(mutated.charAt(i)!=bank[f].charAt(i)) {
					continue;
				}
				if(i==7) {
					return true;
				}

			}
		}
		return false;
	}

}
