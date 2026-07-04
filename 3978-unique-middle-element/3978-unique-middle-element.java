class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int mid = nums[nums.length/2];
        int a=0;
        for(int i : nums){
            if( i == mid) a++;;
        }
        if(a == 1) return true;
        return false;
    }
}