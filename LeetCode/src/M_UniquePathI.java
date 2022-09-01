
public class M_UniquePathI {
	public int uniquePaths(int m, int n) {
		return uniquePathHelper(m, n);
	}
	
	// using recursion
	/*public int uniquePathHelper(int m, int n) {
		if(m == 0 || n == 0) 
			return 1;
		return uniquePathHelper(m - 1, n) + uniquePathHelper(m, n - 1);
	}*/
	
	// memorization based on online timelimit exceeded 
	/*public int uniquePathHelper(int m, int n,int[][]matrix) {

		if(m == 0 || n == 0 ) {
			return 1;
		}
		else {
			matrix[m][n] = uniquePathHelper(m-1, n, matrix) + uniquePathHelper(m, n-1, matrix);
			System.out.println("value of m & n & matrix[m][n]");
			System.out.println(m +" " + n +" " +  matrix[m][n]);
			return matrix[m][n];
		}
	}*/
	
	public int uniquePathHelper(int m, int n) {
		int[][] matrix = new int[m][n];
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if (i == 0) matrix[0][j] = 1;
				if (j == 0) matrix[i][0] = 1;
				
				if (i != 0 && j != 0) {
					matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
				}
			}
		}
		return matrix[m-1][n-1];
	}
	
	public static void main(String[] arg) {
		M_UniquePathI sol = new M_UniquePathI();
		System.out.println(sol.uniquePaths(3, 3));
		System.out.println(sol.uniquePaths(3, 4));
		System.out.println(sol.uniquePaths(2, 5));
	}
}
