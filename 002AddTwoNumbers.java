/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);
        int c = 0;
        ListNode tail = start;
        while(l1 != null || l2 != null) {
            if(l1 != null) {
                c = c + l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                c = c + l2.val;
                l2 = l2.next;
            }
            tail.next = new ListNode(c % 10);
            tail = tail.next;
            c = c/10;
        }
        if(c == 1) {
            tail.next = new ListNode(1);
        }
        return start.next;
    }
}
