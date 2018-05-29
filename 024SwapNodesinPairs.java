/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode start = new ListNode(0);
        ListNode pre = start;
        pre.next = head;
        ListNode first = head;
        ListNode second = head.next;
        
        while(pre != null && pre.next != null && pre.next.next != null) {
            first = pre.next;
            second = first.next;
            first.next = second.next;
            second.next = first;
            pre.next = second;
            pre = second.next;
        }
        return start.next;
    }
}
