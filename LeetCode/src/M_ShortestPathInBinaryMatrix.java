import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class M_ShortestPathInBinaryMatrix {
	
	public int shortestPathBinaryMatrix(int[][] grid) {
		int row_len = grid.length;
		int col_len = grid[0].length;
        int pathLength = 0;
        
        if ((grid[0][0] == 1) || (grid[row_len - 1][col_len - 1] == 1)) {
        	return -1;
        }
        grid[0][0] = 1;        
        
        LinkedList<ArrayList<Integer>> queue = new LinkedList<ArrayList<Integer>>();
        //Queue<int[]> queue = new LinkedList<>();
        queue.add(new ArrayList<>(Arrays.asList(0, 0, 1)));
        int[][] direction = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};     
        
        while(!queue.isEmpty()) {
        	int x = queue.get(0).get(0);
        	int y = queue.get(0).get(1);
        	pathLength = queue.get(0).get(2);
        	queue.pop();

        	for(int[] i : direction) {
	        	int new_x = i[0] + x;
	        	int new_y = i[1] + y;	
	        	if (new_x == grid.length && new_y == grid[0].length) 
	        		return pathLength;
	        	
	        	if (0 <= new_x && new_x < row_len && 0 <= new_y && new_y < col_len && grid[new_x][new_y] == 0) {
	        		grid[new_x][new_y] = 1;
	        		queue.add(new ArrayList<>(Arrays.asList(new_x, new_y, pathLength + 1)));
	        	}
        	}
        }
        return -1;
    }
	public static void main(String[] arg) {
		M_ShortestPathInBinaryMatrix sol = new M_ShortestPathInBinaryMatrix();
		System.out.println(sol.shortestPathBinaryMatrix(new int[][]{{0,1},{1,0}}));
		System.out.println(sol.shortestPathBinaryMatrix(new int[][]{{0,0,0},{1,1,0},{1,1,0}}));
		System.out.println(sol.shortestPathBinaryMatrix(new int[][]{{1,0,0},{1,1,0},{1,1,0}}));
	}
}
