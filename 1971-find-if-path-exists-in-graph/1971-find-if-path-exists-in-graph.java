class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> ls = Graph( n , edges);
        boolean[] vis = new boolean[n];
        return dfs(source , destination , ls , vis);
    }

    public static boolean dfs(int src , int des , List<List<Integer>> ls , boolean[] vis){
        if( src == des) return true;
        vis[src] = true;
        for(int i : ls.get(src)){
            if(!vis[i]){
                if(dfs( i , des , ls , vis )) return true; // hum if mai dfs isliye call kar rahe h kiyoki agar direct return kar dya dfs toh 1st false milte hi false return kar dega without checking further.
            }
        }
        return false;
    }
    public static List<List<Integer>> Graph(int n , int[][] arr){
        List<List<Integer>> ls  = new ArrayList<>();
        for(int i=0;i<n;i++){
            ls.add(new ArrayList<>());
        }
        for(int[] x : arr){
            ls.get(x[0]).add(x[1]);
            ls.get(x[1]).add(x[0]);
        }
        return ls;
    }
}