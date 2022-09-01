
public class H_WildcardMatching {
	
	public boolean isMatch(String s, String p) {
		
		// recreated based on online but timelimit exceeded
		/*
		 * return dfs(0,0,s,p); } 
		 * private boolean dfs(int i, int j,String s, String p) {
		 * // TODO Auto-generated method stub 
		 * if(j == p.length()) {		 
		 * return (i == s.length()) ? true : false;
		 * 
		 * }
		 * 
		 * if(i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
		 * return dfs(i+1, j+1, s, p); }
		 * 
		 * if(p.charAt(j) == '*') { return dfs(i, j+1, s, p) || (i < s.length() &&
		 * dfs(i+1, j, s, p)); } return false; 
		 */
		
		int row = s.length() + 1;
		int col = p.length() + 1;
		
		boolean [][] cache = new boolean[row][col];
		cache[0][0] = true;
		
        for(int k = 1; k < col; k++) {      // ("","*******") condition
            if(p.charAt(k - 1) != '*') break;
            cache[0][k] = true;
        }
		
		for(int i = 0; i < row - 1; i++) {
			for(int j = 0; j < col - 1; j++) {
				
				if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {					
						cache[i + 1][j + 1] = cache[i][j];
					}
				
				else if(p.charAt(j) == '*'){
					if(cache[i + 1][j] || cache[i][j + 1]) {
						cache[i + 1][j + 1] = true;
					}
				}
			}
		}
		return cache[row - 1][col - 1];
	}
	public static void main(String[] arg) {
		H_WildcardMatching sol = new H_WildcardMatching();
		System.out.println(sol.isMatch("aa", "a"));      	//false
		System.out.println(sol.isMatch("aa", "**"));		//true
		System.out.println(sol.isMatch("adceb", "*a*b"));	//true
		System.out.println(sol.isMatch("acdcb", "a*c?b"));	//false
		System.out.println(sol.isMatch("accb", "a*c?b"));	//true
		System.out.println(sol.isMatch("zacabz", "*a?b*")); //false
		System.out.println(sol.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba","a*******b")); //false
		System.out.println(sol.isMatch("","*******")); //true
		System.out.println(sol.isMatch("zacabz","*a?b*")); //false
	}
}
