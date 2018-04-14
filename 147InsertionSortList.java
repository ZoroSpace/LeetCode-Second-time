/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode s1 = new ListNode(-1);
        ListNode s2 = new ListNode(-1);
        s1.next = head;
        while(s1.next != null) {
            ListNode cur = s1.next;
            s1.next = cur.next;
            cur.next = null;
            insert(s2,cur);
        }
        return s2.next;
    }
    
    void insert(ListNode dummy,ListNode nodeX) {
        boolean flag = false;
        ListNode pre = dummy;
        while(pre.next != null && !flag) {
            if(nodeX.val < pre.next.val) {
                nodeX.next = pre.next;
                pre.next = nodeX;
                flag = true;
            } else pre = pre.next;
        }
        if(!flag) pre.next = nodeX;
        return;
    }
}
