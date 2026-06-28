class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);
        long add = 0;
        int i = nums.length - 1;
        while(k>0){
            if(mul > 0){
                add += (long)nums[i] * mul;
            }else{
                add += (long)nums[i];
            }
            k--;
            i--;
            mul--;
        }
        return add;
    }
}