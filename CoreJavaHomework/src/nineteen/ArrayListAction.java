package nineteen;

import java.util.ArrayList;

public class ArrayListAction {

	public static void main(String[] args) {
		manipulate();
	}

	private static void manipulate() {
		int oddTotal=0, evenTotal=0;
		ArrayList<Integer> AL=new ArrayList<Integer> ();
		ArrayList<Integer> NonPrime=new ArrayList<Integer> ();

		for(int i=1;i<=10;i++) {
			AL.add(i);
		}
		for(int i=0;i<AL.size();i++) {
			int num=(int) AL.get(i);
			if(num%2==0) {
				evenTotal+=num;
			}
			else
				oddTotal+=num;
			
		}
		System.out.println(evenTotal);
		System.out.println(oddTotal);
		
		for (int i = 0; i < AL.size(); i++) {
			for (int j = 2; j < i; ++j) {
				System.out.println((AL.indexOf(i))+"%"+(AL.indexOf(j)));
				if(((AL.indexOf(i))%(AL.indexOf(j)))==0) {
					NonPrime.add(AL.indexOf(i));
					break;
				}
				
			}
		}
		for(int i=0;i<NonPrime.size();i++) {
			System.out.println(NonPrime.get(i));
		}
		
		
		
		
	}

}
