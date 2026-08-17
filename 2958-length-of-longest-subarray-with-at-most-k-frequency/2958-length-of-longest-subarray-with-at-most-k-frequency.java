class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer , Integer> hm = new HashMap<>();
        int i=0 , ans = 0 , j=0;
        while(j < nums.length){
            if(!hm.containsKey(nums[j])){
                hm.put(nums[j] , 1);
                j++;
            }
            else{
                int g = hm.get(nums[j]);
                if(g == k ){
                    if( k == 1 ) hm.remove(nums[i]);
                    else{
                        hm.put(nums[i] , hm.get(nums[i])-1);
                    }
                    i++;
                }else{
                    hm.put(nums[j] , hm.get(nums[j])+1);
                    j++;
                }
            }
            ans = Math.max( ans , j-i);
        }
        return ans;
    }
}