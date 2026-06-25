// Only start counting when current number is the START of a sequence.
class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        HashSet<Integer> hs = new HashSet<>();
        boolean[] arr = new boolean[nums.length];
        for(int i=0;i<nums.length;i++) hs.add(nums[i]);
        int bada = 0;
        for(int num : hs){
            if(!hs.contains(num-1)){ // if hashset does not contains num-1 means this number is start of new sequence.
                int count=1;
                int current = num;
                while(hs.contains(current+1)){ // if hashset contains current+1 means aage or h count  karte jao.
                    current++;
                    count++;
                }
                longest = Math.max(longest , count);
            }
        }
        return longest;
    }
}


// Not sorted but min and max also gives TLE:
// class Solution {
//     public int longestConsecutive(int[] nums) {
//         int longest = 0;
//         HashSet<Integer> hs = new HashSet<>();
//         int max = Integer.MIN_VALUE;
//         int min = Integer.MAX_VALUE;
//         for(int i=0;i<nums.length;i++){
//             int a = nums[i];
//             hs.add(a);
//             if(a > max){
//                 max = a;
//             }
//             if( min > a){
//                 min = a;
//             }
//         }
//         int bada = 0;
//         for(int i=min;i<=max;i++){
//             if(hs.contains(i)){
//                 bada++;
//             }else{
//                 bada = 0;
//             }
//             longest = Math.max(longest , bada);
//         }
//         return longest;
//     }
// }