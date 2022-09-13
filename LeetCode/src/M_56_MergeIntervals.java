import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class M_56_MergeIntervals {
	
    public int[][] merge(int[][] intervals) {
    	
    	// correct created by me
    	/*if(intervals.length < 2) return intervals;
    	Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
    	
    	List<int[]> resList = new ArrayList<int[]>();
    	int[] overlap = {intervals[0][0], intervals[0][1]};
    	
    	
    	for(int i = 1; i < intervals.length; i++) {
    		if(intervals[i][1] < overlap[0]) resList.add(intervals[i]);
    		else if (intervals[i][0] > overlap[1]) {
    			resList.add(overlap);
    			overlap = intervals[i];
    		}
    		else {
    			overlap[0] = Math.min(intervals[i][0], overlap[0]);
    			overlap[1] = Math.max(intervals[i][1], overlap[1]);
    		}    		
    	}
    	resList.add(overlap);
    	return resList.toArray(new int[resList.size()][]); */
    	
    	// clean sol from online
        /*Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        
        for (int[] interval : intervals) {

            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }

            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]); */
    	
    	// from online instead of list int is used 
        List<int[]> ls = new ArrayList<>();
        if(intervals.length == 0 || intervals == null){
            return ls.toArray(new int[0][]);
        }
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i[] : intervals){
            if(i[0] <= end){
                end = Math.max(end, i[1]);
            }
            else{
                ls.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }
        ls.add(new int[]{start, end});
        return ls.toArray(new int[0][]);
    }
    
	public static void main(String[] arg) {
		M_56_MergeIntervals sol = new M_56_MergeIntervals();
		System.out.println(Arrays.deepToString(sol.merge(new int[][] {{1,3},{6,9},{2,5}})));
		System.out.println(Arrays.deepToString(sol.merge(new int[][] {{1,2},{3,5},{6,7},{8,10},{12,16},{4,8}})));
		System.out.println(Arrays.deepToString(sol.merge(new int[][] {{1,3},{2,6},{8,10},{15,18}})));
		System.out.println(Arrays.deepToString(sol.merge(new int[][] {{1,5},{2,7}})));
		System.out.println(Arrays.deepToString(sol.merge(new int[][] {{1,2},{6,7},{8,9}})));  // edge case
		System.out.println(Arrays.deepToString(sol.merge(new int[][] {{1,2},{6,7},{4,5}})));	// edge case
		System.out.println(Arrays.deepToString(sol.merge(new int[][] {{1,4},{4,5}})));
	}
}
