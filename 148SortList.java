/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//归并排序
class Solution {
    ListNode dummy = new ListNode(0);
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode first = head;
        ListNode second = head.next;
        ListNode pre;
        while(second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }
        pre = first;
        first = first.next;
        pre.next = null;
        return merge(sortList(head),sortList(first));
    }
    ListNode merge(ListNode l1,ListNode l2) {
        dummy.next = null;
        ListNode cur = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
                cur.next.next = null;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur.next.next = null;
                cur = cur.next;
            }
        }
        if(l1 != null) cur.next = l1;
        else cur.next = l2;
        return dummy.next;
    }
}
