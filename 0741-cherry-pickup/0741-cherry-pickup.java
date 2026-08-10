class Solution {
    public int cherryPickup(int[][] grid) {
        int row1 = grid.length;
        int row2 = grid.length;
        int col1 = grid[0].length;
        int col2 = grid[0].length;
        int[][][][] dp = new int[row1][col1][row2][col2];
        for(int i=0;i<row1;i++){
            for(int j=0;j<col2;j++){
                for(int k=0;k<row2;k++){
                    for(int l=0;l<col2;l++){
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }
        int ans = help( grid , row1-1 , col1-1 , row2-1 , col2-1 ,dp);
        return Math.max(ans , 0);
    }
    public static int help( int[][] arr , int row1 , int col1 , int row2 , int col2 , int[][][][] dp ){
        if( row1 < 0 || col1 < 0 || row2 < 0 || col2 < 0 || arr[row1][col1] == -1 || arr[row2][col2] == -1){
            return Integer.MIN_VALUE;
        }
        if( row1 == 0 && row2 == 0 && col1 == 0 && col2 == 0 ){
            return arr[0][0];
        }
        if( dp[row1][col1][row2][col2] != -1){
            return dp[row1][col1][row2][col2];
        }
        int x = help(arr , row1-1 , col1 , row2-1 , col2 , dp); // both right mai gaye
        int y = help(arr , row1 , col1-1 , row2 , col2-1 , dp); // both down gaye
        int z = help(arr , row1-1 , col1 , row2 , col2-1 , dp); // path1 left path2 down
        int w = help(arr , row1 , col1-1 , row2-1 , col2 , dp); // path1 down and path2 left
        int ans = Math.max(x , Math.max(y , Math.max(z , w)));
        int contri = 0;
        if(row1 == row2 && col1 == col2){
            contri += arr[row1][col1];
        }else{
            contri = arr[row1][col1]+arr[row2][col2];
        }
        dp[row1][col1][row2][col2] = ans + contri;
        return ans + contri;
    }
}