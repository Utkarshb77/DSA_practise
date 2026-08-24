class Solution {
    public void gameOfLife(int[][] board) {
        int[][] mat = deepCopy(board);
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i<m ; i++){
            for(int j = 0; j<n; j++){
                int liveNei = liveNeighbours(i,j,mat);
                convert(i,j,liveNei,board);
            }
        }
        
    }
    public void convert(int row, int col, int liveNei , int [][] board){
        if(board[row][col] == 1){
            if(liveNei>3){
                board[row][col] = 0;
            }else if(liveNei < 2 ){
                board[row][col] = 0;
            }

        }else{
            if(liveNei == 3){
                board[row][col] = 1;
            }
        }
    }

    public int liveNeighbours(int row , int col, int [][] board){
        int m = board.length;
        int n = board[0].length;
        int drow[] = {0,0,1,-1,-1,1,-1,1};
        int dcol[] = {1,-1,0,0,-1,-1,1,1};
        int live = 0;
        for(int i = 0; i<8; i++){
            int nrow = row+drow[i];
            int ncol = col+dcol[i];
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && board[nrow][ncol] == 1){
                live++;
            }
        }
        return live;
    }


public static int[][] deepCopy(int[][] original) {
    if (original == null) return null;

    int[][] copy = new int[original.length][];
    for (int i = 0; i < original.length; i++) {
        copy[i] = Arrays.copyOf(original[i], original[i].length);
    }
    return copy;
}

}