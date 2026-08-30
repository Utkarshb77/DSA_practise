// class Solution {
//     public int minimumDeletions(int[] nums) {
//         int maxidx = 0;
//         int minidx = 0;
//         int n = nums.length;
//         int max = nums[0];
//         int min = nums[0]; 
//         for(int i=0;i<n;i++){
//             if(max < nums[i]) {
//                 max = nums[i];
//                 maxidx = i;
//             }
//             if( min > nums[i]){
//                 min = nums[i];
//                 minidx = i;
//             }
//         }
//         int chota = Math.min(minidx , maxidx);
//         int bada = Math.max(minidx , maxidx);
//         int ans = 0;
//         if( chota == bada){
//             return Math.min(chota+1 , n-bada);
//         }
//         if( (chota + 1) < (n - bada)){
//             ans += (chota+1);
//             n -= (chota+1);
//             bada -= (chota+1);
//             if( bada+1 < (n - bada)){
//                 ans += bada+1;
//             }else{
//                 ans += (n-bada);
//             }
//         }else{
//             ans += (n-bada);
//             n -= (n-bada);
//             if( chota+1 < (n - chota)){
//                 ans += chota+1;
//             }else{
//                 ans += (n-chota);
//             }
//         }
//         return ans;
//     }
// }

class Solution {
    public int minimumDeletions(int[] nums) {
        int maxidx = 0;
        int minidx = 0;
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < n; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxidx = i;
            }
            if (min > nums[i]) {
                min = nums[i];
                minidx = i;
            }
        }
        int chota = Math.min(minidx, maxidx);
        int bada = Math.max(minidx, maxidx);
        int front = bada + 1;
        int back = n - chota;
        int both = (chota + 1) + (n - bada);
        return Math.min(front, Math.min(back, both));
    }
}