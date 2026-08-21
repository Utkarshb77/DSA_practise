class Solution {
    public int maximumDetonation(int[][] bombs) {
        ArrayList<ArrayList<Integer>> list = adjList(bombs);
        int idx = 0;
        int ans = 0;
        for(int i = 0; i<bombs.length; i++){
            boolean [] visited = new boolean[bombs.length];
            dfs(i,list,visited);
            int cnt = 0;
            for(boolean b : visited){
                if(b) cnt++;
            }
            ans = Math.max(ans,cnt);
        }
        return ans;   
    }
    public void dfs(int src, ArrayList<ArrayList<Integer>> list, boolean [] visited){
        visited[src] = true;
        for(int nei : list.get(src)){
            if(!visited[nei]){
                dfs(nei,list, visited);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> adjList(int[][] bombs){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i<bombs.length; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i<bombs.length; i++){
            int[] bomb = bombs[i];
            int x1 = bomb[0];
            int y1 = bomb[1];
            int r = bomb[2];
            for(int j = 0; j<bombs.length; j++){
                if(i==j ) continue;
                int[] b2 = bombs[j];
                int x2 = b2[0];
                int y2 = b2[1];
                if(inRadius(x1,y1,x2,y2,r)){
                    list.get(i).add(j);
                }
            }
        }
        return list;
    }
    public boolean inRadius(int x1, int y1, int x2, int y2 , int r){
        int x = x2-x1, y = y2-y1;
        long dist = (long)x*x + (long)y*y;
        long rSq = (long) r*r;
        return rSq>=dist;
    }
}