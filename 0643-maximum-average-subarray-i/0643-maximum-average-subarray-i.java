class Solution {
    public double findMaxAverage(int[] arr, int k) {
        int sum = 0;
        for(int i=0;i<k;i++){
            sum += arr[i];
        }
        double ans = (double) sum / k;
        for(int i=k;i<arr.length;i++){
            sum += arr[i];
            sum -= arr[i-k];
            System.out.print(sum +" ");
            ans = Math.max(ans , (double) sum / k);
        }
        return ans;
    }
}