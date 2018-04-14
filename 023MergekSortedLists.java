/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return helper(lists,0,lists.length - 1);
    }
    
    ListNode helper(ListNode[] lists,int lo,int hi) {
        if(lo == hi) return lists[lo];
        if(hi == lo + 1) return mergeTwoLists(lists[lo],lists[hi]);
        return mergeTwoLists(helper(lists,lo,(hi-lo)/2+lo),helper(lists,(hi-lo)/2+lo+1,hi));
    }
    
    ListNode mergeTwoLists(ListNode l1,ListNode l2) {
        ListNode dummy = new ListNode(0);
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
