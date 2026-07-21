class Solution {
    public int minSwaps(int[] nums) {
        int ones = 0;
        for(int i:nums){
            if(i == 1) ones++;
        }
        int c = 0;
        for(int i=0;i<ones;i++) if(nums[i] == 0) c++;
        int ans = c;
        int s = 1 , e = ones;
        while( s < nums.length){
            if(nums[s-1] == 0) c--;
            if(nums[e % nums.length] == 0) c++; // % wraps the e to start and the loop condition is move till s is not equals to nums.length. (indirectly humne nums double kar diya. matlab we Duplicated the array.)
            ans = Math.min(ans , c);
            s++;
            e++;
        }
        return ans;
    }
}