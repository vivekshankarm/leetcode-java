import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M_Next_Permutation {
	
    public void nextPermutation(int[] nums) {
    	System.out.println(Arrays.toString(nums));
    	if(nums.length == 1)
    		return;
    	if(nums.length == 2) {
    		int tmp = nums[0];
    		nums[0] = nums[1];
    		nums[1] = tmp;
    		return;
    	}
    		
    	for(int i = nums.length - 1; i > 0; i--) {
    		int nextSmallIndex = i;
    		if(nums[i - 1] < nums[i]) {
    			
    			for(int j = i; j < nums.length; j++) {
    				if(nums[j] > nums[i-1] && nums[j] < nums[i]) {
    					if(nums[nextSmallIndex] > nums[j]) {
    						nextSmallIndex = j;
    					}
    				}
    			}
        		int tmp = nums[nextSmallIndex];
        		nums[nextSmallIndex] = nums[i-1];
        		nums[i-1] = tmp;
        		Arrays.sort(nums, i, nums.length);
        		System.out.println(Arrays.toString(nums));
        		return;
    		}
    	}
    	Arrays.sort(nums);
    	System.out.println(Arrays.toString(nums));
    }

	public static void main(String[] arg) {
    	M_Next_Permutation sol = new M_Next_Permutation();
    	sol.nextPermutation(new int[] {1,2,3});
    	sol.nextPermutation(new int[] {3,2,1});
    	sol.nextPermutation(new int[] {1,1,5});
    }
}
