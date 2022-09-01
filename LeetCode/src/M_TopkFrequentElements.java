import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class M_TopkFrequentElements {
	
	public int[] topKFrequent(int[] nums, int k) {
		
		// correct sol using bucket - doubt in line List<Integer>[]
		/*Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
		List<Integer>[] bucket = new List[nums.length + 1];
		int[] res = new int [k];
		int count = 0;
		
		for(int num : nums) {
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0)+1);
		}
		
		for(Map.Entry<Integer, Integer> i : frequencyMap.entrySet()) {
			if(bucket[i.getValue()] == null) {
				bucket[i.getValue()] = new ArrayList<Integer>();
			}
			bucket[i.getValue()].add(i.getKey());
		}
		
		outerLoop:
		for(int i = bucket.length - 1; i > 0; i--) {
			
			if(bucket[i] != null) {
				ArrayList<Integer> tmp = (ArrayList<Integer>) bucket[i];
				for(int j = 0; j < tmp.size(); j++) {
					res[count] = tmp.get(j);
					count++;
					if(count == k) break outerLoop;
				}				
			}			
		}
		return res;	*/	
		
		// using priority queue
		Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
		int[] res = new int [k];
		
		for(int num : nums) {
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0)+1);
		}
		PriorityQueue<Integer []> pq = new PriorityQueue<>((a, b) -> b[0].compareTo(a[0]));
		
		for(Map.Entry<Integer, Integer> i : frequencyMap.entrySet()) {
			pq.add(new Integer [] {i.getValue(),i.getKey()});
		}
		for(int j = 0; j < k; j++) {
			res[j] = pq.poll()[1];
		}
		return res;
	}
	public static void main(String[] arg) {
		M_TopkFrequentElements sol = new M_TopkFrequentElements();
		System.out.println(Arrays.toString(sol.topKFrequent(new int[] {1,1,1,2,2,3}, 2)));
		System.out.println(Arrays.toString(sol.topKFrequent(new int[] {1,1,1,3,3,2,2}, 2)));
		System.out.println(Arrays.toString(sol.topKFrequent(new int[] {1}, 1)));
		System.out.println(Arrays.toString(sol.topKFrequent(new int[] {1,2}, 2)));
	}
}

