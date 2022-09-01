import java.util.PriorityQueue;

import Test.Test1;
import utility.functions.LinkedListUtility;
import utility.functions.ListNode; 

public class H_MergekSortedLists {
	
	public ListNode mergeKLists(ListNode[] lists) {
		
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((ListNode a,ListNode b) -> a.val - b.val);
		
		for(ListNode i : lists) {
			if(i != null)
				pq.add(i);
		}
		ListNode head = new ListNode(0);
		ListNode headMem = head;
		while(!pq.isEmpty()) {
			head.next = pq.poll();
			head = head.next;
			
			if(head.next != null)
				pq.add(head.next);
		}
		return headMem.next;
	}
	public static void main(String[] arg) {
		 LinkedListUtility sol = new LinkedListUtility();
		 H_MergekSortedLists sol1 = new H_MergekSortedLists();
		 sol.printListNode(sol1.mergeKLists(new ListNode[] {sol.createListNode("[1,4,5]"),sol.createListNode("[1,3,4]"),sol.createListNode("[1,4,5]")}));
		 sol.printListNode(sol1.mergeKLists(new ListNode[] {sol.createListNode("[]"),sol.createListNode("[3]"),sol.createListNode("[1,4,5]")}));
		 sol.printListNode(sol1.mergeKLists(new ListNode[] {sol.createListNode("[]"),sol.createListNode("[]")}));
		 sol.printListNode(sol1.mergeKLists(new ListNode[] {sol.createListNode("[]")}));
		 sol.printListNode(sol1.mergeKLists(new ListNode[] {sol.createListNode("[]")}));
	}
}
