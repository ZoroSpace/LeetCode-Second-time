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
        if(head == null) return null;
        ListNode s1 = new ListNode(0);
        ListNode s2 = new ListNode(0);
        s2.next = head.next;
        s1.next = head;
        head.next = null;
        while(s2.next != null) {
            ListNode del = s2.next;
            if(s2.next.val == head.val) {
                s2.next = del.next;
                del.next = null;
            } else {
                s2.next = del.next;
                del.next = null;
                head.next = del;
                head = head.next;
            }
        }
        return s1.next;
    }
}
