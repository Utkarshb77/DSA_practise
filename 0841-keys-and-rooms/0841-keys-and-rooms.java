class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] vis = new boolean[rooms.size()];
        vis[0] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while( !q.isEmpty() ){
            int val = q.poll();
            vis[val] = true;;
            List<Integer> ls = rooms.get(val);
            for(int i : ls){
                if(!vis[i]) q.add(i);
            }
        }
        for(int i=0;i<vis.length;i++){
            if(!vis[i]) return false;
        }
        return true;
    }
}