
public class E_FirstUniqueCharacterInAString {
	
	public int firstUniqChar(String s) {
		int[] frequency = new int[26];
		
		for(char i : s.toCharArray()) {
			int index = i - 'a';
			frequency[index] += 1;
		}
		for(int j = 0; j < s.length(); j++) {
			
			if(frequency[s.charAt(j) - 'a'] == 1)
				return j;
		}
		return -1;
	}
	public static void main(String[] arg) {
		E_FirstUniqueCharacterInAString sol = new E_FirstUniqueCharacterInAString();
		System.out.println(sol.firstUniqChar("leetcode"));
		System.out.println(sol.firstUniqChar("loveleetcode"));
		System.out.println(sol.firstUniqChar("aabb"));
		System.out.println(sol.firstUniqChar("a"));
		System.out.println(sol.firstUniqChar("ab"));
	}
}
