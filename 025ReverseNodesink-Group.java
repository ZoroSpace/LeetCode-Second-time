/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 1) return head;
        ListNode cur = head;
        int counter = 0;
        while(cur != null) {
            cur = cur.next;
            counter++;
        }
        ListNode s1 = new ListNode(0);
        s1.next = head;
        ListNode s2 = new ListNode(0),tail = s2;
        int total = counter/k;
        ListNode s3 = new ListNode(0);
        for(int i = 0;i < total;i++) {
            for(int j = 0;j < k;j++) {
                cur = s1.next;
                s1.next = cur.next;
                cur.next = s3.next;
                s3.next = cur;
            }
            tail.next = s3.next;
            s3.next = null;
            for(int j = 0;j < k;j++) tail = tail.next;
        }
        tail.next = s1.next;
        return s2.next;
    }
}
