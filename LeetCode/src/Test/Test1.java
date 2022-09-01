package Test;

import utility.functions.ListNode;
import utility.functions.LinkedListUtility;


public class Test1 {
	
	public ListNode reverseList(ListNode head) {
		if(head == null) return head;
		ListNode prev = null;
		ListNode curr = head;
		
		while(head.next != null) {
			curr = head.next;
			head.next = prev;
			prev = head;
			head = curr;
		}
		head.next = prev;		
		return head;
	}
	
	public boolean hasCycle(ListNode head) {
		
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast != null & fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) return true;
		}
		return false;
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		
		ListNode slow = head;
		ListNode fast = head;		
		
		for(int i = 0; i < n; i++) {
			fast = fast.next;
		}
		if(fast == null) return head.next;    // for single node [1]
		while(fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return head;
	}
	
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode headMem = null;
		
		if(list1 == null && list2 == null) return list1;
		if(list1 == null) return list2;
		else if (list2 == null) return list1;
		
		else if(list1.val < list2.val) {
			headMem = list1;
			list1 = list1.next;
		}
		else {
			headMem = list2;
			list2 = list2.next;			
		}
		
		ListNode traversal = headMem;
		
		while(list1 != null & list2 != null) {
			if(list1.val < list2.val) {
				traversal.next = list1;				
				list1 = list1.next;
			}
			else {
				traversal.next = list2;				
				list2 = list2.next;
			}
			traversal = traversal.next;
		}
		if(list1 == null) traversal.next = list2;
		else traversal.next = list1;
		return headMem;
	}
	
	public ListNode middleNode(ListNode head) {
		ListNode slow = head, fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;		
	}
	
	public ListNode reorderList(ListNode head) {
		
		ListNode midNode = middleNode(head);
		ListNode headMem = head, 
				prev = head,
				midPrev = midNode, 
				midNodeMem = null;
		
		while(head.next != midNode) {
			head = head.next;
		}
		head.next = null;
		head = headMem;
		midNode = reverseList(midNode);
		
		while(head != null) {
			prev = head.next;
			head.next = midNode;
			head = prev;
			midPrev = midNode.next;
			midNodeMem = midNode;
			midNode.next = head;
			midNode = midPrev;
		}
		if(midNode != null) midNodeMem.next = midNode; 
		return headMem;
	}
	public static void main(String[] arg) {
		LinkedListUtility sol = new LinkedListUtility();
		 Test1 sol1 = new Test1();
		 
		 sol.printListNode(sol1.reorderList(sol.createListNode("[1,2,3,4,5]")));
		 sol.printListNode(sol1.reorderList(sol.createListNode("[1,2,3,4]")));
		 
//		 System.out.println(sol.ListNodeToList(sol1.middleNode(sol.stringToListNode("[1,2,3,4,5]"))));
//		 System.out.println(sol.ListNodeToList(sol1.middleNode(sol.stringToListNode("[1,2,3,4]"))));
		 
//		 System.out.println(sol.ListNodeToList(sol1.reverseList(sol.stringToListNode("[1,2,3,4,5]"))));
//		 System.out.println(sol.ListNodeToList(sol1.reverseList(sol.stringToListNode("[]"))));
//		 System.out.println(sol.ListNodeToList(sol1.reverseList(sol.stringToListNode("[1,2]"))));
//		 
//		 System.out.println(sol1.hasCycle(sol.cycleListNode("[1,2,3,4,5]",2)));
//		 System.out.println(sol1.hasCycle(sol.cycleListNode("[5]",0)));
//		 System.out.println(sol1.hasCycle(sol.stringToListNode("[1,2,3,4,5]")));
//		 
//		 System.out.println(sol.ListNodeToList(sol1.removeNthFromEnd(sol.stringToListNode("[1,2,3,4,5]"),2)));
//		 System.out.println(sol.ListNodeToList(sol1.removeNthFromEnd(sol.stringToListNode("[1,2]"),1)));
//		 System.out.println(sol.ListNodeToList(sol1.removeNthFromEnd(sol.stringToListNode("[1]"),1)));
		 
//		 System.out.println(sol.ListNodeToList(sol1.mergeTwoLists(sol.stringToListNode("[1,2,4]"),sol.stringToListNode("[1,3,4]"))));
//		 System.out.println(sol.ListNodeToList(sol1.mergeTwoLists(sol.stringToListNode("[]"),sol.stringToListNode("[]"))));
//		 System.out.println(sol.ListNodeToList(sol1.mergeTwoLists(sol.stringToListNode("[0]"),sol.stringToListNode("[]"))));
	}
}
