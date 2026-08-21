class Solution {
    public int maxAreaOfIsland(int[][] arr) {
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j] == 1){
                    int sum = dfs(i , j , arr);
                    ans = Math.max( sum , ans );
                }
            }
        }
        return ans;
    }
    public static int dfs(int i , int j , int[][] arr){
        arr[i][j] = 0;
        int sum = 1;
        if(i-1 >= 0 && j < arr[0].length && arr[i-1][j] == 1){
            sum +=   dfs(i-1 , j , arr);
        }
        if(i+1 < arr.length && j < arr[0].length && arr[i+1][j] == 1){
            sum += dfs(i+1 , j , arr);
        }
        if(i < arr.length && j-1 >= 0 && arr[i][j-1] == 1){
            sum += dfs( i , j-1 , arr);
        }
        if(i < arr.length && j+1 < arr[0].length && arr[i][j+1] == 1){
            sum += dfs(i , j+1 , arr);
        }
        return sum;
    }
}