import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class M_SetMatrixZeroes {
	
	public void setZeroes(int[][] matrix) {
			
		// correct using more space and more time
		/*int rowLen = matrix.length;
		int colLen = matrix[0].length;
		int [][] dummy = new int [rowLen][colLen];
		
		// array copying
		for(int i = 0; i < rowLen; i++) {
			for(int j = 0; j < colLen; j++) {				 
				dummy[i][j] = matrix[i][j];
			}
		}
		
		for(int i = 0; i < rowLen; i++) {
			for(int j = 0; j < colLen; j++) {
				if(dummy[i][j] == 0) 
					helper(matrix,dummy,i,j);
			}
		}
		System.out.println(Arrays.deepToString(matrix));
	}
	public void helper(int[][] matrix, int[][] dummy,int i,int j) {
				
		for(int row = 0; row < matrix.length; row++) {
			matrix[row][j] = 0;
		}
		
		for(int col = 0; col < matrix[0].length; col++) {
			matrix[i][col] = 0;
		}				
	}*/
		// recreated based on online using hashset
		Set<Integer> rowSet = new HashSet<Integer>();
		Set<Integer> colSet = new HashSet<Integer>();
		
		int rowLen = matrix.length;
		int colLen = matrix[0].length;
		
		// traverse to find 0's and row and col
		for(int i = 0; i < rowLen; i++) {
			for(int j = 0; j < colLen; j++) {
				if(matrix[i][j] == 0) {
					rowSet.add(i);
					colSet.add(j);
				}
			}
		}
		// changing row and col to zero based on set
		for(int i = 0; i < rowLen; i++) {
			for(int j = 0; j < colLen; j++) {
				if(rowSet.contains(i) || colSet.contains(j)) {
					matrix[i][j] = 0;
				}
			}
		}
//		System.out.println(Arrays.deepToString(matrix));
	}
		
	public static void main(String[] arg) {
		M_SetMatrixZeroes sol = new M_SetMatrixZeroes();
		sol.setZeroes(new int [][] {{1,1,1},{1,0,1},{1,1,1}});
		sol.setZeroes(new int [][] {{0,1,2,0},{3,4,5,2},{1,3,1,5}});	
	}
}
