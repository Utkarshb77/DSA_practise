class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        List<List<Integer>> ls = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        for(int i : nums) hs.add(i);
        for(int i = lower ; i <= upper ; i++){
            if(!hs.contains(i)){
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                while(!hs.contains(i) && i<= upper) i++;
                temp.add(i-1);
                ls.add(temp);
            }
        }
        return ls;
    }
}