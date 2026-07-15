class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ls = new ArrayList<>();
        List<List<Integer>> lls = new ArrayList<>();
        help(0 , nums , ls , lls);
        return lls;
    }
    static void help(int i , int[] arr , List<Integer> ls , List<List<Integer>> lls){
        if(i == arr.length){
            lls.add(new ArrayList<>(ls));
            return;
        }
        ls.add(arr[i]);
        help(i+1 , arr , ls , lls);
        ls.remove(ls.size()-1);
        while(i+1 < arr.length && arr[i] == arr[i+1]) i++;
        help(i+1 , arr , ls , lls);
    }
}