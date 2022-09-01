package zoho;

import java.util.HashSet;
import java.util.Set;

public class UnionOfTwoArrays {
	
	public int doUnion(int a[], int n, int b[], int m)  {
		Set<Integer> res = new HashSet<Integer>();
		
		for(int val : a) 
			res.add(val);
		
		for(int val : b)
			res.add(val);
		
		return res.size();
	}
	public static void main(String[] arg) {
		UnionOfTwoArrays sol = new UnionOfTwoArrays();
		System.out.println(sol.doUnion(new int[] {1,2,3,4,5}, 5, new int[] {1,2,3}, 3));
		System.out.println(sol.doUnion(new int[] {85,25,1,32,54,6}, 6, new int[] {85,2}, 2));
		System.out.println(sol.doUnion(new int[] {}, 0, new int[] {}, 0));	
	}
}
