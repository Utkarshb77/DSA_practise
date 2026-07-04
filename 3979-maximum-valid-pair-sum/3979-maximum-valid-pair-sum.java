class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int[] max = new int[nums.length];
        max[nums.length-1] = nums[nums.length-1];
        for(int i=nums.length-2 ; i >= 0 ;i--){
            max[i] = Math.max(max[i+1], nums[i]);
        }
        int ans = 0;
        for(int i=0;i<nums.length-k;i++){
            ans = Math.max(ans, nums[i] + max[i + k]);
        }
        return ans;
    }
}