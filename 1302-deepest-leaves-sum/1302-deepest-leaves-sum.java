/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// BFS
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        return bfs(root);
    }
    public static int bfs(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> lls = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> ls = new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode r = q.poll();
                ls.add(r.val);
                if(r.left != null) q.add(r.left);
                if(r.right != null) q.add(r.right);
            }
            lls.add(ls);
        }
        int ans = 0;
        List<Integer> ls = lls.get(lls.size()-1);
        for(int i:ls) ans+= i;
        return ans;
    }
}