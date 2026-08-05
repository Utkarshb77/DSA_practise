// Stack Solution:

class Solution {
    public boolean canFinish(int n, int[][] arr ) {
        List<List<Integer>> ls = new ArrayList<>();
        for(int i=0;i<n;i++){
            ls.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(int i=0;i<arr.length;i++){
            int u = arr[i][0];
            int v = arr[i][1];
            ls.get(v).add(u);
            indegree[u]++; 
        }
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(indegree[i] == 0) st.push(i);
        }
        int count = dfs(indegree, ls , st);
        return count == n;
    }
    public static int dfs(int[] indegree ,  List<List<Integer>> ls , Stack<Integer> st){
        int count = 0;
        while(!st.isEmpty()){
            int rem = st.pop();
            count++;
            for(int i : ls.get(rem)){
                indegree[i]--;
                if(indegree[i] == 0) st.push(i);
            }
        }
        return count;
    }
}

// Kahn's ALGO (BFS solution)

/*
class Solution {
    public boolean canFinish(int numCourses, int[][] arr) {
        int n = numCourses;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        // build graph
        for(int i = 0; i < arr.length; i++){
            int u = arr[i][0];
            int v = arr[i][1];
            adj.get(v).add(u);   // v → u
            indegree[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        // push nodes with indegree 0
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            for(int nei : adj.get(node)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    q.add(nei);
                }
            }
        }
        return count == n;
    }
}

*/