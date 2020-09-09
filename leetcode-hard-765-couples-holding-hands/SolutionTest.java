/*
 * Course Name: 2020S CST8284
 * Student Name: Zhiyong Pan
 * Class Name: SolutionTest
 * Date: 7-Sep-2020
*/

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

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
	public final void testNumberOfConnectedComponents_0_0() {
		int[][] edges = { };
		assertEquals(0, Solution2.numberOfConnectedComponents(edges, 0));
	}

	@Test
	public final void testNumberOfConnectedComponents_2_1() {
		int[][] edges = {
				{ 0, 1 },
		};
		assertEquals(1, Solution2.numberOfConnectedComponents(edges, 2));
	}

	@Test
	public final void testNumberOfConnectedComponents_3_1() {
		int[][] edges = {
				{ 0, 1 },
				{ 2, 1 },
		};
		assertEquals(1, Solution2.numberOfConnectedComponents(edges, 3));
	}

	@Test
	public final void testNumberOfConnectedComponents_8_3() {
		int[][] edges = {
				{ 0, 1 },
				{ 1, 2 },

				{ 3, 4 },
				{ 4, 5 },
				{ 4, 5 },

				{ 6, 7 },
				{ 7, 6 }
		};
		assertEquals(3, Solution2.numberOfConnectedComponents(edges, 8));
	}

	@Test
	public final void testNumberOfConnectedComponents_4_2() {
		int[][] edges = {
				{ 0, 1 },
				{ 2, 3 },
		};
		assertEquals(2, Solution2.numberOfConnectedComponents(edges, 4));
	}

	@Test
	public final void testNumberOfConnectedComponents_20_1() {
		// a graph generated from row
		// [9, 1, 10, 17, 16, 12, 15, 3, 7, 11, 2, 19, 0, 13, 14, 5, 8, 4, 18, 6]

		int[][] edges = {
				{ 1, 4 },
				{ 2, 1 },
				{ 5, 3 },
				{ 6, 0 },
				{ 7, 3 },
				{ 8, 7 },
				{ 8, 0 },
				{ 9, 4 },
				{ 9, 5 },
		};
		assertEquals(1, Solution2.numberOfConnectedComponents(edges, 20));
	}

	@Test
	public final void testNumberOfConnectedComponents_20_2() {
		// a graph generated from row
		// [3,9,10,5,0,4,11,16,6,2,1,17,18,13,7,19,14,8,15,12]

		int[][] edges = {
				{ 0, 1 },
				{ 1, 2 },
				{ 2, 3 },
				{ 0, 3 },
				{ 4, 5 },
				{ 4, 9 },
				{ 6, 5 },
				{ 6, 7 },
				{ 7, 8 },
				{ 8, 9 },
		};
		assertEquals(2, Solution2.numberOfConnectedComponents(edges, 10));
	}

	@Test
	public final void testMinSwapCouples_example1() {
		assertEquals(1, new Solution().minSwapsCouples(new int[] { 0, 2, 1, 3 }));
		assertEquals(1, new Solution2().minSwapsCouples(new int[] { 0, 2, 1, 3 }));
	}

	@Test
	public final void testMinSwapCouples_example2() {
		assertEquals(0, new Solution().minSwapsCouples(new int[] { 3, 2, 0, 1 }));
		assertEquals(0, new Solution2().minSwapsCouples(new int[] { 3, 2, 0, 1 }));
	}

	@Test
	public final void testMinSwapCouples_532140() {
		assertEquals(2, new Solution().minSwapsCouples(new int[] { 5, 3, 2, 1, 4, 0 }));
		assertEquals(2, new Solution2().minSwapsCouples(new int[] { 5, 3, 2, 1, 4, 0 }));
	}

	@Test
	public final void testMinSwapCouples_ordered() {
		int[] row = range(60);
		assertEquals(0, new Solution().minSwapsCouples(row));
		assertEquals(0, new Solution2().minSwapsCouples(row));
	}

	@Test
	public final void testMinSwapCouples_60_swaped_once() {
		int[] row = range(60);

		swap(row, 0, 59);

		// test Solution2 first, because Solution will modify |row|.
		assertEquals(1, new Solution2().minSwapsCouples(row));
		assertEquals(1, new Solution().minSwapsCouples(row));
	}

	@Test
	public final void testMinSwapCouples_60_swaped_twice_but_still_coupled() {
		int[] row = range(60);

		swap(row, 0, 59);
		swap(row, 1, 58);

		// test Solution2 first, because Solution will modify |row|.
		assertEquals(0, new Solution2().minSwapsCouples(row));
		assertEquals(0, new Solution().minSwapsCouples(row));
	}

	@Test
	public final void testMinSwapCouples_60_swaped_twice() {
		int[] row = range(60);

		swap(row, 0, 59);
		swap(row, 2, 57);

		// test Solution2 first, because Solution will modify |row|.
		assertEquals(2, new Solution2().minSwapsCouples(row));
		assertEquals(2, new Solution().minSwapsCouples(row));
	}

	@Test
	public final void testMinSwapCouples_2_connected_components() {
		int[] row = {
				0, 2, 1, 3,
				4, 6, 7, 5
		};

		// test Solution2 first, because Solution will modify |row|.
		assertEquals(2, new Solution2().minSwapsCouples(row));
		assertEquals(2, new Solution().minSwapsCouples(row));
	}

	@Test
	public final void testMinSwapCouples_from_leetcode() {
		int[] row = { 3,9,10,5,0,4,11,16,6,2,1,17,18,13,7,19,14,8,15,12 };
		assertEquals(8, new Solution2().minSwapsCouples(row));
		assertEquals(8, new Solution().minSwapsCouples(row));
	}

	@Test
	public final void testMinSwapCouples_random() {
		int N = 60;

		int[] row = randomRange(N);
		int[] rowBak = Arrays.copyOf(row, N);

		// test Solution2 first, because Solution will modify |row|.
		int resultOfSolution2 = new Solution2().minSwapsCouples(row);

		int resultOfSolution1 = new Solution().minSwapsCouples(row);

		if (resultOfSolution1 != resultOfSolution2) {
			System.err.println("The two got different answers for this row:");
			System.err.println(Arrays.toString(rowBak));
			System.err.printf("Solution 1: %d%n", resultOfSolution1);
			System.err.printf("Solution 2: %d%n", resultOfSolution2);
		}

		assertEquals(resultOfSolution1, resultOfSolution2);

		for (int i = 0; i < N; i += 2) {
			if (!Solution.isCouple(row[i], row[i + 1]))
				fail(i + " and " + (i + 1) + " are not a couple");
		}
	}
}
