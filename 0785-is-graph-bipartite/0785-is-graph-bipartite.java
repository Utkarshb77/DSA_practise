// // BFS Approach:
// class Solution {
//     public boolean isBipartite(int[][] arr) {
//         int n = arr.length;
//         int[] vis = new int[n];
//         for(int i = 0; i < n; i++){ // this loop is used because if there is a disconnected graph , this will cover them.
//             if(vis[i] == 0){ // no color assignment
//             vis[i] = 1; 
//             Queue<Integer> q = new LinkedList<>();
//             q.add(i);
//             while(q.size() > 0){
//                 int rem = q.poll();
//                 int color = vis[rem];
//                 for(int j = 0; j < arr[rem].length; j++){
//                     if(vis[arr[rem][j]] == 0){
//                         if(color == 1){
//                             vis[arr[rem][j]] = 2;
//                         } else {
//                             vis[arr[rem][j]] = 1;
//                         }
//                         q.add(arr[rem][j]);
//                     }
//                     else if(color == 1 && vis[arr[rem][j]] == 2) continue;
//                     else if(color == 2 && vis[arr[rem][j]] == 1) continue;
//                     else return false;
//                     }
//                 }
//             }
//         }
//         return true;
//     }
// }

// DFS Solution:
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        for(int i=0;i<n;i++){
            if(vis[i] == 0){
                vis[i] = 1;
                if(!dfs(i, vis, graph)) return false;
            }
        }
        return true;
    }
    public static boolean dfs( int node , int[] vis , int[][] arr){
        for(int i : arr[node]){
            if(vis[i] == 0){
                if(vis[node] == 1){
                    vis[i] = 2;
                    if( !dfs(i, vis, arr)) return false;
                }
                else{
                    vis[i] = 1;
                    if(!dfs(i, vis, arr)) return false;
                }
            }
            else if(vis[node] == vis[i]) return false;
        }
        return true;
    }
}













