class Solution {
    long ans = Long.MAX_VALUE;
    int min;
    public int findSecondMinimumValue(TreeNode root) {
        min = root.val;
        dfs(root);
        return ans == Long.MAX_VALUE ? -1 : (int) ans;
    }
    public void dfs(TreeNode root) {
        if (root == null) return;
        if (root.val > min && root.val < ans) {
            ans = root.val;
        }
        dfs(root.left);
        dfs(root.right);
    }
}