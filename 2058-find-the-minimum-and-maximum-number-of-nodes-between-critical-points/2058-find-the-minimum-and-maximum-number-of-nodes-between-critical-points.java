class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> ls = new ArrayList<>();
        int pre = -1;
        ListNode s = head;
        int n = 1;
        while(s.next != null ){
            if( pre != -1){
                if(s.val < pre && s.val < s.next.val) ls.add(n);
                if(s.val > pre && s.val > s.next.val) ls.add(n);
            }
            pre = s.val;
            s = s.next;
            n++;
        }
        if( ls.size() < 2) return new int[]{-1,-1};
        int min = Integer.MAX_VALUE;
        for(int i=0;i<ls.size()-1;i++){
            if(ls.get(i+1) - ls.get(i) < min) min = ls.get(i+1) - ls.get(i);
        }
        int max = ls.get(ls.size()-1) - ls.get(0);
        int[] ans = {min , max};
        return ans;
    }
}