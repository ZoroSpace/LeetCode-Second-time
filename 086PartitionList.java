/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode tails = small;
        ListNode big = new ListNode(0);
        ListNode taill = big;
        while(head != null) {
            if(head.val < x) {
                tails.next = head;
                head = head.next;
                tails = tails.next;
                tails.next = null;
            } else {
                taill.next = head;
                head = head.next;
                taill = taill.next;
                taill.next = null;
            }
        }
        tails.next = big.next;
        return small.next;
    }
}
