
public class M_SearchInRotatedSortedArray {
	
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int res = -1;
		
		while(left < right) {
			int mid = (left + right) / 2;
			if(nums[mid] == target)
				return mid;
			if(nums[right] < nums[mid] && nums[mid] < target) // 
				left = mid + 1;			
			else 
				right = mid;
		}
		return res;
	}
	
	public static void main(String[] arg) {
		M_SearchInRotatedSortedArray sol = new M_SearchInRotatedSortedArray();
		System.out.println(sol.search(new int[] {4,5,6,7,0,1,2},0));
		System.out.println(sol.search(new int[] {4,5,6,7,0,1,2},3));
		System.out.println(sol.search(new int[] {11,13,15,17},11));
		System.out.println(sol.search(new int[] {11,13,15,17},17));
		System.out.println(sol.search(new int[] {1},0));
	}
}
