/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode s = list1 , f = list2;
        ListNode head = new ListNode(-1);
        ListNode ans = head;
        while(s != null && f != null){
            if(s.val <= f.val){
                ans.next = s;
                s=s.next;
                ans = ans.next;
            }
            else{
                ans.next = f;
                f = f.next;
                ans = ans.next;   
            }
        }
        if( s!= null) ans.next = s;
        if( f != null) ans.next = f;
        return head.next;
    }
}