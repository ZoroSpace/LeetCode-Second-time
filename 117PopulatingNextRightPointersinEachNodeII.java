/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null || (root.left == null && root.right == null)) return;
        TreeLinkNode l1,r1;
        if(root.left != null && root.right != null) {
            root.left.next = root.right;
        }
        if(root.right != null) l1 = root.right;
        else l1 = root.left;
        TreeLinkNode nextNode = root.next;
        while(nextNode != null) {
            if(nextNode.left == null && nextNode.right == null) nextNode = nextNode.next;
            else {
                if(nextNode.left != null) r1 = nextNode.left;
                else r1 = nextNode.right;
                l1.next = r1;
                break;
            }
        }
        connect(root.right);
        connect(root.left);
        
    }
}
