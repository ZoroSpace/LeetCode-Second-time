/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        ListNode s1 = new ListNode(0);
        s1.next = head;
        ListNode cur = head,tail = cur;
        int n = 0;
        while(cur != null) {
            n++;
            tail = cur;
            cur = cur.next;
        }
        k = k % n;
        if(k == 0) return head;
        cur = s1;
        for(int i = 0;i < n-k;i++) cur = cur.next;
        ListNode s2 = new ListNode(0);
        s2.next = cur.next;
        cur.next = null;
        tail.next = s1.next;
        return s2.next;
    }
}
