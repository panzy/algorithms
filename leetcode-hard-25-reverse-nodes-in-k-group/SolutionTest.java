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

	ListNode toList(int[] a) {
		if (a == null || a.length < 1) return null;
		ListNode head = new ListNode(a[0]);
		ListNode last = head;
		for (int i = 1; i < a.length; ++i) {
			last.next = new ListNode(a[i]);
			last = last.next;
		}
		return head;
	}
	
	String join(ListNode head) {
		String s = "";
		ListNode p = head;
		while (p != null) {
			if (!s.isEmpty()) s += ',';
			s += p.val;
			p = p.next;
		}
		return s;
	}
	
	@Test
	public final void testToList() {
		assertEquals("", join(toList(new int[] { })));
		assertEquals("1,2,3", join(toList(new int[] { 1, 2, 3 })));
	}

	@Test
	public final void testReverse() {
		assertEquals("", join(Solution.reverse(toList(new int[] { }), null)));
		assertEquals("1", join(Solution.reverse(toList(new int[] { 1 }), null)));
		assertEquals("2,1", join(Solution.reverse(toList(new int[] { 1, 2 }), null)));
		assertEquals("3,2,1", join(Solution.reverse(toList(new int[] { 1, 2, 3 }), null)));
		assertEquals("7,6,5,4,3,2,1", join(Solution.reverse(toList(new int[] { 1, 2, 3, 4, 5, 6, 7 }), null)));
	}

	@Test
	public final void testReverse_should_reserve_leftover() {
		ListNode a = toList(new int[] { 1, 2, 3 });
		ListNode b = a.next.next; // point to 2
		assertEquals("2,1,3", join(Solution.reverse(a, b))); // should not drop "3"
	}

	@Test
	public final void testReverseKGroup() {
		Solution s = new Solution();
		
		// k = 0
		assertEquals("", join(s.reverseKGroup(toList(new int[] { }), 0)));
		assertEquals("1", join(s.reverseKGroup(toList(new int[] { 1 }), 0)));
		assertEquals("1,2", join(s.reverseKGroup(toList(new int[] { 1,2 }), 0)));
		
		// 2 / 1
		assertEquals("1,2", join(s.reverseKGroup(toList(new int[] { 1,2 }), 1)));
		
		// 2 / 2
		assertEquals("2,1", join(s.reverseKGroup(toList(new int[] { 1,2 }), 2)));

		// 3 / 2
		assertEquals("2,1,3", join(s.reverseKGroup(toList(new int[] { 1,2,3 }), 2)));
		
		// 3 / 3
		assertEquals("3,2,1", join(s.reverseKGroup(toList(new int[] { 1,2,3 }), 3)));

		// 4 / 2
		assertEquals("2,1,4,3", join(s.reverseKGroup(toList(new int[] { 1,2,3,4 }), 2)));

		// 5 / 2
		assertEquals("2,1,4,3,5", join(s.reverseKGroup(toList(new int[] { 1,2,3,4,5 }), 2)));

		// 7 / 3
		assertEquals("3,2,1,6,5,4,7", join(s.reverseKGroup(toList(new int[] { 1,2,3,4,5,6,7 }), 3)));
	}
}
