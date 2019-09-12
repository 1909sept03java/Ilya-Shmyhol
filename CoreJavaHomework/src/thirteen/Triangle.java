package thirteen;

public class Triangle {

	public static void main(String[] args) {
		right(4);
	}

 static void right(int n) {
		
		boolean lastVal=true;
		
		for(int i=1;i<n+1;i++) {
			for(int j=0;j<i;j++) {
				if(lastVal) {
					System.out.print(0);
					lastVal=false;
				}
				else {
					System.out.print(1);
					lastVal=true;
				}
			}
			System.out.println();
		}
	}
	
}
