/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return head;
        int counter = 0;
        RandomListNode start = head;
        HashMap<RandomListNode,Integer> map1 = new HashMap<>();
        HashMap<Integer,RandomListNode> map2 = new HashMap<>();
        HashMap<Integer,RandomListNode> map3 = new HashMap<>();
        while(start != null) {
            map1.put(start,counter);
            counter++;
            start = start.next;
        }
        for(RandomListNode r : map1.keySet()) {
            map2.put(map1.get(r),r);
        }
        for(int i = 0;i < counter;i++) {
            map3.put(i,new RandomListNode(map2.get(i).label));
        }
        for(int i = 0;i < counter;i++) {
            if(i < counter - 1) map3.get(i).next = map3.get(i+1);
            map3.get(i).random = map3.get(map1.get(map2.get(i).random));
        }
        return map3.get(0);
        
        
    }
}
