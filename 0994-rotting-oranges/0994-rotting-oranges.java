class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i , j , 0));
                }
            }
        }
        int ans = 0;
        while(q.size() > 0){
            Pair p = q.remove();
            int row = p.row;
            int col = p.col;
            int time = p.time;
            ans = time;
            if(row-1 >= 0 && grid[row-1][col] == 1){
                q.add(new Pair(row-1 , col , time+1));
                grid[row-1][col] = 2;
            }
            if(col-1 >= 0 && grid[row][col-1] == 1){
                q.add(new Pair(row , col-1 , time+1));
                grid[row][col-1] = 2;
            }
            if(row+1 < n && grid[row+1][col] == 1){
                q.add(new Pair(row+1 , col , time+1));
                grid[row+1][col] = 2;
            }
            if(col+1 < m && grid[row][col+1] == 1){
                q.add(new Pair(row , col+1 , time+1));
                grid[row][col+1] = 2;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }
}
public class Pair{
    int row ;
    int col;
    int time;
    Pair(int row , int col , int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

// Instead of using 4 ifs use direction array

// int[] dr = {-1, 0, 1, 0};
// int[] dc = {0, -1, 0, 1};

// while(!q.isEmpty()){
//     Pair p = q.remove();

//     for(int i = 0; i < 4; i++){
//         int nr = p.row + dr[i];
//         int nc = p.col + dc[i];

//         if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1){
//             grid[nr][nc] = 2;
//             q.add(new Pair(nr, nc, p.time + 1));
//         }
//     }

//     ans = p.time;
// }