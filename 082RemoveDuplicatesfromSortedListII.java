/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode pre = new ListNode(head.val-100);
        int temp = pre.val-1;
        pre.next = head;
        ListNode next = head.next;
        ListNode s2 = new ListNode(0);
        ListNode tail = s2;
        while(head != null) {
            next = head.next;
            if(pre.val != head.val && (next == null || head.val != next.val)) {
                tail.next = head;
                tail = tail.next;
                pre.next = next;
                head.next = null;
                head = next;
            } else {
                pre = pre.next;
                head = head.next;
            }
        }
        return s2.next;
    }
}
