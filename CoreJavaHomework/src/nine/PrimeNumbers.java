package nine;

import java.util.ArrayList;

public class PrimeNumbers {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> plist = new ArrayList<>();

		int n = 100;
		for (int i = 1; i < n + 1; i++) {
			list.add(i);

		}

	
		for (int i = 1; i <n; i++) {
			for (int j = 1; j < i; j++) {
				//System.out.println(i+" "+n+" "+j);
				if (list.get(i) % list.get(j) == 0) {
					list.remove(i);
					n--;
					i--;
				}

			}

		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

}
