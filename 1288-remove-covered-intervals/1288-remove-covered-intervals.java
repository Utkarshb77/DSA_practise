class Solution {
    public int removeCoveredIntervals(int[][] arr) {
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int ans = 1;
        int a = arr[0][0];
        int b = arr[0][1];
        for(int i=0;i<arr.length;i++){
            int x = arr[i][0];
            int y = arr[i][1];
            if( a <= x && y <= b ) {
                continue;
            }
            if(a == x){
                b = Math.max(b , y);
                continue;
            }
            a = x;
            b = y;
            ans++;
        }
        return ans;
    }
}