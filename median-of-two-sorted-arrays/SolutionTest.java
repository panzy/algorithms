import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class SolutionTest {

	Solution s = new Solution();
	
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
}
