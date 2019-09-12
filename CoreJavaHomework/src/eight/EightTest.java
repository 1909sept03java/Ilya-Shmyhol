package eight;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class EightTest {
	MyArrayList m;
	@Test
	void test() {
		String strIn[]= new String[] {"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy",
				"did"};
;
		String expected[]= new String [] {"madam",  "civic", "radar", "sexes", "kayak", "refer","did"};
		//String actual[]=
		
		assertArrayEquals(expected, MyArrayList.Palindromes(strIn));
	
	}

}
