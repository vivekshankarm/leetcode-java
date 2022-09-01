import java.util.ArrayList;

public class M_UniquePathsII {
	
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	// struck somewhere
        /*int res = 0;
        int rowLen = obstacleGrid.length -1;
        int colLen = obstacleGrid[0].length - 1;               
        obstacleGrid[rowLen][colLen] = 1;
        
        int [] preVal = new int[rowLen+1];
        int [] curVal = new int[rowLen+1];
        
        for(int k = 0; k < rowLen + 1; k++) {
        	preVal[k] = 1;
        }
        for(int i = rowLen; i >= 0; i--) {
        	for(int j = colLen; j >= 0; j--) {
        		if(obstacleGrid[i][j])
        	}
        }
        return 0; */
    	
    	// struck somewhere didn't
		/*int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		
		if (obstacleGrid[m-1][n-1] == 1 || obstacleGrid[0][0] == 1)
			return 0;
		if (m == 1 || n == 1) {
			if (m == 1) {
				for(int k = 0; k < n; k++) {
					if (obstacleGrid[0][k] == 1) return 0;
				}
			}
			else if (n == 1) {
				for(int k = 0; k < m; k++) {
					if (obstacleGrid[k][0] == 1) return 0;
				}
			}
			return 1;
		}
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if (i == 0 && j != 0 && obstacleGrid[0][j] == 0 && obstacleGrid[0][j-1] != 1) obstacleGrid[0][j] = 2;
				if (j == 0 && i!= 0 && obstacleGrid[i][0] == 0 && obstacleGrid[i -1][0] != 1) obstacleGrid[i][0] = 2;
				
				if (i != 0 && j != 0 && obstacleGrid[i][j] != 1) {
					if(obstacleGrid[i-1][j] == 1)
						obstacleGrid[i][j] = obstacleGrid[i][j-1];
					
					else if(obstacleGrid[i][j-1] == 1)
						obstacleGrid[i][j] = obstacleGrid[i-1][j];
					
					else 
						obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
				}
			}
		}
		return obstacleGrid[m-1][n-1]/2; */
    	
    	// recreating based on online sol
    	int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		
		if (obstacleGrid[m-1][n-1] == 1 || obstacleGrid[0][0] == 1)
			return 0;
		
		obstacleGrid[0][0] = 1;
		
		for(int i = 1; i < n; i++) 
			obstacleGrid[0][i] =  (obstacleGrid[0][i] == 0 && obstacleGrid[0][i-1] == 1) ? 1 : 0;
		
		for(int i = 1; i < m; i++) 
			obstacleGrid[i][0] =  (obstacleGrid[i][0] == 0 && obstacleGrid[i-1][0] == 1) ? 1 : 0;
		
		for(int j = 1; j < m; j++) {
			for(int k = 1; k < n; k++) {
				
				if(obstacleGrid[j][k] == 0)
					obstacleGrid[j][k] = obstacleGrid[j-1][k] + obstacleGrid[j][k-1];
				
				else
					obstacleGrid[j][k] = 0;
			}
		}
		return obstacleGrid[m - 1][n -1];
    }
    public static void main(String[] arg) {
    	M_UniquePathsII sol = new M_UniquePathsII();
    	System.out.println(sol.uniquePathsWithObstacles(new int[][] {{0,0,0},{0,1,0},{0,0,0}}));
    	System.out.println(sol.uniquePathsWithObstacles(new int[][] {{1,0}}));
    	System.out.println(sol.uniquePathsWithObstacles(new int[][] {{0,1}}));
    	System.out.println(sol.uniquePathsWithObstacles(new int[][] {{1,0},{0,0}}));
    	System.out.println(sol.uniquePathsWithObstacles(new int[][] {{0,0},{1,1},{0,0}}));
    }
}
