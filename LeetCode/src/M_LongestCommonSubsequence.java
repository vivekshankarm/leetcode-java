import java.util.Arrays;

public class M_LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        
    	// wrongly understood the subsequence so entire approach is wrong
       /* char[] chars = text1.toCharArray();
        Arrays.sort(chars);        
        text1 = new String(chars);
        char[] chars1 = text2.toCharArray();
        Arrays.sort(chars1);
        text2 = new String(chars1);
        System.out.println(text1);
        System.out.println(text2);
        
        int res = 0;
        int ptrFirst = 0;
        int ptrSecond = 0;
        
        while(ptrFirst < text1.length() && ptrSecond < text2.length()) {
        	if (text1.charAt(ptrFirst) == text2.charAt(ptrSecond)) {
        		ptrFirst++;
        		ptrSecond++;
        		res++;
        	}
        	else if (text1.charAt(ptrFirst) < text2.charAt(ptrSecond)){
        		ptrFirst++;
        	}
        	else {
        		ptrSecond++;
        	}
        }
        return res;*/
    	
    	//another approach by me wrongly understood the subsequence 
    	/*int res = 0;
    	int ptr = 0;
    	int tmp = 0;
    	for(int i = 0; i < text1.length(); i++) {
    		ptr = tmp;
    		while (ptr <= text2.length()-1) {
    			if (text1.charAt(i) == text2.charAt(ptr)) {
    				res++;
    				ptr++;
    				tmp = ptr;
    				break;
    			}
    			else {
    				ptr++;
    			}
    		}
    	}
    	return res;*/
    	
    	return 0;
    }
    public static void main(String[] arg) {
    	M_LongestCommonSubsequence sol = new M_LongestCommonSubsequence();
    	System.out.println(sol.longestCommonSubsequence("abcde","ace"));
    	System.out.println(sol.longestCommonSubsequence("abc","abc"));
    	System.out.println(sol.longestCommonSubsequence("abc","def"));
    	System.out.println(sol.longestCommonSubsequence("ezupkr","ubmrapg"));
    	System.out.println(sol.longestCommonSubsequence("oxcpqrsvwf","shmtulqrypy"));
    }
}
