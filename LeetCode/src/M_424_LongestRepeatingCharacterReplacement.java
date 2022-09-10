
public class M_424_LongestRepeatingCharacterReplacement {
	
    public int characterReplacement(String s, int k) {
        
    	int[] count = new int[26];
    	int maxFreq = 0, maxLen = 0, start = 0;
    	
    	for(int end = 0; end < s.length(); end++) {
    		maxFreq = Math.max(maxFreq, ++count[s.charAt(end) - 'A']);
    		while(end - start + 1 - maxFreq > k) {	// instead of while if condition is used time increased by double
    			count[s.charAt(start) - 'A']--;
    			start++;
    		}
    		maxLen = Math.max(maxLen, end - start + 1);
    	}
    	return maxLen;
    }
    public static void main(String[] arg) {
    	M_424_LongestRepeatingCharacterReplacement sol = new M_424_LongestRepeatingCharacterReplacement();
    	System.out.println(sol.characterReplacement("ABAB", 2));
    	System.out.println(sol.characterReplacement("AABABBA", 1));
    	System.out.println(sol.characterReplacement("AAEBAE", 1)); 
    }
}
