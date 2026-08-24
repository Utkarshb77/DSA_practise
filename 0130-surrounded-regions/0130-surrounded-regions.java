class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean [][] visited = new boolean[m][n];
                // Top and bottom rows
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(0, j, board, visited);
            }

            if (board[m - 1][j] == 'O') {
                dfs(m - 1, j, board, visited);
            }
        }

        // Left and right columns
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0, board, visited);
            }

            if (board[i][n - 1] == 'O') {
                dfs(i, n - 1, board, visited);
            }
        }

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(board[i][j] == 'O' && !visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
        
        
    }
    public void dfs(int row, int col, char[][] board, boolean [][] visited){
        visited[row][col] = true;
        int m = board.length;
        int n = board[0].length;
        int [] drow = {0,0,1,-1};
        int [] dcol = {1,-1,0,0};
        for(int i = 0; i<4; i++){
            int nrow = row+drow[i];
            int ncol = col+dcol[i];
            
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && board[nrow][ncol] == 'O'){
                if(!visited[nrow][ncol])
                dfs(nrow,ncol,board,visited);
            }

        }
    }
}