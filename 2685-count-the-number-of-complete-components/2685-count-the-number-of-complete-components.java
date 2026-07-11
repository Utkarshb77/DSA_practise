class Solution {
    int ans = 0;
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph = grap(edges , n);
        boolean[] bool = new boolean[n];
        for(int i=0;i<n;i++){
            if(bool[i] == false){
                bfs( graph , bool , i);
            }
        }
        return ans;
    }
    public static List<List<Integer>> grap(int[][] arr , int n){
        List<List<Integer>> ls = new ArrayList<>();
        for(int i=0;i<n;i++){
            ls.add(new ArrayList<>());
        }
        for(int i=0;i<arr.length;i++){
            int u = arr[i][0];
            int v = arr[i][1];
            ls.get(u).add(v);
            ls.get(v).add(u);
        }
        return ls;
    }
    public void bfs( List<List<Integer>> graph , boolean[] bool , int edge ){
        Queue<Integer> q = new LinkedList<>();
        List<Integer> component = new ArrayList<>();
        q.add(edge);
        bool[edge] = true;
        while(!q.isEmpty()){
            int e = q.poll();
            component.add(e);
            List<Integer> ls = graph.get(e);
            for(int i=0;i<ls.size();i++){
                int nei = ls.get(i);
                if(!bool[nei]){
                    bool[nei] = true;
                    q.add(nei);
                }
            }   
        }
        int size = component.size();
        for (int i : component) {
            if (graph.get(i).size() != size - 1) {
                return;
            }
        }
        ans++;
    }
}