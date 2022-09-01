

//Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;
	
	ListNode () {};
	ListNode(int val) {
		this.val = val;
	}
	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
	public static void main(String[] arg) {
		ListNode sol = new ListNode();
	}
}
 
public class LinkedList {

    public ListNode insertAtBegining (int val,ListNode head) {
    	ListNode newNode = new ListNode(val);
    	newNode.next = head;
    	return newNode;
    }
    
    public ListNode insertAtEnd (int val, ListNode head) {
    	
    	ListNode curr = head;
    	if(curr == null) {
    		head = new ListNode(val);
    		return head;
    	}
    	while(curr.next != null) {
    		curr = curr.next;
    	}
    	curr.next = new ListNode(val);
    	return head;
    }
    
    public void printLinkedList(ListNode head) {
    	while(head != null) {
    		System.out.print(head.val + " ");
    		head = head.next;
    	}
    	System.out.println();
    }
    
    public ListNode insertListToLinkedList (int[] inputList) {
    	
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
    
    public ListNode reverseLinkedList(ListNode head) {
    	
    	if(head == null) return head;
    	ListNode prev = null;
    	ListNode curr = head;
    	
    	while(curr.next != null) {
    		curr = curr.next;
    		head.next = prev;
    		prev = head;
    		head = curr;
    	}
    	head.next = prev;
    	return head;
    }
    
    public boolean hasCycle(ListNode head) {
        ListNode slow  = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        	if(fast == slow) return true;
        }
        return false;
    }
    
    public ListNode deleteDuplicates(ListNode head) {     	
        ListNode curr = head;
        
        while(curr != null && curr.next != null) {
        	if(curr.val == curr.next.val) {
        		curr.next = curr.next.next;
        	}
        	else curr = curr.next;
        }
        if(head != null && head.next != null) {
        	return (head.val == head.next.val) ? head.next : head;
        }
        return head;
    }
    
    public ListNode removeElements(ListNode head, int val) {
        ListNode curr = head;
        
        while(curr != null && curr.next != null) {
        	if(curr.next.val == val) {
        		curr.next = curr.next.next;
        		continue;
        	}
        	curr = curr.next;
        }
        if(head != null && head.val == val) return head.next;
        return head;
    }
    
    public ListNode middleNode(ListNode head) {    	
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        return slow;
    }
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    	
        if(list1 != null && list2 != null) {
        	ListNode head = null;
        	if(list1.val <= list2.val) {
        		head = list1;
        		list1 = list1.next;
        	}
        	else {
        		head = list2;
        		list2 = list2.next;
        	}
        	ListNode headMem = head;
        	while(list1 != null && list2 != null) {
            	if(list1.val <= list2.val) {
            		head.next = list1;
            		list1 = list1.next;
            	}
            	else {
            		head.next = list2;
            		list2 = list2.next;
            	}
            	head = head.next;
        	}
        	if(list1 != null) {
        		head.next = list1;       		
        	}
        	else if (list2 != null) {
        		head.next = list2;
        	}
        	return headMem;
        }
        else if (list1 != null) return list1;
        else return list2;
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	
        ListNode slow = head, fast = head;
        
        for(int i = 0; i < n; i++) {
        	fast = fast.next;
        }
        if(fast == null) return head.next;
        
        while(fast.next != null) {
        	slow = slow.next;
        	fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
    
    public ListNode reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }        
        
        ListNode middleMem = slow;
    	ListNode prev = null;
    	ListNode curr = slow;
    	
    	while(curr.next != null) {
    		curr = curr.next;
    		slow.next = prev;
    		prev = slow;
    		slow = curr;
    	}
    	slow.next = prev;
    	
    	ListNode headMem = head;
    	ListNode reorder = head;
    	head = head.next;
    	while(reorder != null && head != null) {
    		reorder.next = slow;
    		slow = slow.next;  
    		reorder = reorder.next;
    		if(head == middleMem) break;
    		reorder.next = head;
    		head = head.next;
    		reorder = reorder.next;
    	}
    	return headMem;
    }
    
    public static void main(String[] arg) {
    	
    	LinkedList sol = new LinkedList();
//    	ListNode x = sol.insertAtBegining(4, null);
//    	ListNode y = sol.insertAtBegining(3, x);
//    	ListNode z = sol.insertAtBegining(2, y);
//    	ListNode a = sol.insertAtBegining(1, z);
//    	
//    	sol.printLinkedList(a);
//    	System.out.println(" ");
//    	
//    	ListNode b = sol.insertAtEnd(4, null);
//    	ListNode c = sol.insertAtEnd(3, b);
//    	ListNode d = sol.insertAtEnd(2, c);
//    	ListNode e = sol.insertAtEnd(1, d);
//    	sol.printLinkedList(c);
//    	System.out.println();
//    	
//    	ListNode head = sol.insertListToLinkedList(new int[] {1,2,3,4,5});
//    	sol.printLinkedList(sol.reverseLinkedList(head));  
//    	System.out.println();
//    	sol.printLinkedList(sol.reverseLinkedList(sol.insertListToLinkedList(new int[] {1,2,3,4}))); 
//    	System.out.println();
//    	sol.printLinkedList(sol.reverseLinkedList(sol.insertListToLinkedList(new int[] {1}))); 
//    	System.out.println();
    	
//    	sol.printLinkedList(sol.deleteDuplicates(sol.insertListToLinkedList(new int[] {1,1,2})));
//    	sol.printLinkedList(sol.deleteDuplicates(sol.insertListToLinkedList(new int[] {1,1,2,3,3})));
//    	sol.printLinkedList(sol.deleteDuplicates(sol.insertListToLinkedList(new int[] {1})));
//    	sol.printLinkedList(sol.deleteDuplicates(sol.insertListToLinkedList(new int[] {1,1})));
//    	sol.printLinkedList(sol.deleteDuplicates(sol.insertListToLinkedList(new int[] {1,2,2,2})));
    	
//    	sol.printLinkedList(sol.removeElements(sol.insertListToLinkedList(new int[] {1,2,6,3,4,5,6,6}),6));
//    	sol.printLinkedList(sol.removeElements(sol.insertListToLinkedList(new int[] {7,7,7,7}),7));
//    	sol.printLinkedList(sol.removeElements(sol.insertListToLinkedList(new int[] {}),1));
//    	sol.printLinkedList(sol.removeElements(sol.insertListToLinkedList(new int[] {1,1,2,3,4,5,6}),1));
    	
//    	sol.printLinkedList(sol.middleNode(sol.insertListToLinkedList(new int[] {1,2,3,4,5})));
//    	sol.printLinkedList(sol.middleNode(sol.insertListToLinkedList(new int[] {1,2,3,4,5,6})));
//    	sol.printLinkedList(sol.middleNode(sol.insertListToLinkedList(new int[] {1})));
    	
//    	sol.printLinkedList(sol.mergeTwoLists(sol.insertListToLinkedList(new int[] {1,2,4}),sol.insertListToLinkedList(new int[] {1,3,4})));
//    	sol.printLinkedList(sol.mergeTwoLists(sol.insertListToLinkedList(new int[] {}),sol.insertListToLinkedList(new int[] {})));
//    	sol.printLinkedList(sol.mergeTwoLists(sol.insertListToLinkedList(new int[] {}),sol.insertListToLinkedList(new int[] {0})));
//    	sol.printLinkedList(sol.mergeTwoLists(sol.insertListToLinkedList(new int[] {1,2,4}),sol.insertListToLinkedList(new int[] {2,3,5,6,7})));
    	
//    	sol.printLinkedList(sol.removeNthFromEnd(sol.insertListToLinkedList(new int[] {1,2,3,4,5}),2));
//    	sol.printLinkedList(sol.removeNthFromEnd(sol.insertListToLinkedList(new int[] {1}),1));   	// corner case
//    	sol.printLinkedList(sol.removeNthFromEnd(sol.insertListToLinkedList(new int[] {1,2}),1));
//    	sol.printLinkedList(sol.removeNthFromEnd(sol.insertListToLinkedList(new int[] {1,2,3,4,5}),5));
    	
    	sol.printLinkedList(sol.reorderList(sol.insertListToLinkedList(new int[] {1,2,3,4,5,6})));
    	sol.printLinkedList(sol.reorderList(sol.insertListToLinkedList(new int[] {1,2,3,4,5})));
    	sol.printLinkedList(sol.reorderList(sol.insertListToLinkedList(new int[] {1,2,3,4})));
    	sol.printLinkedList(sol.reorderList(sol.insertListToLinkedList(new int[] {1})));
    }
}
