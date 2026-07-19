class Solution {
    int ans = 0;
    public int countDominantNodes(TreeNode root) {
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode root){
        if (root == null) return Integer.MIN_VALUE;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int mx = Math.max(root.val, Math.max(left, right));
        if(mx == root.val) ans++;
        return mx;
    }
}    