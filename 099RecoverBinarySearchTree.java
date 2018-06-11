/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        traverse(root);
        int t = first.val;
        first.val = second.val;
        second.val = t;
    }
    
    void traverse(TreeNode node) {
        if(node == null) return;
        traverse(node.left);
        if(first == null && pre.val > node.val) {
            first = pre;
        }
        if(first != null && pre.val > node.val) {
            second = node;
        }
        
        pre = node;
        traverse(node.right);
        
    }
    
    
}
