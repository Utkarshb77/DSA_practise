class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int ans = help(n,dp);
        return ans;
    }
    public static int help( int n , int[] dp){
        if(n == 0 || n == 1) return n;
        if(dp[n] != -1) return dp[n];
        int smallest = Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            int temp = help(n - i*i , dp);
            smallest = Math.min(smallest , temp);
        }
        dp[n] = smallest+1;
        return smallest+1;
    }
}