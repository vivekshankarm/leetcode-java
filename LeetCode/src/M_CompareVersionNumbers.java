import java.util.Arrays;

public class M_CompareVersionNumbers {
	
	public int compareVersion(String version1, String version2) {
		
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");	

		int maxLength = Math.max(v1.length, v2.length);
		int minLength = Math.min(v1.length, v2.length);
		
		for(int i = 0; i < maxLength; i++) {
			Integer sub1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
			Integer sub2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
			int diff = sub1 - sub2;
			
//			int compare = sub1.compareTo(sub2);
			if (diff > 0)
				return 1;
			else if(diff < 0) 	
				return 	-1;
			
		}
		return 0;
	}
	
    public static void main(String[] arg) {
    	M_CompareVersionNumbers sol = new M_CompareVersionNumbers();
    	System.out.println(sol.compareVersion("1.01","1.001"));
    	System.out.println(sol.compareVersion("1.0","1.0.0"));
    	System.out.println(sol.compareVersion("0.1","1.1"));
    	System.out.println(sol.compareVersion("1.39.0","1.4.0"));
    }
}
