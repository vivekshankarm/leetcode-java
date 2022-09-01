import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class H_LongestIncreasingPathInAMatrix {
	
	// recreated based on online
	public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

	public int longestIncreasingPath(int[][] matrix) {
			
		int[][] cache = new int[matrix.length][matrix[0].length];
		int max = 1;
		System.out.println("i" + "   " + "j" + "  " + "max");	
		for(int i = 0; i < matrix.length; i++) {			
			for(int j = 0; j < matrix[0].length; j++) {
				dfs(max, cache, matrix, i, j);
				System.out.println(i + "   " + j + "  " + max);		
				max = Math.max(max, cache[i][j]);
			}
		}
		return max;
	}
	
	public int dfs (int max, int[][] cache, int[][] matrix,int i,int j) {
		if(cache[i][j] != 0) {
			return cache[i][j];
		}
		int value = 1;
		for(int[] k : dirs) {
			int row = k[0] + i;
			int col = k[1] + j;
			
			if(row < 0 || row > matrix.length-1 || col < 0 || col > matrix[0].length-1 || matrix[i][j] >= matrix[row][col]) continue;
			value = 1 + dfs(max, cache, matrix,row,col);
			cache[i][j] = Math.max(cache[i][j], value);
		}
		cache[i][j] = Math.max(cache[i][j], value);
		return cache[i][j];
	}
	
	public static void main(String[] arg) {
		H_LongestIncreasingPathInAMatrix sol = new H_LongestIncreasingPathInAMatrix();
		System.out.println(sol.longestIncreasingPath(new int[][] {{9,9,4},{6,6,8},{2,1,1}}));
		System.out.println(sol.longestIncreasingPath(new int[][] {{3,4,5},{3,2,6},{2,2,1}}));
//		System.out.println(Arrays.deepToString(dirs));
//		System.out.println(Arrays.toString(dirs));
	}
}
