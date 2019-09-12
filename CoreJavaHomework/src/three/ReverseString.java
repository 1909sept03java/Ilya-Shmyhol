package three;

public class ReverseString {
	public static void main(String[] args) {
		System.out.println(backwards("Ilya"));
	}

	public static String backwards(String str) {
		String finalStr="";
		for(int i=str.length()-1;i>=0;i--) {
			finalStr=finalStr+str.charAt(i);
		}
		return finalStr;
	}
	
}
