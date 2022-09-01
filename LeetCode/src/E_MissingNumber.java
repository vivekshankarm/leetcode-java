import java.util.Arrays;

public class E_MissingNumber {
	
	public int missingNumber(int[] nums) {
		
		if(nums.length == 1) {
			return (nums[0] == 0) ? 1 : 0;
		}
		
		int[] count = new int[nums.length + 1];
		//Arrays.fill(count, -1);
		
		for(int i : nums) {
			count[i] = i;
		}
		
		for(int j = 1; j < count.length; j++) {
			if(count[j] == 0) {
				return j;
			}
		}
		return 0;
	}
	public static void main(String[] arg) {
		E_MissingNumber sol = new E_MissingNumber();
		System.out.println(sol.missingNumber(new int[] {3,0,1}));
		System.out.println(sol.missingNumber(new int[] {0}));
		System.out.println(sol.missingNumber(new int[] {0,1}));
		System.out.println(sol.missingNumber(new int[] {9,6,4,2,3,5,7,0,1}));
	}
}
