import java.util.HashMap;
import java.util.Map;

public class E_IsomorphicStrings {
	
    public boolean isIsomorphic(String s, String t) {
    	
    	// correct ans using Map but more time taken
//    	if(s.length() != t.length()) return false;
//        Map<Character, Character> s_map = new HashMap<Character, Character>();
//        Map<Character, Character> t_map = new HashMap<Character, Character>();
//        
//        for(int i = 0; i < s.length(); i++) {
//        	if(s_map.containsKey(s.charAt(i)) && (s_map.get(s.charAt(i)) != t.charAt(i))) {
//        		return false;
//        	}
//        	if(t_map.containsKey(t.charAt(i)) && (t_map.get(t.charAt(i)) != s.charAt(i))) {
//        		return false;
//        	}
//        	s_map.put(s.charAt(i), t.charAt(i));
//        	t_map.put(t.charAt(i), s.charAt(i));
//        }
//        return true;
    	
    	if(s.length() != t.length()) return false;
    	
    	int[] sArr = new int[128];
    	int[] tArr = new int[128];
    	
    	for(int i = 0; i < s.length(); i++) {
    		if(sArr[s.charAt(i)] != tArr[t.charAt(i)]) return false;
    		
    		sArr[s.charAt(i)] = i + 1;
    		tArr[t.charAt(i)] = i + 1;
    	}
    	return true;
    }
    
    public static void main(String[] arg) {
    	E_IsomorphicStrings sol = new E_IsomorphicStrings();
    	System.out.println(sol.isIsomorphic("egg", "add"));
    	System.out.println(sol.isIsomorphic("foo", "bar"));
    	System.out.println(sol.isIsomorphic("paper", "title"));
    }
}
