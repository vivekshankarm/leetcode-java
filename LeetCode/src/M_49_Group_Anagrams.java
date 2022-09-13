import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class M_49_Group_Anagrams {
	
    public List<List<String>> groupAnagrams(String[] strs) {
    	
    	// correct sol by me but very slow
        /*if (strs.length < 2) new ArrayList<>().add(strs);
        
        int[][] freq = new int[strs.length][26];
        boolean[] visited = new boolean[strs.length];   
        List<List<String>> res = new LinkedList<List<String>>();
        
        for(int  i = 0; i < strs.length; i++) {
        	for(int j = 0; j < strs[i].length(); j++) {
        		int tmp = strs[i].charAt(j) - 'a';
        		freq[i][tmp]++;
        	}
        }        
        for(int  i = 0; i < strs.length; i++) {
        	List<String> matched = new LinkedList<String>();
        	for(int j = i + 1; j < strs.length; j++) {
        	for(int k = 0; k < 26; k++) {
        		
        			if(!visited[j]) {
	        			if(freq[i][k] != freq[j][k]) {
	        				break;
	        			}
	        			else if(k == 25) {
	        				visited[j] = true; 
	        				matched.add(strs[j]);
	        			}
        			}
        		}
        	}
        	if(!visited[i]) {
        		matched.add(strs[i]);
        		res.add(matched);
        	}
        }
        return res; */
    	
    	// correct and optimal recreated based on online
    	Map<String, List<String>> repeatedStr = new HashMap<String, List<String>>(); 
    	List<List<String>> res = new LinkedList<List<String>>();
    	
    	for(String str : strs) {
    		char[] arr = str.toCharArray();
    		Arrays.sort(arr);
    		String sortedStr = String.valueOf(arr);
    		
    		if(repeatedStr.containsKey(sortedStr)) repeatedStr.get(sortedStr).add(str);
    		else repeatedStr.put(sortedStr, new ArrayList<String>(Arrays.asList(str)));
    	}
    	for(List<String> i : repeatedStr.values()) 
    		res.add(i);
    	
    	return res;
    }
    public static void main(String[] arg) {
    	M_49_Group_Anagrams sol = new M_49_Group_Anagrams();
    	System.out.println(sol.groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
    	System.out.println(sol.groupAnagrams(new String[] {}));
    	System.out.println(sol.groupAnagrams(new String[] {"a"}));
    	
    	// doubt
//    	char[] y = strs[i].toCharArray();
//    	String x = new string(y);
//    	strs[i] = new String(Arrays.sort(strs[i].toCharArray()));
    }
}
