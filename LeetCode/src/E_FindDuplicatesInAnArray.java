import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class E_FindDuplicatesInAnArray {
	
	public static ArrayList<Integer> duplicates(int arr[], int n) {
		/*
		HashMap<Integer, Integer> dic = new HashMap<Integer, Integer>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		
        for(int i : arr) {
        	dic.put(i, dic.getOrDefault(i, 0)+1);
        }
        for(Map.Entry<Integer, Integer> j : dic.entrySet()) {
        	if (j.getValue() > 1) {
        		res.add(j.getKey());
        	}
        }
        res.sort(null);
        return (res.size() > 0) ? res: new ArrayList<>(Arrays.asList(-1));
        */
		ArrayList<Integer> res = new ArrayList<Integer>();
		for(int i = 0; i < n; i++) {
			int index = arr[i]%n;
			arr[index] += n;
		}
		
		for(int j = 0; j < n; j++) {
			if (arr[j]/n >= 2) {
				res.add(j);
			}
		}
		return (res.size() > 0) ? res : new ArrayList<Integer>(Arrays.asList(-1));
    }
	public static void main(String[] arg) {
		E_FindDuplicatesInAnArray sol = new E_FindDuplicatesInAnArray();
		System.out.println(sol.duplicates(new int[]{0,3,1,2}, 4));
		System.out.println(sol.duplicates(new int[]{2,3,1,2,3}, 5));
		System.out.println(sol.duplicates(new int[]{14,7,14,6,1,11,3,16,16,8,7,4,11,15,17,6,1,13}, 18));
	}
}
