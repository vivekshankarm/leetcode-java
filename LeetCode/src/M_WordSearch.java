
public class M_WordSearch {
	
	public boolean exist(char[][] board, String word) {
		int index = 0;
		boolean[][] visited = new boolean[board.length][board[0].length]; 
		boolean[][] test = new boolean[board.length][board[0].length]; 
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(dfs(board,visited,index,word,i, j))
					return true;
				else
					visited[i][j] = false;
			}
		}
		return false;
	}
	private boolean dfs(char[][] board,boolean[][] visited, int index,String word, int row, int col) {
		visited[row][col] = true;
		if(word.charAt(index) != board[row][col])
			return false;
		if(index == word.length() - 1)
			return true;
		
		int [] position = {0,1,0,-1,0};
		
		for(int k = 0; k < 4; k++) {
			int m = row + position[k];
			int n = col + position[k + 1];
			
			if(helper(board,m,n) && !visited[m][n]) {
				if (dfs(board,visited, index + 1, word, m, n))
					return true;
				else;
					visited[m][n] = false;
			}
		}
		return false;
	}
	private boolean helper(char[][] board, int m, int n) {
		if(m < 0 || m >= board.length || n < 0 || n >= board[0].length) {
			return false;
		}
		return true;
	}
	public static void main(String[] arg) {
		M_WordSearch sol = new M_WordSearch();
		System.out.println(sol.exist(new char [][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
		System.out.println(sol.exist(new char [][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE"));
		System.out.println(sol.exist(new char [][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB"));
		System.out.println(sol.exist(new char [][] {{'a','b'}}, "ba"));
	}
}
