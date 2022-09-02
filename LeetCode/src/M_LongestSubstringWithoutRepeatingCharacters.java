import java.util.HashMap;
import java.util.Map;

public class M_LongestSubstringWithoutRepeatingCharacters {
	
	public int lengthOfLongestSubstring(String s) {
		
		// correct sol using dictionary
		/*if (s.length() == 0) return 0;
		int maxValue = 0;		
		Map<Character, Integer> dic = new HashMap<Character, Integer>();
		
		for(int i = 0, j = 0; i < s.length(); i++) {
			if (dic.containsKey(s.charAt(i))) {
				j = Math.max(j, dic.get(s.charAt(i)) + 1);        // instead of clearing dictionary doing Math.max
			}
			maxValue = Math.max(maxValue, i - j + 1);
			dic.put(s.charAt(i), i);
		}
		return maxValue; */
		
		// optimal sol without using dictionary
        int left = 0;
        int right = 0;
        int result = 0;
        int[] chars = new int[128];
        while(right < s.length()){
            char c = s.charAt(right);
            if(chars[c] > 0) {
                left = Math.max(left, chars[c]);
            }
            result = Math.max(result, right - left + 1);
            chars[c] = ++right;
        }
        return result;
	}
	public static void main(String[] arg) {
		M_LongestSubstringWithoutRepeatingCharacters sol = new M_LongestSubstringWithoutRepeatingCharacters();
		System.out.println(sol.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(sol.lengthOfLongestSubstring(""));
		System.out.println(sol.lengthOfLongestSubstring("a"));
		System.out.println(sol.lengthOfLongestSubstring("bbbb"));
		System.out.println(sol.lengthOfLongestSubstring("pwwkew"));
		System.out.println(sol.lengthOfLongestSubstring("abcbdf"));
		System.out.println(sol.lengthOfLongestSubstring("abba"));  // corner case
	}
}
