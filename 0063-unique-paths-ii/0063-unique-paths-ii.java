class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] dp = new int[n][m]; 
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i] , -1);
        }
        return rec( n - 1 , m - 1 , arr ,  dp);
    }
    public static int rec(int i , int j , int[][] arr , int[][] dp){
        if( i < 0 || j < 0 || arr[i][j] == 1) return 0;
        if( i == 0 && j == 0) return 1;
        if( dp[i][j] != -1) return dp[i][j];
        int x = rec( i-1 , j , arr , dp);
        int y = rec( i , j-1 , arr , dp);
        dp[i][j] = x+y;
        return x+y;
    }
}