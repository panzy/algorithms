/*
 * Course Name: 2020S CST8284
 * Student Name: Zhiyong Pan
 * Class Name: SolutionTest
 * Date: 7-Sep-2020
*/

import static org.junit.Assert.*;

import org.junit.Test;
import org.omg.PortableInterceptor.SUCCESSFUL;

public class SolutionTest {
	
	static int[] range(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; ++i)
			a[i] = i;
		return a;
	}
	
	static int[] randomRange(int n) {
		int[] a = range(n);
		for (int k = 0; k < n; ++k) {
			int i = (int) Math.floor(Math.random() * n);
			int j = (int) Math.floor(Math.random() * n);
			swap(a, i, j);
		}
		return a;
	}
	
	static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	@Test
	public final void testIsCouple() {
		assertEquals(true, Solution.isCouple(0, 1));
		assertEquals(true, Solution.isCouple(1, 0));
		assertEquals(true, Solution.isCouple(2, 3));
		assertEquals(true, Solution.isCouple(3, 2));
		assertEquals(false, Solution.isCouple(1, 2));
		assertEquals(false, Solution.isCouple(2, 1));
	}

	@Test
	public final void testTheOther() {
		assertEquals(1, Solution.theOther(0));
		assertEquals(0, Solution.theOther(1));

		assertEquals(6, Solution.theOther(7));

		assertEquals(61, Solution.theOther(60));
	}

	@Test
	public final void testSwap1() {
		// swap the only two people

		int[] row 		= { 0, 1 };
		int[] people 	= { 0, 1 };

		Solution.swap(0, 1, row, people);

		assertArrayEquals(new int[]{ 1, 0 }, row);
		assertArrayEquals(new int[]{ 1, 0 }, people);
	}

	@Test
	public final void testSwap2() {
		// swap the last two of four

		int[] row 		= { 0, 1, 2, 3 };
		int[] people 	= { 0, 1, 2, 3 };

		Solution.swap(2, 3, row, people);

		assertArrayEquals(new int[]{ 0, 1, 3, 2 }, row);
		assertArrayEquals(new int[]{ 0, 1, 3, 2 }, people);
	}

	@Test
	public final void testSwap3() {
		// swap the 2nd and 4th of 6

		int[] row 		= { 0, 3, 2, 4, 1, 5 };
		int[] people 	= Solution.initPeopleArray(row);

		Solution.swap(4, 1, row, people);

		assertArrayEquals(new int[]{ 0, 1, 2, 4, 3, 5 }, row);
		assertArrayEquals(Solution.initPeopleArray(row), people);
	}

	@Test
	public final void testMinSwapCouples_example1() {
		assertEquals(1, new Solution().minSwapsCouples(new int[] { 0, 2, 1, 3 }));
	}

	@Test
	public final void testMinSwapCouples_example2() {
		assertEquals(0, new Solution().minSwapsCouples(new int[] { 3, 2, 0, 1 }));
	}

	@Test
	public final void testMinSwapCouples_532140() {
		assertEquals(2, new Solution().minSwapsCouples(new int[] { 5, 3, 2, 1, 4, 0 }));
	}

	@Test
	public final void testMinSwapCouples_ordered() {
		int[] row = range(60);
		assertEquals(0, new Solution().minSwapsCouples(row));
	}

	@Test
	public final void testMinSwapCouples_60_swaped_once() {
		int[] row = range(60);
		
		swap(row, 0, 59);
		assertEquals(1, new Solution().minSwapsCouples(row));
	}

	@Test
	public final void testMinSwapCouples_60_swaped_twice_but_still_coupled() {
		int[] row = range(60);
		
		swap(row, 0, 59);
		swap(row, 1, 58);
		assertEquals(0, new Solution().minSwapsCouples(row));
	}

	@Test
	public final void testMinSwapCouples_60_swaped_twice() {
		int[] row = range(60);
		
		swap(row, 0, 59);
		swap(row, 2, 57);
		assertEquals(2, new Solution().minSwapsCouples(row));
	}

	@Test
	public final void testMinSwapCouples_60_random() {
		int[] row = randomRange(60);
		new Solution().minSwapsCouples(row);
		
		for (int i = 0; i < 60; i += 2) {
			if (!Solution.isCouple(row[i], row[i + 1]))
				fail(i + " and " + (i + 1) + " are not a couple");
		}
	}
}
