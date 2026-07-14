class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lls = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        helper(0,nums , lls , ls);
        return lls;
    }
    public static void helper(int idx , int[] arr , List<List<Integer>> lls , List<Integer> ls){
        if(idx == arr.length){
            lls.add(new ArrayList<>(ls));
            return;
        }
        ls.add(arr[idx]);
        helper(idx+1 , arr , lls ,ls);
        ls.remove(ls.size()-1);
        helper(idx+1 , arr , lls , ls);
    }
}