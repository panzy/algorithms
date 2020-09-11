/**
 * Solve the LeetCode problem "154. Find Minimum in Rotated Sorted Array II" in JavaScript.
 *
 * Problem description:
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/ 
 *
 * by Zhiyong Pan on 11 Sep, 2020
 *
 * --------- Solution status ----------
 * Success
 * Runtime: 76 ms, faster than 76.27% of JavaScript online submissions for Find Minimum in Rotated Sorted Array II.
 * Memory Usage: 37.3 MB, less than 20.59% of JavaScript online submissions for Find Minimum in Rotated Sorted Array II.
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
	if (nums.length == 1)
		return nums[0];
	if (nums[0] < nums[nums.length - 1])
		return nums[0];

  return binarysearch(nums, 0, nums.length - 1);
};

// binary search between [lo, hi].
function binarysearch(nums, lo, hi) {
	let mi = Math.floor((lo + hi) / 2);

	if (mi === lo) return nums[hi] < nums[mi] ? nums[hi] : nums[lo];

	if (nums[lo] < nums[mi]) {
		// numbers between [lo] and [mi] are ordered, so the pivot should be on the right
		return binarysearch(nums, mi, hi);
	} else if (nums[lo] === nums[mi]) {
		// the pivot could be on either side, for example:
		//  L             M               H
		// [2,2,2,2,2,2,2,2,2,2,2,4,5,6,0,2] <- 0 is on the right
		// [2,2,4,5,6,0,2,2,2,2,2,2,2,2,2,2] <- 0 is on the left
		return Math.min(
			binarysearch(nums, lo, mi),
			binarysearch(nums, mi, hi));
	} else {
		// the pivot should bre on the left
		return binarysearch(nums, lo, mi);
	}
}

module.exports = findMin;