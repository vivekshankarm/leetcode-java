
public class E_ValidPalindrome {
	
		// wrong approach
//    public boolean validPalindrome(String s) {
//		int start = 0;
//		int end = s.length() -1;
//		boolean flag = true;
//		
//		if (s.length() == 1 | s.length() == 2)
//			return true;
//		while (start <= end) {
//			int diff = end - start;
//			if (s.charAt(start) == s.charAt(end)) {
//				start += 1;
//				end -= 1;
//			}
//			else if (diff >= 2 && s.charAt(start) == s.charAt(end - 1) && flag) {
//				start += 1;
//				end -= 2;
//				flag = false;
//			}
//			else if (diff >= 2 && s.charAt(start + 1) == s.charAt(end) && flag) {
//				start += 2;
//				end -= 1;
//				flag = false;
//			} else if (diff == 1 && flag) {
//				return true;
//			} else {
//				return false;
//			}
//		}
//    	return true;
	
	public boolean checkPalindrome(String s, int start, int end) {
		
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) 
				return false;
			start++;
			end--;
		}
		return true;
	}
	
	public boolean validPalindrome(String s) {
		
		int start = 0;
		int end = s.length() - 1;
		
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return (checkPalindrome(s, start, end -1) || checkPalindrome(s, start + 1, end));
			}
			start++;
			end--;
		}
		return true;		
    }
    
    public static void main(String[] arg) {
    	E_ValidPalindrome sol = new E_ValidPalindrome();
    	System.out.println(sol.validPalindrome("abc"));		//false
    	System.out.println(sol.validPalindrome("abca"));	//true
    	System.out.println(sol.validPalindrome("acbbc"));//true
    	System.out.println(sol.validPalindrome("aba"));	//true
    	System.out.println(sol.validPalindrome("ab"));  //true
    	System.out.println(sol.validPalindrome("cbbcc"));  //true
    	System.out.println(sol.validPalindrome("eeccccbebaeeabebccceea"));  //false
    	System.out.println(sol.validPalindrome("eeccccbebaeeabebccceea")); // false
    }
}
