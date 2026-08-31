class Solution {
    public int countBattleships(char[][] arr) {
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j] == 'X'){
                    ans++;
                    dfs(i,j,arr);
                }
            }
        }
        return ans;
    }
    public static void dfs(int i , int j , char[][] arr){
        arr[i][j] = '.';
        if( i+1 < arr.length && arr[i+1][j] == 'X'){
            dfs(i+1 , j , arr);
        }
        if( i-1 >= 0 && arr[i-1][j] == 'X'){
            dfs( i-1 , j , arr);
        }
        if( j+1 < arr[0].length && arr[i][j+1] == 'X'){
            dfs(i , j+1 , arr);
        }
        if( j-1 >= 0 && arr[i][j-1] == 'X'){
            dfs(i , j-1 , arr);
        }
    }
}