import java.util.*;

public class H_76_MinimumWindowSubstring {
    
    public String minWindow(String s, String t) {
        
        if(s.length() == 0 || t.length() == 0) return "";
        
        int left = 0, right = 0, formed = 0, required = 0;
        Map<Character, Integer> dicT = new HashMap<Character, Integer> ();
        Map<Character, Integer> dicS = new HashMap<Character, Integer> ();
        int[] ans = {-1,0,0};
        
        for(char tChar : t.toCharArray()) {
            dicT.put(tChar, dicT.getOrDefault(tChar, 0) + 1);
        }
        required = dicT.size();
        
        while(right < s.length()) {
            char sChar = s.charAt(right);
            dicS.put(sChar, dicS.getOrDefault(sChar, 0) + 1);
            if(dicT.containsKey(sChar) && dicT.get(sChar).intValue() == dicS.get(sChar).intValue()) {
                formed++;
            }
            while(left <= right && formed == required) {
                sChar = s.charAt(left);
                
                //System.out.println(left);
                //System.out.println(right);
                if(ans[0] == -1 || ans[0] > right - left + 1) {
                    ans[0] = right - left + 1;
                    ans[1] = right;
                    ans[2] = left;
                }
                dicS.put(sChar, dicS.get(sChar) - 1);
                if(dicT.containsKey(sChar) && dicT.get(sChar).intValue() > dicS.get(sChar).intValue()) formed--;
                left++;
            }
            right++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[2],ans[1]+1);
    }
    public static void main(String[] arg) {
        H_76_MinimumWindowSubstring sol = new H_76_MinimumWindowSubstring();
        System.out.println(sol.minWindow("ADOBECODEBANC","ABC"));  //BANC
        System.out.println(sol.minWindow("a","a"));  //a
        System.out.println(sol.minWindow("a","aa"));  //
    }
}