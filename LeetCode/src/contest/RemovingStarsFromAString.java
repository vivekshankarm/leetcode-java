package contest;

public class RemovingStarsFromAString {
	
	public String removeStars(String s) {
		
		StringBuilder res = new StringBuilder();
		
		for(char i : s.toCharArray()) {
			if(i == '*' && res.length() != 0) 
				res.delete(res.length() -1, res.length());
			else if (i != '*')
				res.append(i);
		}
		return res.toString();
	}
	public static void main(String[] arg) {
		RemovingStarsFromAString sol = new RemovingStarsFromAString();
		System.out.println(sol.removeStars("leet**cod*e"));
		System.out.println(sol.removeStars("erase*****"));
		System.out.println(sol.removeStars("*leet"));
		System.out.println(sol.removeStars("*l**eet**"));
		System.out.println(sol.removeStars("*leet"));
		System.out.println(sol.removeStars("le**"));
	}
}
