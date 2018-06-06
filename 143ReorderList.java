/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        //拆分
        ListNode s1 = new ListNode(0);
        s1.next = head;
        ListNode slow = s1,fast = s1;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode s2 = new ListNode(0);
        s2.next = slow.next;
        slow.next = null;
        //逆转
        ListNode s3 = new ListNode(0);
        ListNode tail = s3;
        while(s2.next != null) {
            ListNode cur = s2.next;
            s2.next = cur.next;
            cur.next = s3.next;
            s3.next = cur;
        }
        //交叉
        tail = s2;
        while(s1.next != null) {
            ListNode cur = s1.next;
            s1.next = cur.next;
            cur.next = null;
            tail.next = cur;
            tail = tail.next;
            cur = s3.next;
            if(cur == null) return;
            s3.next = cur.next;
            cur.next = null;
            tail.next = cur;
            tail = tail.next;
        }
        
    }
}
