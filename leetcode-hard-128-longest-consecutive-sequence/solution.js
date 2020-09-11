/**
 * Solve the LeetCode problem 128. "Longest Consecutive Sequence" in JavaScript.
 *
 * Problem description:
 * https://leetcode.com/problems/longest-consecutive-sequence/ 
 *
 * by Zhiyong Pan on 09/04/2016 
 *
 * @param {number[]} nums
 * @return {number}
 */
var longestConsecutive = function(nums) {

	const allNums = new Set();
	nums.forEach(i => allNums.add(i));

	const visited = new Set();

	var L = 0;
	nums.forEach(curr => {
		if (!visited.has(curr)) {

			var rightOffset = 1;
			while (true) {
				var nextNum = curr + rightOffset;
				if (allNums.has(nextNum)) {
					visited.add(nextNum);
					++rightOffset;
				} else {
					break;
				}
			}

			var leftOffset = 1;
			while (true) {
				var prev = curr - leftOffset;
				if (allNums.has(prev)) {
					visited.add(prev);
					++leftOffset;
				} else {
					break;
				}
			}

			var l = leftOffset + rightOffset - 1;
			//console.log(curr, rightOffset, leftOffset, l);
			if (l > L)
				L = l;
		}
	});
	return L;
}

module.exports = longestConsecutive;