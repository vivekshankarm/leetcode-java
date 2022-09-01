import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameOfLife {
	
    public void gameOfLife(int[][] board) {
    	int rowLength = board.length;
    	int colLength = board[0].length;
        for (int i = 0; i < rowLength; i++) {        	
        	for (int j = 0; j < colLength; j++) {
        		
        		int count = liveNeighbors(board, i, j, rowLength, colLength);
        		
        		if (board[i][j] == 1) {
	        		if (count < 2 || count > 3)
	        			board[i][j] = 3;
        		}
        		else if (count == 3)
        			board[i][j] = 2;
        		
        	}
        }
        
        for (int row = 0; row < rowLength; row++) {        	
        	for (int col = 0; col < colLength; col++) {
        		if (board[row][col] == 3)
        			board[row][col] = 0;
        		else if (board[row][col] == 2)
        			board[row][col] = 1;
        	}
        }
        
    }
    

    
    public int liveNeighbors(int[][] board, int i, int j, int rowLength, int colLength) {
    	int count = 0;
    	System.out.println("i is " + i + " j is " + j);
    	for(int m = -1; m < 2; m++) {
//    		System.out.println("new iteration of m is :" + m);
    		for(int n = -1; n < 2; n++) {
    			int mi = m + i;
    			int nj = n + j;
  			
    			
    			if (mi == i && nj == j)
    				continue;
    			else if (-1 < mi && mi < rowLength && -1 < nj && nj < colLength && board[mi][nj]%2 == 1) {
    				count += 1;
    				System.out.println("mi value is " + mi + " nj value is "+ nj);	
    				System.out.println("board[mi][nj]%2 value is: " + board[mi][nj]%2);
    				System.out.println();
//    				System.out.println(" row : "+ i + " col : " + j);
//    				System.out.println("values of row : "+ mi + " col : " + nj);
//        			System.out.print(board[mi][nj]%2 + "  ");
//    				System.out.print(count + "  ");
//    				System.out.println();
    			}
    		}
    	}
    	System.out.println("count is :" + count);
		return count;
    }
    
    // another approach
    /**public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = liveNeighbors(board, m, n, i, j);

                // In the beginning, every 2nd bit is 0;
                // So we only need to care about when will the 2nd bit become 1.
                if (board[i][j] == 1 && lives >= 2 && lives <= 3) {  
                    board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
                }
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;  // Get the 2nd state.
            }
        }
    }

    public int liveNeighbors(int[][] board, int m, int n, int i, int j) {
        int lives = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                lives += board[x][y] & 1;
            }
        }
        lives -= board[i][j] & 1;
        return lives; **/
    
    public static void main(String[] arg) {
    	GameOfLife sol = new GameOfLife();
    	int[][] x = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
    	System.out.println(Arrays.deepToString(x));
    	sol.gameOfLife(x);
    	System.out.println(Arrays.deepToString(x));
    }
}
