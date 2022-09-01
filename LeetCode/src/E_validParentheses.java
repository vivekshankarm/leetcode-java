import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class E_validParentheses {
	
	public boolean isValid(String s) {
		// correct sol
		/*Stack<Character> stack = new Stack<Character>();
		Map<Character,Character> symbolMap = new HashMap<Character, Character>(Map.of('[',']','{','}','(',')'));
		
		for(char i : s.toCharArray()) {
			if(symbolMap.containsKey(i))
				stack.add(symbolMap.get(i));
			
			else if (stack.isEmpty() || stack.pop() != i) {
				return false;
			}			
		}
		return (stack.isEmpty()) ? true : false;*/
		
		// recreated based on online using char like stack(optimal)
		char[] stack = new char[s.length()];
		int cnt = 0;
		for(char i : s.toCharArray()) {
			if(i == '}') {
				if(cnt > 0 && stack[cnt - 1] == '{') cnt--;
				else return false;
			}
			else if(i == ']') {
				if(cnt > 0 && stack[cnt - 1] == '[') cnt--;
				else return false;
			}
			else if(i == ')') {
				if(cnt > 0 && stack[cnt - 1] == '(') cnt--;
				else return false;
			}
			else {
				stack[cnt] = i;
				cnt++;
			}
		}
		return cnt == 0;
		
		// easy to understand
		/* 	for (char c : s.toCharArray()) {
		if (c == '(')
			stack.push(')');
		else if (c == '{')
			stack.push('}');
		else if (c == '[')
			stack.push(']');
		else if (stack.isEmpty() || stack.pop() != c)
			return false;
	}
	return stack.isEmpty();*/
	}
	public static void main(String[] arg) {
		E_validParentheses sol = new E_validParentheses();
		System.out.println(sol.isValid("()"));			//true
		System.out.println(sol.isValid("()[]{}"));		//true
		System.out.println(sol.isValid("(]"));			//false
		System.out.println(sol.isValid("("));			//false
		System.out.println(sol.isValid("}"));			//false
		System.out.println(sol.isValid("()]{}}"));		//false
	}
}
