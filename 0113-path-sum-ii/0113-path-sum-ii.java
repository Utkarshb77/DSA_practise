class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> lls = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        dfs( root , lls , 0 , targetSum , ls);
        return lls;
    } 
    public static void dfs( TreeNode root , List<List<Integer>> lls , int sum , int tar , List<Integer> ls){
        if( root == null) return;
        sum += root.val;
        ls.add(root.val);
        if(root.left == null && root.right == null && sum == tar){
            lls.add(new ArrayList<>(ls));
        }
        dfs(root.left , lls , sum , tar , ls);
        dfs(root.right , lls , sum , tar , ls);
        ls.remove(ls.size()-1);
    }
}