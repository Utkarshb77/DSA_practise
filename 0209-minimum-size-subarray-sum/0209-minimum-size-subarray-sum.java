class Solution {
    public int minSubArrayLen(int tar, int[] arr) {
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for(int right = 0;right<arr.length;right++){
            sum += arr[right];
            while(sum >= tar){
                ans = Math.min(ans ,right-left+1);
                sum -= arr[left];
                left++;
            }
        }
        return (ans==Integer.MAX_VALUE) ? 0:ans;
    }
}