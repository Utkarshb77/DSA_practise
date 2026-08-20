class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int ans = 0;
        List<List<Integer>> graph = Graph(n , edges);
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                List<Integer> comp = new ArrayList<>();
                dfs(i , graph , vis , comp);
                int size = comp.size();
                int count = 0;
                for(int j=0;j<size;j++){
                    if(graph.get(comp.get(j)).size() == size-1){
                        count++;;
                    }
                }
                if( count == size) ans++;
            }
        }
        return ans;
    }
    public static void dfs(int src , List<List<Integer>> ls , boolean[] vis , List<Integer> comp){
        List<Integer> lls = ls.get(src);
        comp.add(src);
        vis[src] = true;
        for(int i : ls.get(src)){
            if(!vis[i]){
                dfs(i , ls , vis , comp);
            }
        }
        return;
    }
    public static List<List<Integer>> Graph( int n , int[][] arr){
        List<List<Integer>> ls = new ArrayList<>();
        for(int i=0;i<n;i++){
            ls.add(new ArrayList<>());
        }
        for(int[] x : arr){
            int u = x[0];
            int v = x[1];
            ls.get(x[0]).add(x[1]);
            ls.get(x[1]).add(x[0]);
        }
        return ls;
    }
}