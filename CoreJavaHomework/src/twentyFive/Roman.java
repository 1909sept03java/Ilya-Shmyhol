package twentyFive;

public class Roman {
	
	public String romanNumeral(int num){
		
		String romanum="I";
		String temp;
		/*
		 * 1"I"
		 * 5"V"
		 */
		
		while(num!=0) {
			if(num>900) {
				num=num/900;
				romanum.concat("CM");
			}
		}
//		case 2
//		https://www.worldatlas.com/r/w728-h425-c728x425/upload/0c/0b/a2/untitled-design-23.jpg
		
		return romanum;
		
	}
	
	
	

}
