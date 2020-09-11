/**
 * Solve the LeetCode problem "154. Find Minimum in Rotated Sorted Array II" in JavaScript.
 *
 * Problem description:
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/ 
 *
 * by Zhiyong Pan on 09/02/2016  
 *
 * --------- Solution status ----------
 * Success
 * Runtime: 72 ms, faster than 88.27% of JavaScript online submissions for Find Minimum in Rotated Sorted Array II.
 * Memory Usage: 37.2 MB, less than 27.89% of JavaScript online submissions for Find Minimum in Rotated Sorted Array II.
 *
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
	if (nums.length == 1)
		return nums[0];
	if (nums[0] < nums[nums.length - 1])
		return nums[0];
	for (var i = 0; i < nums.length - 1; ++i) {
		if (nums[i] > nums[i + 1])
			return nums[i + 1];
	}
	return nums[0];
};

module.exports = findMin;