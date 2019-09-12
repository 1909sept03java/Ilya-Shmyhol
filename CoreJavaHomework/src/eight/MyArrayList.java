package eight;

import java.util.ArrayList;

public class MyArrayList {
	public static void main(String[] args) {
		Palindromes(args);
	}

	static String[] Palindromes(String strin[]) {
		ArrayList<String> palin = new ArrayList<>();

		ArrayList<String> list = new ArrayList<>();
		/*
		 * for(String i:strin) { list.add( i); }
		 */
		list.add("karan");
		list.add("tom");
		list.add("civic");
		list.add("radar");
		list.add("sexes");
		list.add("jimmy");
		list.add("kayak");
		list.add("john");
		list.add("refer");
		list.add("billy");
		list.add("did");

		for (int i = 0; i < list.size(); i++) {

			String str = list.get(i);
			StringBuilder sb = new StringBuilder(str);
			String rev = sb.reverse().toString();
			// System.out.println(rev);
			for (int j = 0; j < (str.length()); j++) {
				if (str.charAt(j) != rev.charAt(j)) {
					i--;
					list.remove(str);
					break;

				}

			}
		}
		String[] ret = new String[30];
		int x = 0;
		for (String i : list) {
			palin.add(i);
			System.out.println(i);
			ret[x] = i;
			x++;
		}
		return ret;

		// list.add(“karan”);
		// “karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, “jimmy”, “kayak”, “john”,
		// “refer”, “billy”, “did”
		// for(int i=0)

	}
}
