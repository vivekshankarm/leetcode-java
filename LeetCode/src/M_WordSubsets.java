import java.util.ArrayList;
import java.util.List;

public class M_WordSubsets {
	
    public List<String> wordSubsets(String[] words1, String[] words2) {
    	
    	// misunderstood subset as subsequence
    	/*List<String> res = new ArrayList<String>();
    	boolean[] resBoolean = new boolean[words1.length];
    	  	
    	
    	for(String t : words2) {
    		int count = 0;  
    		for(String s : words1) {
    			
    	        int sIndex = 0;
    	        int tIndex = 0;
    	        
    	        while((sIndex < s.length()) && (tIndex < t.length())) {
    	        	if(t.charAt(tIndex) == s.charAt(sIndex)) {        		
    	        		tIndex++;
    	        	}
    	        	sIndex++;
    	        }
    	        if(tIndex == t.length() && !resBoolean[count]) resBoolean[count] = false;
    	        else resBoolean[count] = true;
    	        count++;
    		}
    		
    	}
    	
    	for(int i = 0; i < resBoolean.length; i++) {
    		if(!resBoolean[i]) res.add(words1[i]);
    	}
    	return res; */
    	
    	List<String> res = new ArrayList<String>();
    	boolean[] resBoolean = new boolean[words1.length];
    	int[] combinedWords2 = new int[26];
    	int count = 0;
    	
    	for(String word2 : words2) {
    		int[] tmp = new int[26];
    		
    		for(char i : word2.toCharArray()) {
    			int index = i - 'a';    			
    			combinedWords2[index] = Math.max(combinedWords2[index], (tmp[index] += 1));
    		}    		
    	}
    	
     	for(String word1 : words1) {
    		int[] tmp1 = new int[26];
    		
    		for(char j : word1.toCharArray()) {
    			int index = j - 'a';
    			tmp1[index] += 1;
    		}
    		resBoolean[count] = compareWords(tmp1, combinedWords2);
    		count++;
    	}
    	
    	for(int j = 0; j < resBoolean.length; j++) {    	
    		if(resBoolean[j]) res.add(words1[j]);
    	}
    	return res;
    }
    public boolean compareWords(int[] tmp1, int[] combinedWords2) {
    	for(int i = 0; i < 26; i++) {
    		int strCnt = 0;
    		if((combinedWords2[i] > tmp1[i])) return false;
    	}
    	return true;
    }
    
    public static void main(String[] arg) {
    	M_WordSubsets sol = new M_WordSubsets();
    	System.out.println(sol.wordSubsets(new String[] {"amazon","apple","facebook","google","leetcode"}, new String[] {"e","o"}));
    	System.out.println(sol.wordSubsets(new String[] {"amazon","apple","facebook","google","leetcode"}, new String[] {"l","e"}));
    	System.out.println(sol.wordSubsets(new String[] {"amazon","apple","facebook","google","leetcode"}, new String[] {"lo","eo"}));
    }    
}
