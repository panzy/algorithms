/*
 * Solution for LeetCode problem Median of Two Sorted Arrays.
 *  
 * by Zhiyong Pan on Sep 4, 2020
 * 
-------- SUBMISSION STATUS ---------------------
Success
Details 
Runtime: 2 ms, faster than 99.93% of Java online submissions for Median of Two Sorted Arrays.
Memory Usage: 40.7 MB, less than 61.71% of Java online submissions for Median of Two Sorted Arrays.

-------- PROBLEM DESCRIPTION ---------------------

 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * 
4. Median of Two Sorted Arrays

Hard

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

Follow up: The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
Example 3:

Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000
Example 4:

Input: nums1 = [], nums2 = [1]
Output: 1.00000
Example 5:

Input: nums1 = [2], nums2 = []
Output: 2.00000
 

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000

*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		
		// |stop| is a position in the combined array,
		// the median is either [stop-1] or ([stop-1]+[stop])/2, depending on
		// whether is combined length is odd or even.
		// Warning: |stop| might be the end.
		int stop = (m + n) % 2 == 0 ? (m + n) / 2 : (m + n) / 2 + 1;
		assert stop >= 1;

		// nums1[0..i] and nums2[0..j] consist the first half of the combined
		// array, so
		// 	(i + 1) + (j + 1) == stop + 1
		int i = -1, j = -1;
		
		// Increase |i| and |j| until we reach |stop|.
		//
		// Method: repeatedly choose the smaller one from
		// 		nums1[i+1]
		// and
		// 		nums2[j+1]
		while (i + j + 1 < stop) {
			if (i + 1 == m) {
				j = stop - i - 1;
			} else if (j + 1 == n) {
				i = stop - j - 1;
			} else {
				if (nums1[i + 1] <= nums2[j + 1]) {
					++i;
				} else {
					++j;
				}
			}
		}
		
		// Determine the median value
		
		// |a| and |b| are the last 2 items of nums1[0..i],
		// |c| and |d| are the last 2 items of nums2[0..j].
		// Warning: 3 out of 4 might be not exist.
		// Non-existent values are marked by Integer.MIN_VALUE.
		int a, b, c, d;
		a = b = c = d = Integer.MIN_VALUE;
		
		if (i >= 0) {
			if (i > 0)
				a = nums1[i - 1];
			if (i < m)
				b = nums1[i];
		}
		
		if (j >= 0) {
			if (j > 0)
				c = nums2[j - 1];
			if (j < n)
				d = nums2[j];
		}
		
		// |v| is the value after the median in the combined array,
		// |v0| is the value before or equals to the median.
		int v = Math.max(b, d);
		int v0 = Math.max(Math.max(a, c), Math.min(b,  d));
		
		if ((m + n) % 2 == 1) {
			return v0;
		} else {
			return (v0 + v) / 2.0;
		}
    }
}