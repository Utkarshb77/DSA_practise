class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean [][] pacific = new boolean [m][n];
        boolean [][] atlantic = new boolean [m][n];
        boolean [][] visited = new boolean[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n;j++){
                if(i ==0 || j == 0){
                    pacific[i][j] = true;
                    dfs(i,j,heights,pacific,visited);
                }
            }
        }
        visited = new boolean[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n;j++){
                if(i == m-1 || j == n-1){
                    atlantic[i][j] = true;
                    dfs(i,j,heights,atlantic,visited);
                }
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i<m; i++){
            for(int j = 0; j<n ;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    list.add(temp);
                }
            }
        }
        return list;
    }
    public void dfs(int row, int col , int [][] heights, boolean [][] ocean, boolean [][] visited){
        int m = heights.length;
        int n = heights[0].length;
        ocean[row][col] = true;
        visited[row][col] = true;
        int[] drow = {0,0,1,-1};
        int [] dcol = {1,-1,0,0};
        for(int i = 0; i<4; i++){
            int nrow = row+drow[i];
            int ncol = col+dcol[i];
            if(nrow>=0 && nrow<m && ncol>=0 && ncol< n && heights[row][col]<=heights[nrow][ncol] && !visited[nrow][ncol]){
                visited[nrow][ncol] = true;
                dfs(nrow, ncol, heights,ocean, visited);
            }
        }
    }
}