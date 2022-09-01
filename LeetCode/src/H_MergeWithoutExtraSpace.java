import java.util.Arrays;

public class H_MergeWithoutExtraSpace {
	
	public void merge(int arr1[], int arr2[], int n, int m)	{
		int i = 0, j = 0;
		
		while(i < n && j < m) {
			if(arr1[i] > arr2[j]) {
				int tmp = arr1[i];
				arr1[i] = arr2[j];
				arr2[j] = tmp;				
			}			
			i++;
			for(int k = 0; k < m -1; k++) {
				if(arr2[k] > arr2[k + 1]) {
					int tmp = arr2[k];
					arr2[k] = arr2[k + 1];
					arr2[k + 1] = tmp;
				}
			}
		}
		System.out.println("arr1 " + Arrays.toString(arr1) + " arr2 " + Arrays.toString(arr2));
	}
	public static void main(String[] arg) {
		H_MergeWithoutExtraSpace sol = new H_MergeWithoutExtraSpace();
		sol.merge(new int [] {1,3,5,7},new int [] {0,2,6,8,9},4,5);
		sol.merge(new int [] {0,2,6,8,9},new int [] {1,3,5,7},5,4);
	}
}
