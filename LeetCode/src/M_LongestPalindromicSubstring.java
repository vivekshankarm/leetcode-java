
public class M_LongestPalindromicSubstring {
	
	public String longestPalindrome(String s) {
		
		// correct sol recreated from online
		/*int left,right;
		int[] res = {0,s.length()};
		int max = 0;
		String resString = "";
		
		//odd number
		for(int i = 0; i < s.length(); i++) {
			left = i - 1;
			right = i + 1;
			while(left >= 0 && right < s.length()) {
				if(s.charAt(left) != s.charAt(right)) break;
				left--;
				right++;
			}
			if(max < right - left -1) {
				res[0] = left + 1;
				res[1] = right - 1;
				max = right - left -1;
			}			
		}
		// even number - edge case
		for(int i = 0; i < s.length(); i++) {
			left = i;
			right = i + 1;
			while(left >= 0 && right < s.length()) {
				if(s.charAt(left) != s.charAt(right)) break;
				left--;
				right++;
			}
			if(max < right - left -1) {
				res[0] = left + 1;
				res[1] = right - 1;
				max = right - left -1;
			}			
		}
		for(int j = res[0]; j < res[1] + 1; j++) {
			resString += s.charAt(j);
		}
		return resString; */
		
		// copied optimal sol from online
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
	
	public static void main(String[] arg) {
		M_LongestPalindromicSubstring sol = new M_LongestPalindromicSubstring();
		System.out.println(sol.longestPalindrome("babad"));
		System.out.println(sol.longestPalindrome("cbbd"));
		System.out.println(sol.longestPalindrome("a"));
		System.out.println(sol.longestPalindrome("adaccbbcc"));
	}
}
