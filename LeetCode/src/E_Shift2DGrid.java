import java.util.List;

public class E_Shift2DGrid {
	
	public List<List<Integer>> shiftGrid(int[][] grid, int k) {
		int m = grid.length;
		int n = grid[0].length;
		k = k % (m*n);
		int count = 0;
		
		
		
		outerloop:
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				
				int row = (count + k)/k;
				int col =(count + k)%k;
				
				if (count == (m*n)/2) 
					break outerloop;
				
				int tmp = grid[i][j];
				grid[i][j] = grid[row][col];
				grid[row][col] = tmp;
				
			}
		}
		
		return null;
    }
}
