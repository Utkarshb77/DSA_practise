class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] arr ) {
        List<List<Integer>> ls = graph( arr , n );
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> withk = new HashSet<>();
        boolean[] vis = new boolean[n];
        dfs(k , ls , withk , vis);
        for(int i=0;i<n;i++){
            if(vis[i] == false){
                for(int u : ls.get(i)){
                    if(withk.contains(u)) {
                        List<Integer> aaa = new ArrayList<>();
                        for(int x=0;x<n;x++) aaa.add(x);
                        return aaa;
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            if(!withk.contains(i)) ans.add(i);
        }
        return ans;
    }
    public static void dfs( int k , List<List<Integer>> ls , HashSet<Integer>  withk , boolean[] vis){
        vis[k] = true;
        withk.add(k);
        for(int i : ls.get(k)){
            if( !vis[i] ) dfs(i , ls , withk , vis);
        }
    }
    public static List<List<Integer>> graph(int[][] arr , int n){
        List<List<Integer>> ls = new ArrayList<>();
        for(int i=0;i<n;i++) ls.add(new ArrayList<>());
        for(int[] use : arr){
            int u = use[0];
            int v = use[1];
            ls.get(u).add(v);
        }
        return ls;
    }
}