import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class H_LongestValidParentheses {
	
	public int longestValidParentheses(String s) {
		
		// struck inbetween
		/*if(s.length() == 0) return 0;	
		int count = 0;
		int maxVal = 0;		
		Stack<Character> stack = new Stack<Character>();		
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				stack.add('(');
			}
			else if(s.charAt(i) == ')' && stack.isEmpty()) {
				maxVal = Math.max(maxVal, count*2);
				count = 0;
			}
			else if(s.charAt(i) == ')' && stack.peek() == '(') {
				stack.pop();
				count++;
			}
			
		}
		return Math.max(maxVal, count*2);*/
		
		// from online
        LinkedList<Integer> stack = new LinkedList<>();
        int result = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
                stack.pop();
                result = Math.max(result, i - stack.peek());
            } else {
                stack.push(i);
            }
        }
        return result;
	}
	public static void main(String[] arg) {
		H_LongestValidParentheses sol = new H_LongestValidParentheses();
		System.out.println(sol.longestValidParentheses("(()"));
		System.out.println(sol.longestValidParentheses(")()())"));
		System.out.println(sol.longestValidParentheses(""));
		System.out.println(sol.longestValidParentheses("()(()")); //missed test case
		System.out.println(sol.longestValidParentheses("()()(()"));
	}
} 

