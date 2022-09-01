package zoho;

public class SumOfTwoLargeNumbers {
	
    String findSum(String X, String Y) {
    	
    	// wrong approach
    	/*String res = "";
    	int xLen = X.length();
    	int yLen = Y.length();
        int maxLen = Math.max(xLen, yLen);
        int value = 0;
        int digit = 0;
        int rem = 0, quotient =0;
        
        for(int i = maxLen - 1; i >= 0; i--) {
        	int x = Integer.parseInt((i < xLen) ? String.valueOf(X.charAt(i)) : "0");
        	int y = Integer.parseInt((i < yLen) ? String.valueOf(Y.charAt(i)) : "0");
        	
        	rem = (x + y + quotient) % 10;
        	value = (int) (value + rem*(Math.pow(10, digit)));
        	quotient = (x + y)/10;     
        	digit++;
        }
        return Integer.toString((int) (value + quotient*(Math.pow(10, digit)))); */
    	
    	if(X.length() > Y.length()) {
    		String tmp = Y;
    		Y = X;
    		X = tmp;
    	}
    	int xLen = X.length();
    	int yLen = Y.length();
    	int diff = yLen - xLen;
    	int carry = 0;
    	String combined = "";
    	
    	for(int i = xLen - 1; i >= 0; i--) {
    		int sum = X.charAt(i) - '0' + Y.charAt(i + diff) - '0' + carry ;
    		combined = (char)(sum % 10 + '0') + combined;
    		carry = sum/10;
    	}
    	
    	for(int i = diff - 1; i >= 0; i--) {
    		int sum = Y.charAt(i) - '0' + carry ;
    		combined = (char)(sum % 10 + '0') + combined;
    		carry = sum/10;
    	}
    	if(carry > 0)
    		combined = (char)(carry + '0') + combined;
    	
    	String res = "";
    	int index = combined.length() - 1;
    	for(int i = 0; i < combined.length(); i++) {
    		if(combined.charAt(i) != '0') {
    			index = i;
    			break;
    		}
    	}
    	for(int i = index; i < combined.length(); i++)
    		res += combined.charAt(i);
    	return res;    	
    }
    public static void main(String[] arg) {
    	SumOfTwoLargeNumbers sol = new SumOfTwoLargeNumbers();
    	System.out.println(sol.findSum("25", "23"));
    	System.out.println(sol.findSum("2500", "23"));
    	System.out.println(sol.findSum("0000000", "000000000"));
    	System.out.println(sol.findSum("0000010", "000000020"));
    }
}
