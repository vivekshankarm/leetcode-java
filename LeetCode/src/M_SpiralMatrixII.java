import java.util.Arrays;

public class M_SpiralMatrixII {
	
	public int[][] spiralMatrix(int n) {
		
		int[][] matrix = new int[n][n];
		int top = 0;
		int left = 0;
		int bottom = n - 1;
		int right = n - 1;
		int count = 1;
		while(bottom >= top && right >= left) {
			for(int i = left; i < right + 1; i++) {
				matrix[top][i] = count;
				count++;
			}
			top++;
			for(int j = top; j < bottom + 1; j++) {
				matrix[j][right] = count;
				count++;
			}
			right--;
			for(int k = right; k > left - 1; k--) {
				matrix[bottom][k] = count;
				count++;
			}
			bottom--;
			for(int l = bottom; l > top - 1; l--) {
				matrix[l][left] = count;
				count++;
			}
			left++;
		}
		
		return matrix;		
	}
	public static void main(String[] arg) {
		M_SpiralMatrixII sol = new M_SpiralMatrixII();
		System.out.println(Arrays.deepToString(sol.spiralMatrix(2)));
		System.out.println(Arrays.deepToString(sol.spiralMatrix(3)));
		System.out.println(Arrays.deepToString(sol.spiralMatrix(1)));
		System.out.println(Arrays.deepToString(sol.spiralMatrix(4)));
	}
}
