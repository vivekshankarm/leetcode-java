package utility.functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinkedListUtility {

	public ListNode createListNode(String listValue) {
		
		if(listValue.length() == 2) return null;
		String str = "";
		ListNode head = new ListNode(0);
		boolean flag = true;
		ListNode headMem = null;
		
		for(char i : listValue.toCharArray()) {
			
			if(i == '[' || i == ']') continue;
			if(i == ',') {
				head.next = new ListNode(Integer.parseInt(str));
				head = head.next;
//				System.out.println(head.value);
				str = "";
				if(flag) {
					headMem = head;
					flag = false;
				}
				continue;
			}
			str += i;
//			System.out.println(str);
		}
		head.next = new ListNode(Integer.parseInt(str));
		if(flag) headMem = new ListNode(Integer.parseInt(str));
		return headMem;
	}
	
	public void printListNode(ListNode head) {
		if(head == null) {
			return;
		}		
		while(head != null) {
			System.out.print(head.val + "->");			
			head = head.next;
		}	
		System.out.println();
	}
	
	public ListNode createCycleListNode(String listValue, int index) {
		
		ListNode head = createListNode(listValue);
		
		if(index == -1) return head;
		ListNode headMem = head;
		int count = 0;
		ListNode cycle = null;
		ListNode prev = null;  //for [5] one node cycle
		
		while(head != null) {
			if(count == index) cycle = head;
			prev = head;
			head = head.next;
			count++;
		}
		prev.next = cycle;
		return headMem;
	}
    public ListNode convertListToLinkedList (int[] inputList) {
    	
    	ListNode head = null;
    	if(inputList.length == 0) return head;
    	head = new ListNode(inputList[0]);
    	ListNode curr = head;
    	
    	for(int i = 1; i < inputList.length; i++) {
    		curr.next = new ListNode(inputList[i]);
    		curr = curr.next;
    	}
    	return head;
    }
	
//	public List<ListNode> stringTwoDimToListNode(String listValue) {
////		if(listValue.length() == 2) return null;
//		
//		StringBuilder inputList = new StringBuilder(listValue);
//		inputList.replace(inputList.length(), inputList.length() - 1, "");
//		inputList.replace(0, 1, "");
//		
//		String str = "";
//		List<ListNode> twoDimList = new ArrayList<ListNode>();
//		ListNode head = new ListNode(0);
//		boolean flag = true;
//		ListNode headMem = null;
//		char prevI;
//		
//		for(char i : listValue.toCharArray()) {
//			
//			if(i == '[') continue;
//			if(i == ']') {
//				head.next = new ListNode(Integer.parseInt(str));
//			}
//			if(i == ',' && prevI != ']') {
//				head.next = new ListNode(Integer.parseInt(str));
//				head = head.next;
////				System.out.println(head.value);
//				str = "";
//				if(flag) {
//					headMem = head;
//					flag = false;
//				}
//				continue;
//			}
//			str += i;
//			prevI = i;
////			System.out.println(str);
//		}
//		
//		if(flag) headMem = new ListNode(Integer.parseInt(str));
//		return headMem;
//	}

	public static void main(String[] arg) {
		LinkedListUtility sol = new LinkedListUtility();
		sol.printListNode(sol.createListNode("[3,12,0,-4]"));
		sol.printListNode(sol.createListNode("[-8,0,0,-4]"));
		sol.printListNode(sol.createListNode("[-25]"));
		sol.printListNode(sol.createListNode("[]"));
		
		sol.printListNode(sol.convertListToLinkedList(new int[]{3,12,0,-4}));
		
//		ListNode b = sol.createListNode("[1,3,4]");
	}
}



