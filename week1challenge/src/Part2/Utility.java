package Part2;

public class Utility {
	
	public int validator(String orginal, String mutated, String[] bank) {

		int mutations = 0;
		boolean found = false;

		for (int i = 0; i < 8; i++) {
			if (mutated.charAt(i) != orginal.charAt(i)) {
				mutations++;
			}
		}
		if (mutations > 0) {
			found = testBank(mutated, bank);
			if (found == true) {
				return mutationPath(orginal, mutated, bank,mutations);
			} else
				return -1;
		} else
			return 0;

	}
	// should work out a best path and keep track of mutated string history(Maybe queue?) 
	private int mutationPath(String original, String mutated, String[] bank,int diffs) {
		int path=0;
		String nextGuessPath;
		String currentGuessPath = original;
		for (int i = 0; i < bank.length; i++) {
			for (int j = 0; j < 8; j++) {
				if (currentGuessPath.charAt(j) != mutated.charAt(j)) {
					nextGuessPath = currentGuessPath.substring(0, j) + mutated.charAt(j)
							+ currentGuessPath.substring(j + 1);

					if (testBank(nextGuessPath, bank)) {
						currentGuessPath = nextGuessPath;
						path++;

					}
					System.out.println(currentGuessPath);
				}

			}

		}
		return path;
	}

	

	private boolean testBank(String mutated, String[] bank) {
		for (int f = 0; f < bank.length; f++) {
			for (int i = 0; i < 8; i++) {
				if (mutated.charAt(i) != bank[f].charAt(i)) {
					continue;
				}
				if (i == 7) {
					return true;
				}

			}
		}
		return false;
	}

}
