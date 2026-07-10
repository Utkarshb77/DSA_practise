class Solution {
    public int[] twoSum(int[] arr , int target) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int a = target - arr[i];
            if(hm.containsKey(a) && hm.get(a) != i){
                return new int[]{i , hm.get(a)};
            }
            hm.put(arr[i] , i);
        }
        return new int[]{-1,-1};
    }
}