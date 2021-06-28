package nsh.codility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public abstract class AbstractRubidium2018Test {
	abstract Rubidium2018Interface getTestObject();

	@Test
	void test01() {
		int[] X = new int[] { 0, 0, 10, 10 };
		int[] Y = new int[] { 0, 10, 0, 10 };
		int E = 5;

		assertEquals(E, getTestObject().solution(X, Y));
	}

	@Test
	void test02() {
		int[] X = new int[] { 1, 1, 8 };
		int[] Y = new int[] { 1, 6, 0 };
		int E = 2;

		assertEquals(E, getTestObject().solution(X, Y));
	}

	@Test
	void test03() {
		int[] X = new int[] { 0, 6, 4 };
		int[] Y = new int[] { 3, 1, 5 };
		int E = 2;

		assertEquals(E, getTestObject().solution(X, Y));
	}

	@Test
	void test04() {
		int[] X = new int[] { 3, 0 };
		int[] Y = new int[] { 0, 2 };
		int E = 1;

		assertEquals(E, getTestObject().solution(X, Y));
	}

	@Test
	void test05() {
		int[] X = new int[] { 0, 100000 };
		int[] Y = new int[] { 0, 100000 };
		int E = 50000;

		assertEquals(E, getTestObject().solution(X, Y));
	}

	@Test
	void test06() {
		int[] X = new int[] { 3, 2, 1 };
		int[] Y = new int[] { 0, 0, 0 };
		int E = 0;

		assertEquals(E, getTestObject().solution(X, Y));
	}

	@Test
	@DisplayName("Straight Line")
	void test07() {
		int[] X = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		int[] Y = new int[] { 8, 19, 49, 58, 129, 180, 150, 228, 217, 329, 350, 652, 584, 401, 195, 252, 522, 965, 13,
				999 };
		int E = 2;

		assertEquals(E, getTestObject().solution(X, Y));
	}

}
