// Proper topological Sort:
class Solution {
    public int[] findOrder(int n, int[][] arr) {
        List<List<Integer>> ls = new ArrayList<>();
        for(int i=0;i<n;i++){
            ls.add(new ArrayList<>());
        }
        int[] indeg = new int[n]; 
        for(int i=0;i<arr.length;i++){
            int u = arr[i][0];
            int v = arr[i][1];
            ls.get(v).add(u); 
            indeg[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if( indeg[i] == 0 ){
                q.add(i);
            } 
        }
        List<Integer> ans = new ArrayList<>();
        while(q.size() > 0){
            int rem = q.poll();
            ans.add(rem);
            for( int v : ls.get(rem)){
                indeg[v]--;
                if(indeg[v] == 0) q.add(v);
            }
        }
        if(ans.size() != n) return new int[0];
        int[] answer = new int[n];
        for(int i=0;i<n;i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}