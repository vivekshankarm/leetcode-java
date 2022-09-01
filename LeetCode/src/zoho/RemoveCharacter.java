package zoho;

import java.util.HashSet;

public class RemoveCharacter {
	
	public String removeChars(String string1, String string2){
		
		HashSet<Character> set = new HashSet<Character>();
		StringBuilder str = new StringBuilder();
		
		for(int i = 0; i < string2.length(); i++) {
			set.add(string2.charAt(i));
		}
		for(int j = 0; j < string1.length(); j++) {
			if(!set.contains(string1.charAt(j))) str.append(string1.charAt(j));
		}
		return str.toString();
	}
	public static void main(String[] arg) {
		RemoveCharacter sol = new RemoveCharacter();
		System.out.println(sol.removeChars("computer", "cat"));
	}
}
