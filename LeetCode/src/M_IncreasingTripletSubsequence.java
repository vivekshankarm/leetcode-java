
public class M_IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
    	
    	// brute force sol timelimit exceed
    	/*if(nums.length < 3) return false;
    	int m = nums.length;
    	for(int i = 0; i < m; i++) {
    		for(int j = i + 1; j < m; j++) {
    			for(int k = j + 1; k < m; k++) {
    				if(nums[i] < nums[j] && nums[j] < nums[k] ) {
    					return true;
    				}
    			}    			
    		}
    	}
    	return false;*/
    	// optimal sol based on online
    	// start with two largest values, as soon as we find a number smaller number we update
        int first = nums[0];
        int second = Integer.MAX_VALUE;  // this value should not be zero or nums[0] then else if condition fails and go to else condition
        // to assign value during first time v will keep the maximum so condition will satisfy easliy
        
    	for(int i : nums) {
    		if(i <= first) first = i;			// update small if n is smaller than both
    		else if(i <= second) second = i;	// update big only if greater than small but smaller than big
    		else return true;					// return if you find a number bigger than both
    	}
    	return false;
    }
    public static void main(String[] arg) {
    	M_IncreasingTripletSubsequence sol = new M_IncreasingTripletSubsequence();
    	System.out.println(sol.increasingTriplet(new int [] {1,2,3,4,5}));    		//true
    	System.out.println(sol.increasingTriplet(new int [] {5,4,3,2,1}));			//false
    	System.out.println(sol.increasingTriplet(new int [] {2,1,5,0,4,6}));		//true
    	System.out.println(sol.increasingTriplet(new int [] {20,100,10,12,5,13}));	//true
    	System.out.println(sol.increasingTriplet(new int [] {1,5,0,4,1,3}));		//true
    	System.out.println(sol.increasingTriplet(new int [] {2,4,-2,-3}));			//false	
    }
}
