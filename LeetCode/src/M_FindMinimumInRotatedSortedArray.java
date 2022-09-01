

public class M_FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
		
		// correct sol using O(N)
		/*if(nums.length == 1) 
			return nums[0];
		
		for(int i = 1; i < nums.length; i++) {
			if(nums[i -1] > nums[i])
				return nums[i];
		}
		return nums[0]; */
		
		// correct ans using binary search 
		/*int left = 0;
		int right = nums.length - 1;
		int res = nums[0];
		
		while(left < right) {
			if(nums[left] < nums[right])
				return nums[left];
			int mid = (left + right) / 2;
			
			if(nums[left] <= nums[mid]) {
				left = mid + 1;
			}
			else {
				right = mid;
			}			 
		}
		return nums[left];*/
		
		// correct fast using binary search
		int left = 0;
		int right = nums.length - 1;
		int res = nums[0];
		
		while(left < right) {

			int mid = (left + right) / 2;
			
			if(nums[right] < nums[mid]) {
				left = mid + 1;
			}
			else {
				right = mid;
			}			 
		}
		return nums[right];
	}
	
	public static void main(String[] arg) {
		M_FindMinimumInRotatedSortedArray sol = new M_FindMinimumInRotatedSortedArray();
		System.out.println(sol.findMin(new int[] {3,4,5,1,2}));
		System.out.println(sol.findMin(new int[] {4,5,6,7,0,1,2}));
		System.out.println(sol.findMin(new int[] {11,13,15,17}));
		System.out.println(sol.findMin(new int[] {5}));
	}
}
