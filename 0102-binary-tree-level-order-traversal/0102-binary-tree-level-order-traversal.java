class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lls = new ArrayList<>();
        if(root == null) return lls;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size() > 0){
            int n = q.size();
            List<Integer> ls = new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode node = q.remove();
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
                ls.add(node.val);
            }
            lls.add(ls);
        }
        return lls;
    }
}