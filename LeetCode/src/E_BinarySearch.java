
public class E_BinarySearch {
	
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		
		while(left <= right) {
			int mid = (left + right)/2;
			if(nums[mid] == target) {
				return mid;
			}
			else if(nums[mid] < target)
				left = mid + 1;
			else
				right = mid - 1;
		}
		return -1;
	}
	
	public static void main(String[] arg) {
		E_BinarySearch sol = new E_BinarySearch();
		System.out.println(sol.search(new int[] {-1,0,3,5,9,12}, 9));
		System.out.println(sol.search(new int[] {-1,0,3,5,9,12}, 2));
		System.out.println(sol.search(new int[] {1,2,3,4,5}, 2));
		System.out.println(sol.search(new int[] {1,2,3,4}, 2));
		System.out.println(sol.search(new int[] {1,2,3,4,5,6}, 6));
		System.out.println(sol.search(new int[] {1,2,3,4,5,6}, 1));
		System.out.println(sol.search(new int[] {-1,0,3,5,9,12}, 13)); // failed index out of range
	}
}
