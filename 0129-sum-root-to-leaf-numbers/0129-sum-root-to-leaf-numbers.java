class Solution {
    int ans = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root , 0);
        return ans;        
    }
    public void dfs( TreeNode root , int sum){
        if( root == null) return;
        sum = sum * 10 + root.val;
        if(root.left == null && root.right == null){
            ans += sum;
        }
        dfs(root.left , sum);
        dfs(root.right , sum);
        sum /= 10;
    }
}