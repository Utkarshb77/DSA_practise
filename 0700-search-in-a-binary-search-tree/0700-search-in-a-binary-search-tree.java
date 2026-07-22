class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if( root == null) return null;
        if( root.val == val) return root;
        return dfs(root , val);
    }
    public static TreeNode dfs(TreeNode  root , int val){
        if( root == null) return null;
        if( root.val == val ) return root;
        if(root.val > val){
            return dfs(root.left , val);
        }
        return dfs(root.right , val);
    }
}