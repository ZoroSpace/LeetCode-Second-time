/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n) return head;
        ListNode s1 = new ListNode(0);
        ListNode s2 = new ListNode(0);
        ListNode s3 = new ListNode(0);
        s1.next = head;
        ListNode cur = s1;
        ListNode tail1 = s1,tail2 = head;
        for(int i = 0;i < m-1;i++) {
            cur = cur.next;
            if(i == m-2) {
                tail1 = cur;
                tail2 = tail1.next;
            }
        }
        s2.next = cur.next;
        cur.next = null;
        cur = s2.next;
        for(int i = 0;i < n-m;i++) {
            cur = cur.next;
        }
        s3.next = cur.next;
        cur.next = null;
        ListNode s4 = new ListNode(0);
        while(s2.next != null) {
            cur = s2.next;
            s2.next = cur.next;
            cur.next = s4.next;
            s4.next = cur;
        }
        tail1.next = s4.next;
        tail2.next = s3.next;
        return s1.next;
    }
}
