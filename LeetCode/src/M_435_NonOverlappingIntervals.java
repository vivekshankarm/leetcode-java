import java.util.Arrays;

public class M_435_NonOverlappingIntervals {
	
    public int eraseOverlapIntervals(int[][] intervals) {
        
        if(intervals.length < 2 || intervals == null) return 0;
        
    	Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
    	int count = 0;
    	int start = 0;
    	
    	for(int i = 1; i < intervals.length; i++) {
    		if(intervals[start][1] <= intervals[i][0]) start = i;
    		else {
    			count++;
    			if (intervals[start][1] > intervals[i][1]) start = i;
    		}
    	}
    	return count;
    }
    
	public static void main(String[] arg) {
		M_435_NonOverlappingIntervals sol = new M_435_NonOverlappingIntervals();
		System.out.println((sol.eraseOverlapIntervals(new int[][] {{1,3},{6,9},{2,5}})));
		System.out.println((sol.eraseOverlapIntervals(new int[][] {{1,2},{3,5},{6,7},{8,10},{12,16},{4,8}})));
		System.out.println((sol.eraseOverlapIntervals(new int[][] {{1,3},{2,6},{8,10},{15,18}})));
		System.out.println((sol.eraseOverlapIntervals(new int[][] {{1,5},{2,7}})));
		System.out.println((sol.eraseOverlapIntervals(new int[][] {{1,2},{6,7},{8,9}})));  // edge case
		System.out.println((sol.eraseOverlapIntervals(new int[][] {{1,2},{6,7},{4,5}})));	// edge case
		System.out.println((sol.eraseOverlapIntervals(new int[][] {{1,4},{4,5}})));
		System.out.println((sol.eraseOverlapIntervals(new int[][] {{1,4},{1,4},{1,4}})));
		System.out.println((sol.eraseOverlapIntervals(new int[][] {{1,100},{11,22},{1,11},{2,12}})));	// edge case
	}
}
