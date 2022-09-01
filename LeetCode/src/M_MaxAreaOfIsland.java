
public class M_MaxAreaOfIsland {
	
	public static int value;
	public int maxAreaOfIsland(int[][] grid) {
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int res = 0;
		value = 0;
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == 1 && !visited[i][j]) {
					dfs(grid,visited,i,j);
					res = Math.max(res, value);
					value = 0;
				}
			}
		}
		return res;
	}
	private void dfs(int[][] grid, boolean[][] visited, int row, int col) {
	
		visited[row][col] = true;
		value++;		
		int[] index = {0,1,0,-1,0};
		
		for(int k = 0; k < 4; k++) {
			int m = row + index[k];
			int n = col + index[k + 1];
	
			if(m < 0 || m >= grid.length || n < 0 || n >= grid[0].length) 
				continue;
			if(grid[m][n] == 1 && !visited[m][n]) {
				dfs(grid,visited,m,n);	
			}			
		}
	}
	
	public static void main(String[] arg) {
		M_MaxAreaOfIsland sol = new M_MaxAreaOfIsland();
		
    	System.out.println(sol.maxAreaOfIsland(new int[][] {{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0}, {0,0,0,0,0} }));
    	System.out.println(sol.maxAreaOfIsland(new int[][] {{1,1,0,0,0},{1,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}}));
    	System.out.println(sol.maxAreaOfIsland(new int[][] {{0,0,1,0,0,0,0,1,0,0,0,0,0}, {0,0,0,0,0,0,0,1,1,1,0,0,0},
    	                                                    {0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},
    	                                                    {0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},
    	                                                    {0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}}));
    	System.out.println(sol.maxAreaOfIsland(new int[][] {{0,0,0,0,0}}));
	}
}
