import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class M_3Sum {
	public List<List<Integer>> threeSum(int[] nums) {
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for(int i = 0; i < nums.length; i++) {
			if(i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int left = i + 1;
			int right = nums.length -1;
			
			while(left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				
				if(sum > 0) right--;
				else if (sum < 0) left++;
				else {
					res.add(new ArrayList<Integer>(Arrays.asList(nums[i] , nums[left] , nums[right])));
					while(left < right && nums[left] == nums[left + 1]) {
						left++;
					}
					while(left < right && nums[right] == nums[right - 1]) {
						right--;
					}
					left++;
					right--;
				}
			}
		}
		return res;
	}
	
	public static void main(String[] arg) {
		M_3Sum sol = new M_3Sum();
		System.out.println(sol.threeSum(new int[] {-1,0,1,2,-1,-4}));
		System.out.println(sol.threeSum(new int[] {0,1,1}));
		System.out.println(sol.threeSum(new int[] {0,0,0}));
	}
}
