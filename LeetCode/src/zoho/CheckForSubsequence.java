package zoho;

public class CheckForSubsequence {
	
	public boolean isSubSequence(String A, String B){
		int ptr1 = 0;
		int ptr2 = 0;
		int strAlen = A.length();
		int strBlen = B.length();
				
		while(ptr1 < strAlen && ptr2 < strBlen) {
			if(A.charAt(ptr1) == B.charAt(ptr2)) {
				ptr1++;
				ptr2++;
			}
			else ptr2++;
		}
		if(ptr1 == strAlen) return true;
		return false;
	}
	public static void main(String[] arg) {
		CheckForSubsequence sol = new CheckForSubsequence();
		System.out.println(sol.isSubSequence("AXY", "YADXCP"));
		System.out.println(sol.isSubSequence("gksrek", "geeksforgeeks"));
		System.out.println(sol.isSubSequence("A", "A"));
	}
}
