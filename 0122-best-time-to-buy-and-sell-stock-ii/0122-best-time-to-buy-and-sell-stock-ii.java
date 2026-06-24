class Solution {
    public int maxProfit(int[] arr) {
        if( arr.length == 1) return 0;
        int ans = 0;
        int buy = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i] < buy){
                buy = arr[i];
            }else{
                ans += arr[i]-buy;
                buy = arr[i];
            }
        }
        return ans;
    }
}