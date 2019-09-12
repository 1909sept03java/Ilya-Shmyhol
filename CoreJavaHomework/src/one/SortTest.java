package one;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.Assert;



class SortTest {
	Sort B;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void test() {
		int test[]= {1,0,5,6,3,2,3,7,9,8,4};
		int[] actual= B.BSort(test);
		int expected []= {0,1,2,2,3,4,5,6,7,8,9};
		Assert.assertArrayEquals(actual,expected);
	}

}
