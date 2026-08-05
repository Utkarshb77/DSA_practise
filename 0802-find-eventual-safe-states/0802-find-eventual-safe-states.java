class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> rev = new ArrayList<>();
        for (int i = 0; i < n; i++) rev.add(new ArrayList<>());
        int[] outdegree = new int[n];
        for (int u = 0; u < n; u++) {
            outdegree[u] = graph[u].length;
            for (int v : graph[u]) {
                rev.get(v).add(u);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (outdegree[i] == 0) {
                q.offer(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for (int parent : rev.get(node)) { 
                outdegree[parent]--;
                if (outdegree[parent] == 0) {
                    q.offer(parent);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
// class Solution {
//     public List<Integer> eventualSafeNodes(int[][] arr) {
//         int n = arr.length;
//         boolean[] safe = new boolean[n];
//         Queue<Integer> q = new LinkedList<>();
//         for(int i = 0; i < n; i++){
//             if(arr[i].length == 0){
//                 safe[i] = true;
//             } else {
//                 q.add(i);
//             }
//         }
//         boolean changed = true;
//         while(changed){
//             changed = false;
//             int size = q.size();
//             for(int s = 0; s < size; s++){
//                 int node = q.poll();
//                 boolean flag = true;
//                 for(int nei : arr[node]){
//                     if(!safe[nei]){
//                         flag = false;
//                         break;
//                     }
//                 }
//                 if(flag){
//                     safe[node] = true;
//                     changed = true;
//                 } else {
//                     q.add(node);
//                 }
//             }
//         }
//         List<Integer> res = new ArrayList<>();
//         for(int i = 0; i < n; i++){
//             if(safe[i]) res.add(i);
//         }
//         return res;
//     }
// }