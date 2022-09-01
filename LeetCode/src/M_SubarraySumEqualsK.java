
public class M_SubarraySumEqualsK {
	public int subarraySum(int[] nums, int k) {
		// Brute force method, timelimit exceeded
	/*	int count = 0;
		int m = nums.length;
		
		for(int i = 0; i < m; i++) {
			for(int j = i; j < m; j++) {
				int sum = 0;
				for(int l = i; l < j+1; l++) {
					sum += nums[l];
				}
				if(sum == k) count += 1;
			}
		}
		return count; */
		
		// correct using presum but timelimit exceed
		int count = 0;
		int m = nums.length + 1;
		int [] arr = new int [m];
		
		if(nums.length == 1) return (nums[0] == k) ? 1 : 0;
		arr[1] = nums[0]; 					// inserting zero at begining to cover corner case
		for(int i = 1; i < m -1; i++) {
			arr[i + 1] = arr[i] + nums[i];  
		}		
		
		for(int i = 0; i < m; i++) {
			for(int j = i + 1; j < m; j++) {
				if(arr[j] - arr[i] == k) count += 1;
			}
		}
		return count;
	}
	public static void main(String[] arg) {
		M_SubarraySumEqualsK sol = new M_SubarraySumEqualsK();
		System.out.println(sol.subarraySum(new int [] {1,2,3}, 3));	//2
		System.out.println(sol.subarraySum(new int [] {1,1,1}, 2));	//2
		System.out.println(sol.subarraySum(new int [] {1,-1,0}, 0));//3
		System.out.println(sol.subarraySum(new int [] {1}, 0));		//0
		System.out.println(sol.subarraySum(new int [] {-1,-1,1}, 0));//1
		System.out.println(sol.subarraySum(new int [] {0,0}, 0));	//3
	}
}
