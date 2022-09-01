import java.util.Arrays;

public class M_RotateImage {
	
	public void rotate(int[][] matrix) {
		
		int len = matrix.length;		
		
		for(int i = 0; i < len/2; i++) {
			int tmp = 0;
			for(int j = i; j < len - i - 1; j++) {
//				tmp = matrix[i][j];
//				matrix[i][j] = matrix[j][len - i - 1];
//				matrix[j][len - i - 1] = matrix[len - i - 1][len - j - 1];
//				matrix[len - i - 1][len - j - 1] = matrix[len - j - 1][i];
//				matrix[len - j - 1][i] = tmp;
				
				tmp = matrix[i][j];
				matrix[i][j] = matrix[len - j -1][i];
				matrix[len - j -1][i] = matrix[len - i - 1][len - j -1];
				matrix[len - i - 1][len - j -1] = matrix[j][len - i -1];
				matrix[j][len - i -1] = tmp;
			}
		}
		System.out.println(Arrays.deepToString(matrix));
	}
	
	public static void main(String[] arg) {
		M_RotateImage sol = new M_RotateImage();
		sol.rotate(new int[][] {{1,2,3},{4,5,6},{7,8,9}});
		sol.rotate(new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}});
		sol.rotate(new int[][] {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}});
		sol.rotate(new int[][] {{1}});
	}
}
