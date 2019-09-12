package nineteen;

import java.util.ArrayList;

public class ArrayListAction {

	public static void main(String[] args) {
		manipulate();
	}

	private static void manipulate() {
		int oddTotal = 0, evenTotal = 0;
		ArrayList<Integer> AL = new ArrayList<Integer>();
		ArrayList<Integer> NonPrime = new ArrayList<Integer>();

		for (int i = 1; i < 11; i++) {
			AL.add(i);
		}
		for (int i = 0; i < AL.size(); i++) {
			int num = (int) AL.get(i);
			if (num % 2 == 0) {
				evenTotal += num;
			} else
				oddTotal += num;

		}
		System.out.println(evenTotal);
		System.out.println(oddTotal);
		int limit = AL.size();
		// System.out.println(limit);
			
		for (int i = 0; i < limit; i++) {
			// System.out.println(i);
			 for (int j = 1; j < i; j++) {
				System.out.println((AL.get(i)) + "%" + (AL.get(j)));
				if (((AL.get(i)) % (AL.get(j))) == 0) {
					// System.out.println(AL.indexOf(i));
					NonPrime.add(AL.get(i));
					break;
				}

			}
		}
		for (int i = 0; i < NonPrime.size(); i++) {
			 System.out.println(NonPrime.get(i));
		}

	}

}
