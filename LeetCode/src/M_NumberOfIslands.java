import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class M_NumberOfIslands {
    public int numIslands(char[][] grid) {
    	
    	// correct sol
    	/*
        int rowLen = grid.length;
        int colLen = grid[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];    
        int res = 0;
        
        for(int m = 0; m < rowLen; m++) {
        	for(int n = 0; n < colLen; n++) {        		 
    			if(grid[m][n] == '1' && !visited[m][n]) {
    				dfs(grid,visited,m,n);
    				res++; 
    			}        		   		
        	}
        }
		return res;
    }
   

	private void dfs(char[][] grid, boolean[][] visited, int m, int n) {
		
		int[] nextIndex = {0,1,0,-1,0};
		visited[m][n] = true;
		int x = m, y = n;

		for(int i = 0; i < 4; i++) {			
			m = x + nextIndex[i];
			n = y + nextIndex[i + 1];

			if(checking(m,n,grid.length,grid[0].length) && grid[m][n] == '1' && !visited[m][n])
				dfs(grid,visited,m,n);			
		}
		return;
		
	}


	private boolean checking(int m, int n,int rowLen, int colLen) {
		if(m >= 0 && m < rowLen && n >= 0 && n < colLen)
			return true;
		return false;
	} */
    	
    	// Correct sol
    	int rowLen = grid.length;
    	int colLen = grid[0].length;
    	boolean[][] visited = new boolean[rowLen][colLen];
    	int res = 0;
    	
    	for(int i = 0; i < rowLen; i++) {
    		for(int j = 0; j < colLen; j++) {
    			if(grid[i][j] == '1' && !visited[i][j]) {
    				dfs(grid,visited,i,j);
    				res++;
    			}
    		}
    	}
    	return res;
    }

    /*
	private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
		if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {
			
			if(grid[i][j] == '1' && !visited[i][j]) {
				visited[i][j] = true;
				dfs(grid, visited, i, j + 1);
				dfs(grid, visited, i + 1, j);
				dfs(grid, visited, i, j - 1);
				dfs(grid, visited, i - 1, j);
			}
		}
		return;
	} */
    
	private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
		//System.out.println("i, j is " + i + " " + j);
		if(j >= grid[0].length || i >= grid.length || j < 0 || i < 0) {
			//System.out.println("rejected");
			return;
		}
			
			if(grid[i][j] == '1' && !visited[i][j]) {				
				visited[i][j] = true;
				dfs(grid, visited, i, j + 1);
				dfs(grid, visited, i + 1, j);
				dfs(grid, visited, i, j - 1);
				dfs(grid, visited, i - 1, j);
			}
		
		return;
	}


	public static void main(String[] arg) {
    	M_NumberOfIslands sol = new M_NumberOfIslands();
    	System.out.println(sol.numIslands(new char[][] {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'}, {'0','0','0','0','0'} }));
    	System.out.println(sol.numIslands(new char[][] {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}}));
    }
}
