import java.util.ArrayList;
import java.util.List;

public class M_SpiralMatrix {
	
	public List<Integer> spiralOrder(int[][] matrix) {
		int left = 0,top = 0;
		int right = matrix[0].length;
		int bottom = matrix.length;
		List<Integer> res = new ArrayList<Integer>();
		
		while(top < bottom || left < right) {
//			if(left < right)
			if(top < bottom)
			for(int i = left; i < right; i++) 
				res.add(matrix[top][i]);			
			top++;
//			if(top < bottom)
			if(left < right)
			for(int j = top; j < bottom; j++) 
				res.add(matrix[j][right - 1]);	
			right--;
//			if(left < right)
			if(top < bottom)
			for(int k = right - 1; k >= left; k--) 
				res.add(matrix[bottom - 1][k]);				
			bottom--;
//			if(top < bottom)
			if(left < right)
			for(int l = bottom - 1; l >= top; l--) 
				res.add(matrix[l][left]);				
			left++;
		}
		return res;
	}
	public static void main(String[] arg) {
		M_SpiralMatrix sol = new M_SpiralMatrix();
		System.out.println(sol.spiralOrder(new int[][] {{1,2,3},{4,5,6},{7,8,9}}));
		System.out.println(sol.spiralOrder(new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}}));	
		System.out.println(sol.spiralOrder(new int[][] {{1}}));
	}
}
