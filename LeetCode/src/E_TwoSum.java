import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class E_TwoSum {
	
    public int[] twoSum(int[] nums, int target) {
    	// using hash map
/*    	Map<Integer, Integer> dic = new HashMap<Integer, Integer>(); 
    	
        for(int i = 0; i < nums.length; i++) {
        	int toLook = target - nums[i];
        	
        	if(dic.containsKey(nums[i])) return new int [] {dic.get(nums[i]),i};
        	dic.put(toLook, i);
        }
        return new int[] {}; */
    	
    	// using pointers    	
    	int left = 0;
    	int right = nums.length - 1;
    	int[][] arr = new int[nums.length][2];
    	
    	for(int i = 0; i < nums.length; i++) {     // while sorting index will chance to it we are saving index
    		arr[i][0] = nums[i];
    		arr[i][1] = i;
    	}
    	Arrays.sort(arr, Comparator.comparingInt(o -> o[0])); // Sort arr in increasing order by their values.
    	while(left < right) {    		
    		int sum = arr[left][0] + arr[right][0];
    		
    		if(sum == target) {
    			return new int[] {arr[left][1], arr[right][1]};
    		} 
    		else if(sum > target){
    			right -= 1;
    		}
    		else if(sum < target) {
    			left += 1;
    		}
    	}
    	return new int[] {};
    }
    public static void main(String[] arg){
    	E_TwoSum sol = new E_TwoSum();
    	System.out.println(Arrays.toString(sol.twoSum(new int[] {2,7,11,15}, 9))); 	//0,1
    	System.out.println(Arrays.toString(sol.twoSum(new int[] {3,2,4}, 6)));		//1,2
    	System.out.println(Arrays.toString(sol.twoSum(new int[] {3,3}, 6)));		//0,1
    }
}
