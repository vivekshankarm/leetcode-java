package zoho;

import java.util.ArrayList;
import java.util.List;

public class ReverseStringWithSpacesIntact {
	
	String reverseWithSpacesIntact(String S) {
		
		// wrong approach
		/*List<Integer> space = new ArrayList<Integer>();
		String ans = "";
		String tmp = "";
		
		for(int i = 0; i < S.length(); i++) {
			if(S.charAt(i) == ' ')
				space.add(i);
			else tmp += S.charAt(i);
		}
		int left = 0;
		int right = S.length() - 1;
		for(int j = S.length() - 1; j >= 0; j--) {
			if(space.contains(left))
				ans += " ";
			
			else 
				ans += tmp.charAt(j);
			
			left++;			
		}
		return ans;*/
		
		// recreated based on online
		int start = 0;
		int end = S.length() - 1;
		char[] ans = S.toCharArray();
		
		while(start < end) {
			if(ans[start] == ' ') start++;
			
			else if (ans[end] == ' ') end--;
			
			else {
				char tmp = ans[start];
				ans[start] = ans[end];
				ans[end] = tmp;
				start++;
				end--;
			}
		}		
		return String.valueOf(ans);
	}
	public static void main(String[] arg) {
		ReverseStringWithSpacesIntact sol = new ReverseStringWithSpacesIntact();
		System.out.println(sol.reverseWithSpacesIntact("Help others"));
		System.out.println(sol.reverseWithSpacesIntact("geeksforgeeks"));
		System.out.println(sol.reverseWithSpacesIntact(""));
		System.out.println(sol.reverseWithSpacesIntact(" "));
		System.out.println(sol.reverseWithSpacesIntact("i am doctor"));
		System.out.println(sol.reverseWithSpacesIntact("  ynf"));
	}
}
