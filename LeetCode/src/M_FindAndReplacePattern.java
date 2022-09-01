import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M_FindAndReplacePattern {
	
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
    	// correct sol
//    	int pLen = pattern.length();
//    	List<String> res = new ArrayList<String>();
//    	boolean[] resBolArray = new boolean[words.length];
//    	
//    	for(int j = 0; j < words.length; j++) {
//    		if(words[j].length() != pLen) {
//    			resBolArray[j] = true;
//    			continue;
//    		}
//        	int[] wArr = new int[128];
//        	int[] pArr = new int[128];
//        	String w = words[j];
//        	
//        	for(int i = 0; i < pLen; i++) {
//        		if(wArr[w.charAt(i)] != pArr[pattern.charAt(i)]) {
//        			resBolArray[j] = true;
//        			continue;
//        		}
//        		
//        		wArr[w.charAt(i)] = i + 1;
//        		pArr[pattern.charAt(i)] = i + 1;
//        	}
//    	}
//    	
//    	for(int k = 0; k < words.length; k++) {
//    		if(!resBolArray[k]) res.add(words[k]);
//    	}
//    	return res;
    	
    	// vasanth sol optimized
        int N = pattern.length();
        int W = words.length;
        int[] pmap = new int[26];
        int[][] wordsmap = new int[W][26];
        boolean[] result = new boolean[W];
        for (int i = 0; i < N; i++) {
            int pChar = pattern.charAt(i) - 'a';
            for (int j = 0; j < W; j++) {
                if (result[j]) {
                    continue;
                }
                if (words[j].length() != N) {
                    result[j] = true;
                    continue;
                }
                int matchChar = words[j].charAt(i) - 'a';
                if (pmap[pChar] != wordsmap[j][matchChar]) {
                    result[j] = true;
                    continue;
                }                
                wordsmap[j][matchChar] = i+1;
            }
            pmap[pChar] = i+1;
        }
        
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < W; i++) {
            if (!result[i]) {
                resultList.add(words[i]);
            }
        }
        
        return resultList;    
    }
    
    public static void main(String[] arg) {
    	M_FindAndReplacePattern sol = new M_FindAndReplacePattern();
    	System.out.println(sol.findAndReplacePattern(new String[] {"abc","deq","mee","aqq","dkd","ccc"}, "abb"));
    	System.out.println(sol.findAndReplacePattern(new String[] {"a","b","c"}, "a"));
    }
}
