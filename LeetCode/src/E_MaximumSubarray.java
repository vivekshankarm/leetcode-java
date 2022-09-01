
public class E_MaximumSubarray {
	
    public int maxSubArray(int[] nums) {
        int maxValue = nums[0];
        int currSum = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
        	currSum = Math.max(currSum + nums[i], nums[i]);
        	maxValue = Math.max(maxValue, currSum);
        }
        return maxValue;
    }
    public static void main(String[] arg) {
    	E_MaximumSubarray sol = new E_MaximumSubarray();
    	System.out.println(sol.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));	//6
    	System.out.println(sol.maxSubArray(new int[] {1}));						//1
    	System.out.println(sol.maxSubArray(new int[] {5,4,-1,7,8}));			//23
    }
}
