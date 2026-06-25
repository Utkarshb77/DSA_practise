class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int targetcount = 0;
        int ans=0;
        for (int i=0;i<nums.length;i++) {
            targetcount = 0;
            for (int j=i;j<nums.length;j++) {
                if(nums[j] == target) targetcount++;
                if(targetcount > (j-i+1)/2) ans++;
            }
        }
        return ans;
    }
}
// class Solution {
//     public int countMajoritySubarrays(int[] nums, int target) {
//         int ans = 0;
//         HashMap<Integer,Integer> hm = new HashMap<>();
//         for(int i=0;i<nums.length;i++){
//             for(int j=i;j<nums.length;j++){
//                 hm.put(nums[j], hm.getOrDefault( nums[j] , 0) + 1);
//                 if( hm.getOrDefault(target , 0) > (j-i+1)/2) ans++;
//             }
//             for(int j=i;j<nums.length;j++){
//                 hm.put(nums[j], hm.get(nums[j]) - 1);
//                 if (hm.get(nums[j]) == 0) hm.remove(nums[j]);
//             }
//         }
//         return ans;
//     }
// }