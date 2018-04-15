/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        ListNode third = head;
        while(first != null && first.next != null) {
            first = first.next.next;
            second = second.next;
            if(first == second) {
                while(third != second) {
                    second = second.next;
                    third = third.next;
                }
                return second;
            }
        }
        return null;
    }
}
