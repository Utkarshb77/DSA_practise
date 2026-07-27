class Solution {
    public int findCircleNum(int[][] arr) {
        boolean[] vis = new boolean[arr.length];
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            if(!vis[i]){
                vis[i] = true;
                dfs( i , vis , arr);
                ans++;
            }
        }
        return ans;
    }
    void dfs( int row , boolean[] vis , int[][] arr){
        for(int i=0;i<arr.length;i++){
            if( arr[row][i] == 1 && !vis[i]){
                vis[i] = true;
                dfs(i , vis , arr);
            }
        }
    }
}