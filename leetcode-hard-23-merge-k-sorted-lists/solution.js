/**
 * Solve the LeetCode problem "23. Merge k Sorted Lists" in JavaScrit.
 * 
 * Problem description:
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * 
 * by Zhiyong Pan on 09/04/2016
 * 
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode[]} lists
 * @return {ListNode}
 */
var mergeKLists = function(lists) {
	const n = lists.length;
	const heads = lists.map(l => l);
	var mergedHead = null;
	var mergedTail = null;
	while (true) {
		var next = -1;
		for (var i = 0; i < n; ++i) {
			if (heads[i] !== null && (next === -1 || heads[i].val < heads[next].val)) {
				next = i;
			}
		}
		if (next === -1)
			break;
		if (mergedHead === null) {
			mergedHead = mergedTail = heads[next];
		} else {
			mergedTail.next = heads[next];
			mergedTail = mergedTail.next;
		}
		heads[next] = heads[next].next;
	}
	return mergedHead;

};
