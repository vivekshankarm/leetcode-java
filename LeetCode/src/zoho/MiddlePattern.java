package zoho;

public class MiddlePattern {
	
	public void printPattern(String s)	{
		int mid = s.length() /2;
		String res = "";
		
	   for(int i = mid; i < s.length(); i++) {
		   res += s.charAt(i);
		   System.out.print(res + "$ ");
	   }
	   for(int i = 0; i < mid; i++) {
		   res += s.charAt(i);
		   System.out.print(res + "$ ");
	   }
    }
	public static void main(String[] arg) {
		MiddlePattern sol = new MiddlePattern();
		sol.printPattern("PROGRAM");
		sol.printPattern("A");
		sol.printPattern("RAT");
	}
}
