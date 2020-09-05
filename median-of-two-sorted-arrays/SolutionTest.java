import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class SolutionTest {

	Solution s = new Solution();
	
	@Test
	public void testPositionFor() {
		assertEquals(0, Solution.positionFor(new int[] {}, 0));
		assertEquals(0, Solution.positionFor(new int[] {1}, 0));
		assertEquals(0, Solution.positionFor(new int[] {1}, 1));
		assertEquals(1, Solution.positionFor(new int[] {1}, 2));
		assertEquals(0, Solution.positionFor(new int[] {1, 2}, 0));
		assertEquals(0, Solution.positionFor(new int[] {1, 2}, 1));
		assertEquals(1, Solution.positionFor(new int[] {1, 2}, 2));
		assertEquals(2, Solution.positionFor(new int[] {1, 2}, 3));
		assertEquals(2, Solution.positionFor(new int[] {1, 2, 4}, 3));
	}

	@Test
	public void testFindMedianSortedArrays() {
		int[] nums1 = {};
		int[] nums2 = {2};
		assertEquals(2, s.findMedianSortedArrays(nums1, nums2), 1e-8);
		assertEquals(2, s.findMedianSortedArrays(nums2, nums1), 1e-8);
	}

	@Test
	public void testFindMedianSortedArrays_1() {
		int[] nums1 = {};
		int[] nums2 = {-2};
		assertEquals(-2, s.findMedianSortedArrays(nums1, nums2), 1e-8);
		assertEquals(-2, s.findMedianSortedArrays(nums2, nums1), 1e-8);
	}

	@Test
	public void testFindMedianSortedArrays_2() {
		int[] nums1 = {1, 2};
		int[] nums2 = {};
		assertEquals(1.5, s.findMedianSortedArrays(nums1, nums2), 1e-8);
		assertEquals(1.5, s.findMedianSortedArrays(nums2, nums1), 1e-8);
	}

	@Test
	public void testFindMedianSortedArrays_3() {
		int[] nums1 = {-2, -1};
		int[] nums2 = {};
		assertEquals(-1.5, s.findMedianSortedArrays(nums1, nums2), 1e-8);
		assertEquals(-1.5, s.findMedianSortedArrays(nums2, nums1), 1e-8);
	}

	@Test
	public void testFindMedianSortedArrays_5() {
		int[] nums1 = {1, 2, 3};
		int[] nums2 = {};
		assertEquals(2, s.findMedianSortedArrays(nums1, nums2), 1e-8);
		assertEquals(2, s.findMedianSortedArrays(nums2, nums1), 1e-8);
	}

	@Test
	public void testFindMedianSortedArrays_6() {
		int[] nums1 = {-3, -2, -1};
		int[] nums2 = {};
		assertEquals(-2, s.findMedianSortedArrays(nums1, nums2), 1e-8);
		assertEquals(-2, s.findMedianSortedArrays(nums2, nums1), 1e-8);
	}

	@Test
	public void testFindMedianSortedArrays_7() {
		int[] nums1 = {0, 4};
		int[] nums2 = {1, 2, 3};
		assertEquals(2, s.findMedianSortedArrays(nums1, nums2), 1e-8);
		assertEquals(2, s.findMedianSortedArrays(nums2, nums1), 1e-8);
	}

	@Test
	public void testFindMedianSortedArrays_8() {
		int[] nums1 = {1, 2};
		int[] nums2 = {3, 4};
		assertEquals(2.5, s.findMedianSortedArrays(nums1, nums2), 1e-8);
		assertEquals(2.5, s.findMedianSortedArrays(nums2, nums1), 1e-8);
	}

	@Test
	public void testFindMedianSortedArrays_9() {
		int[] nums1 = {1, 2, 8};
		int[] nums2 = {3, 4};
		assertEquals(3, s.findMedianSortedArrays(nums1, nums2), 1e-8);
		assertEquals(3, s.findMedianSortedArrays(nums2, nums1), 1e-8);
	}

	@Test
	public void testFindMedianSortedArrays_10() {
		int[] nums1 = {1,  3,  5, 7, 9};
		int[] nums2 = {  2,  4};
		assertEquals(4, s.findMedianSortedArrays(nums1, nums2), 1e-8);
		assertEquals(4, s.findMedianSortedArrays(nums2, nums1), 1e-8);
	}

	@Test
	public void testFindMedianSortedArrays_11() {
		int[] nums1 = {  3,  5, 7, 9};
		int[] nums2 = {2,  4};
		assertEquals(4.5, s.findMedianSortedArrays(nums1, nums2), 1e-8);
		assertEquals(4.5, s.findMedianSortedArrays(nums2, nums1), 1e-8);
	}

	@Test
	public void testFindMedianSortedArrays_12() {
		int[] nums1 = {  3,  5, 7, 9};
		int[] nums2 = {2,            40};
		assertEquals(6, s.findMedianSortedArrays(nums1, nums2), 1e-8);
		assertEquals(6, s.findMedianSortedArrays(nums2, nums1), 1e-8);
	}

	@Test
	public void testFindMedianSortedArrays_shortcut_whole_nums2() {
		int[] nums1 = {     2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] nums2 = {0, 1};
		assertEquals(5, s.findMedianSortedArrays(nums1, nums2), 1e-8);
		assertEquals(5, s.findMedianSortedArrays(nums2, nums1), 1e-8);
	}

	@Test
	public void testFindMedianSortedArrays_shortcut_whole_nums2_variant() {
		int[] nums1 = {     2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] nums2 = {0, 2};
		assertEquals(5, s.findMedianSortedArrays(nums1, nums2), 1e-8);
		assertEquals(5, s.findMedianSortedArrays(nums2, nums1), 1e-8);
	}

	@Test
	public void testFindMedianSortedArrays_shortcut_non_nums2() {
		int[] nums1 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
		int[] nums2 = {	                          9, 10};
		assertEquals(5, s.findMedianSortedArrays(nums1, nums2), 1e-8);
		assertEquals(5, s.findMedianSortedArrays(nums2, nums1), 1e-8);
	}

	@Test
	public void testFindMedianSortedArrays_shortcut_non_nums2_variant() {
		int[] nums1 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
		int[] nums2 = {	                          8, 10};
		assertEquals(5, s.findMedianSortedArrays(nums1, nums2), 1e-8);
		assertEquals(5, s.findMedianSortedArrays(nums2, nums1), 1e-8);
	}

	@Test
	public void testFindMedianSortedArrays_shortcut_partial_nums2() {
		int[] nums1 = {0, 1,    3,    5, 6,    8, 9, 10};
		int[] nums2 = {	     2,    4,       7,         };
		assertEquals(5, s.findMedianSortedArrays(nums1, nums2), 1e-8);
		assertEquals(5, s.findMedianSortedArrays(nums2, nums1), 1e-8);
	}

	@Test
	public void testFindMedianSortedArrays_shortcut_partial_nums2_variant() {
		int[] nums1 = {0, 1,    3,       6,    8, 9, 10};
		int[] nums2 = {	     2,    4, 5,    7,         };
		assertEquals(5, s.findMedianSortedArrays(nums1, nums2), 1e-8);
		assertEquals(5, s.findMedianSortedArrays(nums2, nums1), 1e-8);
	}

	@Test
	public void testFindMedianSortedArrays_shortcut_partial_nums2_variant2() {
		int[] nums1 = {0, 1,    3,       6, 7, 8, 9, 10};
		int[] nums2 = {	     2,    4, 5,               };
		assertEquals(5, s.findMedianSortedArrays(nums1, nums2), 1e-8);
		assertEquals(5, s.findMedianSortedArrays(nums2, nums1), 1e-8);
	}
}
