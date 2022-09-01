
public class E_LongestPalindrome {
	
    public int longestPalindrome(String s) {        
    	int[] cache = new int[128];
    	int count = 0;
    	
    	for(char c : s.toCharArray()) {
    		int index = c;
    		if (cache[index] == 0) {
    			cache[index] = 1;
    		} else {
    			cache[index] = 0;
    			count += 2;
    		}
    	}
    	for(int i : cache) {
    		if(i == 1) {
    			return count + 1;
    		}
    	}
    	return count;
    }
    public static void main(String[] arg) {
    	E_LongestPalindrome sol = new E_LongestPalindrome();
    	System.out.println(sol.longestPalindrome("abccccdd"));
    	System.out.println(sol.longestPalindrome("a"));
    	System.out.println(sol.longestPalindrome("acac"));
    	System.out.println(sol.longestPalindrome("acacde"));
    	System.out.println(sol.longestPalindrome("bb"));
    }
}
