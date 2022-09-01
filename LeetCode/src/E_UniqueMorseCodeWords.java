import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class E_UniqueMorseCodeWords {
	
    public int uniqueMorseRepresentations(String[] words) {
    	
    	// correct sol using map
        /*String [] alphabetMap = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
                
        Map<String,Integer> frequency = new HashMap<String, Integer>();
        int res = 0;
        
        for(String word : words) {
        	String tmp = "";
        	for(char i : word.toCharArray()) {
        		tmp += alphabetMap[i - 'a'];
        	}        	
        	frequency.put(tmp, frequency.getOrDefault(tmp, 0)+1);        	
        }

        return frequency.size(); */
    	
    	// copied from online using HashSet
        String[] MORSE = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-",
                "...-",".--","-..-","-.--","--.."};
        
        StringBuilder code = new StringBuilder();
		Set<String> seen = new HashSet<String>();
		for (String word: words) {
		  code.setLength(0);
		   for (char c: word.toCharArray())
		       code.append(MORSE[c - 'a']);
		   seen.add(code.toString());
		}
		
		return seen.size();
    }
    public static void main(String[] arg) {
    	E_UniqueMorseCodeWords sol = new E_UniqueMorseCodeWords();
    	System.out.println(sol.uniqueMorseRepresentations(new String[] {"gin","zen","gig","msg"}));
    	System.out.println(sol.uniqueMorseRepresentations(new String[] {"a"}));
    	System.out.println(sol.uniqueMorseRepresentations(new String[] {"rwjje","aittjje","auyyn","lqtktn","lmjwn"}));
    }
}
