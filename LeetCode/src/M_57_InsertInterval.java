import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M_57_InsertInterval {
	
	public int[][] insert(int[][] intervals, int[] newInterval) {
	
		// correct but not optimal
		/*if(intervals.length == 0) return new int [][] {{newInterval[0], newInterval[1]}};
		
		List<Integer []> resList = new ArrayList<Integer[]>();		
		int index = 0;
		
		for(int i = 0; i < intervals.length; i++) {
			
			if(intervals[i][0] > newInterval[0]) {
				resList.add(new Integer [] {newInterval[0], newInterval[1]});
				index = i;
				break;
			}
			else {
				resList.add(new Integer[] {intervals[i][0], intervals[i][1]});
			}			
		}
		
		if(resList.size() == intervals.length) resList.add(new Integer [] {newInterval[0], newInterval[1]});
		
		for(int j = index; j < intervals.length; j++) {
			resList.add(new Integer[] {intervals[j][0], intervals[j][1]});
		}
		int ptr = 1;
		// main logic
		while(ptr < resList.size()) {
			if(resList.get(ptr)[0] <= resList.get(ptr - 1)[1]) {
				resList.get(ptr - 1)[1] = Math.max(resList.get(ptr)[1] , resList.get(ptr - 1)[1]); 
				resList.remove(ptr);
			}
			else ptr++;
		}
		int[][] resArr = new int [resList.size()][2];
		for(int m = 0; m < resList.size(); m++) {
			resArr[m][0] = resList.get(m)[0];
			resArr[m][1] = resList.get(m)[1];
		}
		return resArr; */
		
		// try to optimize but struck
		/*if(intervals.length == 0) return new int [][] {{newInterval[0], newInterval[1]}};
		
		List<Integer []> resList = new ArrayList<Integer[]>();		
		int index = 0;
		
		for(int i = 0; i < intervals.length; i++) {
			
			if(intervals[i][0] > newInterval[0]) {
				resList.add(new Integer [] {newInterval[0], newInterval[1]});
				index = i;
				break;
			}
			else {
				resList.add(new Integer[] {intervals[i][0], intervals[i][1]});
			}			
		}
		int inpPtr = index;
		int resPtr = index;
		if(resList resList.get(index)[1] <= resList.get(index - 1)[1]) {
			resList.get(index - 1)[1] = Math.max(resList.get(index)[1] , intervals[index - 1][1]);
			resList.remove(index);
			resPtr = index - 1;
		}

		while(inpPtr < intervals.length) {
			if(intervals[inpPtr][0] <= resList.get(resPtr)[1]) {
				resList.get(resPtr)[1] = Math.max(resList.get(resPtr)[1] , intervals[inpPtr][1]);				
			}
			else {
				resList.add(new Integer[] {intervals[inpPtr][0],intervals[inpPtr][1]});
				resPtr++;
			}
			inpPtr++;
		}
		int[][] resArr = new int [resList.size()][2];
		for(int m = 0; m < resList.size(); m++) {
			resArr[m][0] = resList.get(m)[0];
			resArr[m][1] = resList.get(m)[1];
		}
		return resArr;  */
		
		// recreated based on online
		List<int[]> result = new ArrayList<>();
		
		for(int[] interval : intervals) {
			if(interval[1] < newInterval[0]) result.add(interval);
			
			else if(interval[0] > newInterval[1]) {
				result.add(newInterval);
				newInterval = interval;
			}
			else {
				newInterval[0] = Math.min(interval[0] , newInterval[0]);
				newInterval[1] = Math.max(interval[1] , newInterval[1]);
			}
		}
		result.add(newInterval);
		return result.toArray(new int[result.size()][]);
	}
	public static void main(String[] arg) {
		M_57_InsertInterval sol = new M_57_InsertInterval();
		System.out.println(Arrays.deepToString(sol.insert(new int[][] {{1,3},{6,9}},new int[] {2,5})));
		System.out.println(Arrays.deepToString(sol.insert(new int[][] {{1,2},{3,5},{6,7},{8,10},{12,16}},new int[]{4,8})));
		System.out.println(Arrays.deepToString(sol.insert(new int[][] {},new int[]{4,8})));
		System.out.println(Arrays.deepToString(sol.insert(new int[][] {{1,5}},new int[]{2,7})));
		System.out.println(Arrays.deepToString(sol.insert(new int[][] {{1,2},{6,7}},new int[]{8,9})));  // edge case
		System.out.println(Arrays.deepToString(sol.insert(new int[][] {{1,2},{6,7}},new int[]{4,5})));	// edge case
	}
}
