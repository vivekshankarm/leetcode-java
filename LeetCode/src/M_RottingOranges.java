import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class M_RottingOranges {
	
	public int orangesRotting(int[][] grid) {
		
		int m = grid.length;
		int n = grid[0].length;
		int timelapse = 0;
		Queue<ArrayList<Integer>> queue = new LinkedList<ArrayList<Integer>>();  
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j] == 2) {
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.add(0);
					tmp.add(i);
					tmp.add(j);
					queue.add(tmp);
				}
			}
		}
		while(!queue.isEmpty()) {
			ArrayList<Integer> queueIndex = queue.poll();
			timelapse = queueIndex.get(0);
			int row = queueIndex.get(1);
			int col = queueIndex.get(2);
			
			if (row > 0) {
				if(grid[row - 1][col] == 1) {
					grid[row - 1][col] = 2;
					queue.add(new ArrayList<Integer>(Arrays.asList(timelapse + 1,row - 1,col)));
				}
			}
			if (row + 1 != m) {
				if(grid[row + 1][col] == 1) {
					grid[row + 1][col] = 2;
					queue.add(new ArrayList<Integer>(Arrays.asList(timelapse + 1,row + 1,col)));
				}
			}
			if (col > 0) {
				if(grid[row][col -1] == 1) {
					grid[row][col- 1] = 2;
					queue.add(new ArrayList<Integer>(Arrays.asList(timelapse + 1,row,col - 1)));
				}
			}
			if (col + 1 != n) {
				if(grid[row][col + 1] == 1) {
					grid[row][col + 1] = 2;
					queue.add(new ArrayList<Integer>(Arrays.asList(timelapse + 1,row,col + 1)));
				}
			}
		}
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j] == 1) {
					return -1;				
				}
			}
		}
		return timelapse;
	}
	public static void main(String[] arg) {
		M_RottingOranges sol = new M_RottingOranges();
		System.out.println(sol.orangesRotting(new int[][] {{2,1,1},{1,1,0},{0,1,1}}));
		System.out.println(sol.orangesRotting(new int[][] {{2,1,1},{0,1,1},{1,0,1}}));
		System.out.println(sol.orangesRotting(new int[][] {{0,2}}));
	}
}
