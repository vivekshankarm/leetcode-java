import java.util.HashSet;
import java.util.Set;

public class E_ContainsDuplicate {
	
	public boolean containsDuplicate(int[] nums) {
		
		Set<Integer> x = new HashSet<Integer>();
		for(int num : nums ) {
			if(x.contains(num))
				return true;
			x.add(num);
		}
		return false;
	}
	public static void main(String[] arg) {
		E_ContainsDuplicate sol = new E_ContainsDuplicate();
		System.out.println(sol.containsDuplicate(new int[] {1,2,3,1}));
		System.out.println(sol.containsDuplicate(new int[] {1,2,3,4}));
		System.out.println(sol.containsDuplicate(new int[] {1,1,1,3,3,4,3,2,4,2}));
		System.out.println(sol.containsDuplicate(new int[] {1}));
	}
}
