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
				mutationPath(orginal, mutated, bank);
			} else
				return -1;
		} else
			return 0;
		return 0;

	}

	private void mutationPath(String original, String mutated, String[] bank) {
		String nextGuessPath;
		String currentGuessPath = original;
		for (int i = 0; i < bank.length; i++) {
			for (int j = 0; j < 8; j++) {
				if (currentGuessPath.charAt(j) != mutated.charAt(j)) {
					nextGuessPath = currentGuessPath.substring(0, j) + mutated.charAt(j)
							+ currentGuessPath.substring(j + 1);

					if (testBank(nextGuessPath, bank)) {
						currentGuessPath = nextGuessPath;

					}
					System.out.println(currentGuessPath);
				}

			}

		}
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
