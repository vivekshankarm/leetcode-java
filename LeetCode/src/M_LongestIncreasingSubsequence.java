
public class M_LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		// Bruteforce approach
		int[] LIS = new int[nums.length];
		for(int l = 0; l < nums.length; l++) {
			LIS[l] = 1;
		}
		
		for(int i = nums.length-1; i >= 0; i--) {
			for(int j = i; j < nums.length; j++) {
				if(nums[i] < nums[j]) {
					LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
				}
			}
		}
		int res = 1;
		for(int k : LIS) {
			if(k > res) res = k;
		}
		return res; 
	}
	public static void main(String[] arg) {
		M_LongestIncreasingSubsequence sol = new M_LongestIncreasingSubsequence();
		System.out.println(sol.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
		System.out.println(sol.lengthOfLIS(new int[] {0,1,0,3,2,3}));
		System.out.println(sol.lengthOfLIS(new int[] {1,3,5,4,7}));
		System.out.println(sol.lengthOfLIS(new int[] {2,2,2,2,2}));
	}
}
