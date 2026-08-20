class Solution {
    public int findCircleNum(int[][] arr) {
        int ans = 0;
        boolean[] vis = new boolean[arr.length];
        for(int i=0;i<arr.length;i++){
            if(!vis[i]){
                ans++;
                dfs(i , vis , arr);
            }
        }
        return ans;
    }
    public static void dfs( int i , boolean[] vis , int[][] arr){
        vis[i] = true;
        for(int j=0;j<arr[i].length;j++){
            if( i != j && arr[i][j] == 1 && !vis[j]){
                dfs(j , vis , arr);
            }
        }
    }
}