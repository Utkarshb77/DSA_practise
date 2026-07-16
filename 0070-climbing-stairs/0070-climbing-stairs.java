class Solution {
    public int climbStairs(int n) {
        if( n == 1 || n == 2) return n;
        int[] dp = new int[n+1];
        Arrays.fill(dp , -1);
        dp[0] = 0;
        dp[1] = 1;
        return climb(n , dp);
    }
    public static int climb(int n , int[] dp){
        if( n == 1 || n == 2) return n;
        if(dp[n] != -1) return dp[n];
        dp[n] = climb(n-1 , dp) + climb(n-2,dp);
        return dp[n];
    }
}