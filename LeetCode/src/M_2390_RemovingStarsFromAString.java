
public class M_2390_RemovingStarsFromAString {
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
}
