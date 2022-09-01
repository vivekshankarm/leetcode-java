import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class M_ProductofArrayExceptSelf {	
	
    public int[] productExceptSelf(int[] nums) {
    	
        int [] res = new int[nums.length];
        int product = 1;
        
        for(int i = 0; i < nums.length; i++) {
        	res[i] = product;
        	product = product * nums[i];
        }
        product = 1;
        
        for(int j = nums.length -1; j >= 0; j --) {        	
        	res[j] *= product;
        	product = product * nums[j];
        }
        return res;
    }
    
	public static void main(String[] arg) {
		M_ProductofArrayExceptSelf sol = new M_ProductofArrayExceptSelf();
		System.out.println(Arrays.toString(sol.productExceptSelf(new int[] {1,2,3,4})));
		System.out.println(Arrays.toString(sol.productExceptSelf(new int[] {-1,1,0,-3,3})));		
	}
}
