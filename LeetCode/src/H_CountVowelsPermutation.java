import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class H_CountVowelsPermutation {
	public int countVowelPermutation(int n) {
		// correct according to me timelimit exceeded
		/*Map<Character, String[]> rule = new HashMap<Character, String[]>();
		rule.put('a', new String[] {"e"});
		rule.put('e', new String[] {"a","i"});
		rule.put('i', new String[] {"a","e","o","u"});
		rule.put('o', new String[] {"i","u"});
		rule.put('u', new String[] {"a"});
		
		int[] count = {0};		
		
		dfs(rule,count,"a",n);
		dfs(rule,count,"e",n);
		dfs(rule,count,"i",n);
		dfs(rule,count,"o",n);
		dfs(rule,count,"u",n);
		
		return count[0];
	}
	
	private void dfs(Map<Character, String[]> rule, int[] count,String word,int n) {
			
		if(n == (word.length())) {
			count[0] += 1;
			return;
		}
		for(String i : rule.get(word.charAt(word.length() - 1))) {
			dfs(rule, count, word + i,n);
		}*/
		
		int[][] matrix = new int[][] {{1,0},{1,0},{1,0},{1,0},{1,0}};
		boolean swap = true;		
		int iteration = 0;
		int res = 0;
		
		while(n - 1 > iteration) {
			iteration++;
			if(swap) {
				matrix[0][1] = matrix[1][0] + matrix[2][0] + matrix[4][0];
				matrix[1][1] = matrix[0][0] + matrix[2][0];
				matrix[2][1] = matrix[1][0] + matrix[3][0];
				matrix[3][1] = matrix[2][0];
				matrix[4][1] = matrix[2][0] + matrix[3][0];
				swap = false;
			}	
			else {
				matrix[0][0] = matrix[1][1] + matrix[2][1] + matrix[4][1];
				matrix[1][0] = matrix[0][1] + matrix[2][1];
				matrix[2][0] = matrix[1][1] + matrix[3][1];
				matrix[3][0] = matrix[2][1];
				matrix[4][0] = matrix[2][1] + matrix[3][1];
				swap = true;
			}
		}
		for(int i = 0; i < 5; i++) {
			if(swap) {
				res += matrix[i][0]; 
			}
			else res += matrix[i][1]; 
		}
		return res;
	}

	public static void main(String[] arg) {
		H_CountVowelsPermutation sol = new H_CountVowelsPermutation();
		System.out.println(sol.countVowelPermutation(1));
		System.out.println(sol.countVowelPermutation(2));
		System.out.println(sol.countVowelPermutation(5));
		System.out.println(sol.countVowelPermutation(50));
		System.out.println(sol.countVowelPermutation(100));
	}
}
