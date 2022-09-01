import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class M_RemoveAllAdjacentDuplicatesInStringII {
    public String removeDuplicates(String s, int k) {
    	// correct sol but timelimit exceeded O(n3)
    	/*outerloop:
	    	while(true) {
	    		Map<Character, Integer> count = new HashMap<>();
	    		int num = 0;
	    		for(int i = 0; i < s.length(); i++) {
	    			if (s == "") {
	    				break outerloop;
	    			}
	    			count.put(s.charAt(i),(count.getOrDefault(s.charAt(i), 0) + 1));
	    			if(num != k)
	    				num += 1;
	    			if (num == k) {
	    				if (count.get(s.charAt(i)) == k) {
	    					if(i - k < 0) {
	    						s = s.substring(i + 1);
	    					}
	    					else {
	    						s = s.substring(0, i - k + 1) + s.substring(i + 1);
	    					}
	    					break;
	    				}
	    				count.put(s.charAt(i - k + 1),(count.get(s.charAt(i-k+1)) - 1));    				
	    			} 
   			
	    			
	    			if (i == s.length() -1) {
	    				break outerloop;
	    			}
	    		}
	    	}
    	return s;   */  
    	
    	// recreating online solution O(n)
    	
    	/* Stack<ArrayList> stack = new Stack<ArrayList>();
    	List<Object> toAddInStack = new ArrayList<>();
    	toAddInStack.add("#");
    	toAddInStack.add(0);
    	stack.add((ArrayList) toAddInStack);
    	
    	for(Character c : s.toCharArray()) {
    		if (stack.lastElement().get(0) == c) {
    			int update = (Integer)stack.lastElement().get(1) + 1;
    			stack.lastElement().set(1, update);
    			
    			if ((Integer)stack.lastElement().get(1) == k) {
    				stack.pop();
    			}
    		} else {
    			List<Object> tmp = new ArrayList<>();
    			tmp.add(c);    			
    			tmp.add(1);
    			stack.add((ArrayList) tmp);
    		}
    	}
    	String res = "";
    	System.out.println(stack);
    	for (int i = 1; i <= stack.size()-1; i++) {
    		String chatToRepeat = String.valueOf((char) stack.get(i).get(0));
    		int n = (Integer)stack.get(i).get(1);
    		res += chatToRepeat.repeat(n);
    	}
    	return res;    	*/
    	
    	// from online
        int[] count = new int[s.length()];
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            sb.append(c);
            int last = sb.length()-1;
            count[last] = 1 + (last > 0 && sb.charAt(last) == sb.charAt(last-1) ? count[last-1] : 0);
            if(count[last] >= k) sb.delete(sb.length()-k, sb.length());
        }
        return sb.toString();    
    }
    public static void main(String[] arg) {
    	M_RemoveAllAdjacentDuplicatesInStringII sol = new M_RemoveAllAdjacentDuplicatesInStringII();
    	System.out.println(sol.removeDuplicates("deeedbbcccbdaa", 3));
    	System.out.println(sol.removeDuplicates("abcd", 2));    	
    	System.out.println(sol.removeDuplicates("pbbcggttciiippooaais", 2));
    }
}
