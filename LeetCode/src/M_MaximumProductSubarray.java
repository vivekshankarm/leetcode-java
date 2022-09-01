
public class M_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        
    	int currMin = 1;
    	int currMax = 1;
    	int max = nums[0];
    	
    	for(int i : nums) {
    		if(i < 0) {
    			int tmp = currMax; 		//swapping value if i is negative so max will be min and min will be max
    			currMax = currMin;		// here we cant able to compare more than 2 values is Math.min or max
    			currMin = tmp;			// so we r swapping seperately
    		}
    		currMin = Math.min(i, i * currMin);		//subarray checking will be in this location 
    		currMax = Math.max(i, i * currMax);
    		max = Math.max(max, currMax);
    	}
    	return max;
    }
    public static void main(String[] arg) {
    	M_MaximumProductSubarray sol = new M_MaximumProductSubarray();
    	System.out.println(sol.maxProduct(new int[] {2,3,-2,4}));		//6
    	System.out.println(sol.maxProduct(new int[] {-2,0,-1}));		//0
    	System.out.println(sol.maxProduct(new int[] {-2,0,-1,5,-2}));	//10
    	System.out.println(sol.maxProduct(new int[] {3,-1,4}));			//4
    	System.out.println(sol.maxProduct(new int[] {2,-5,-2,-4,3}));	//24
    }
}
