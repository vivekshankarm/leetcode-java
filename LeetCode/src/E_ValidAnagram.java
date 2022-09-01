
public class E_ValidAnagram {
	
	public boolean isAnagram(String s, String t) {
		
		if(s.length() != t.length()) return false;
		
//		char[] unicode = new char[128];
		int[] alphabet = new int[26];
		
		for(char i : s.toCharArray()) {
//			int index = i; 8u
			
			int index = i - 'a';
			alphabet[index] += 1;
		}
		
		for(char i : t.toCharArray()) {
			int index = i - 'a'; 
			if(alphabet[index] == 0) return false;
			else alphabet[index] -= 1;
		}
		return true;
	}
	public static void main(String[] arg) {
		E_ValidAnagram sol = new E_ValidAnagram();
		System.out.println(sol.isAnagram("anagram", "nagaram"));
		System.out.println(sol.isAnagram("rat", "cat"));
		System.out.println(sol.isAnagram("", "a"));
		System.out.println(sol.isAnagram("d", "t"));
	}
}
