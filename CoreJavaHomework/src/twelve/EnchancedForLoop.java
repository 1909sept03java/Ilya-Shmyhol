package twelve;

public class EnchancedForLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		enchanced(100);
	}
	public static void enchanced(int n) {
		int count=0;
		int arr[]=new int[n+1];
		int rArr[]=new int[(n/2)+1];
		
		
		for(int i=0;i<n;i++) {
			arr[i]=i+1;
		}
		
		for(int i:arr) {
			if(arr[i]%2==0) {
				rArr[count]=arr[i];
				count++;
			}
		}
		print(rArr);
	}
	private static void print(int[] rArr) {
		for(int i=0;i<rArr.length-1;i++) {
			System.out.println(rArr[i]);
		}
	}
	
	
	

}
