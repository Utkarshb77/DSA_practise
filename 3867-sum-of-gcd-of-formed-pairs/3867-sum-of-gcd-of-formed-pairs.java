class Solution {
    public long gcdSum(int[] nums) {
        long ans = 0;
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        int max = arr[0];
        for(int i=1;i<nums.length;i++){
            max = Math.max(max , nums[i]);
            arr[i] = gcd(nums[i] , max);
        }
        Arrays.sort(arr);
        int i=0;
        int j = arr.length-1;
        while(i<j){
            int add = gcd(arr[i] , arr[j]);
            ans += add;
            i++;
            j--;
        }
        return ans;
    }
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}