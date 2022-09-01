import java.util.LinkedList;

public class CountSortedVowelString {
    public int countVowelStrings(int n) {
    	// Correct sol timelimit exceed
        /*LinkedList<String> createdString = new LinkedList<String>();
        char[] vowels = {'a','e','i','o','u'};
        int count = 0;
        createdString.add("a");
        createdString.add("e");
        createdString.add("i");
        createdString.add("o");
        createdString.add("u");
        
        if (n == 1) return createdString.size();        
        
        while (createdString.peek().length() != n) {
        	String remove = createdString.remove();
        	
        	for(char i : vowels) {
        		if(Character.compare(i,remove.charAt(remove.length()-1)) <= 0) {
        			createdString.add(remove + i);
        		}
        	}
        }
        count = createdString.size();
        return count; */
    	
    	// from online
        int a = 1, e = 1, i = 1, o = 1, u = 1;
        while(n > 1) {
			// add new char before prev string
            a = (a + e + i + o + u); // a, e, i, o, u -> aa, ae, ai, ao, au
            e = (e + i + o + u); // e, i, o, u -> ee, ei, eo, eu
            i = (i + o + u); // i, o, u -> ii, io, iu
            o = (o + u); // o, u -> oo, ou
            u = (u);; // u -> uu
            n--;
        }
        
        return a + e + i + o + u;
    }
	public static void main(String[] arg) {
		CountSortedVowelString sol = new CountSortedVowelString();
		System.out.println(sol.countVowelStrings(1));
		System.out.println(sol.countVowelStrings(2));
		System.out.println(sol.countVowelStrings(33));
		System.out.println(sol.countVowelStrings(3));
	}
}
