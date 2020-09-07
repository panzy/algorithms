/*
 * Solve the LeetCode problem "25. Reverse Nodes in k-Group" in Java.
 * 
 * Problem description:
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * 
 * by Zhiyong Pan on 7-Sep-2020
 * 
 * -------- Solution status -----------------------
 * Success
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Nodes in k-Group.
 * Memory Usage: 39.7 MB, less than 63.99% of Java online submissions for Reverse Nodes in k-Group.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
    	
    	// Point to the head of the first group.
    	// This is also the return value of this function.
    	ListNode firstGroupHead = null;
    	
    	// Point to the last node of the last processed group.
    	// We use it to attach a new group.
    	ListNode lastGroupTail = null;
    	
    	// For each group, |a| is the first node, and |b| is the end.
    	ListNode a = head;
    	ListNode b;
    	
    	// Process groups.
    	while (a != null) {
    		// find |b|
    		b = a.next;
    		int i = 1;
    		for (; i < k && b != null; ++i) {
    			b = b.next;
    		}

    		if (i == k) {
    			ListNode nextGroup = b;
    			ListNode thisGroup = reverse(a, b);

    			if (firstGroupHead == null)
    				firstGroupHead = thisGroup;
    			else
    				lastGroupTail.next = thisGroup;

    			lastGroupTail = a;
    			a = nextGroup;
    		} else {
    			if (firstGroupHead == null)
    				firstGroupHead = a;
    			break;
    		}
    	}
    	
    	return firstGroupHead;
    }
    
    /**
     * Reverse nodes between [begin, end).
     * 
     * The |end| is guaranteed to be still accessible from the reversed nodes.
     * 
     * @param begin the first node
     * @param end the node after the last node.
     * @return The head of the reversed range.
     */
    static ListNode reverse(ListNode begin, ListNode end) {
    	if (begin == null) return null;
    	
    	ListNode p = begin;
    	ListNode q = p.next;
    	ListNode r;
    	
    	while (q != end) {
    		r = q.next;
    		q.next = p;
    		p = q;
    		q = r;
    	}
    	
    	// |begin| is now the last node of the reversed range,
    	// it should point to |end|.
    	begin.next = end;

    	return p;
    }
}
