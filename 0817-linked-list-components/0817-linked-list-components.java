class Solution {
    public int numComponents(ListNode head, int[] nums) {
        int ans = 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int i : nums){
            hs.add(i);
        }
        ListNode s = head;
        while(s!=null){
            if(!hs.contains(s.val)) {
                s=s.next;
            }
            else{
                while( s != null && hs.contains(s.val)){
                    s=s.next;
                }
                ans++;
            }
        }
        return ans;
    }
}