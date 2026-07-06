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
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode s = head;
        ListNode prev = null;
        while(s != null){
            ListNode c = s.next;
            s.next = prev;
            prev = s;
            s = c;
        }
        return prev;
    }
}