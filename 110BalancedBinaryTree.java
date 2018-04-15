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
    public boolean isBalanced(TreeNode root) {
        getHeight(root);
        return helper(root);
    }
    
    int getHeight(TreeNode nodeX) {
        if(nodeX == null) return 0;
        else nodeX.val = Math.max(getHeight(nodeX.left),getHeight(nodeX.right)) + 1;
        return nodeX.val;
    }
    
    boolean helper(TreeNode nodeX) {
        if(nodeX == null) return true;
        if(nodeX.left == null || nodeX.right == null) return nodeX.val <= 2;
        return Math.abs(nodeX.left.val - nodeX.right.val) <= 1 && helper(nodeX.left) && helper(nodeX.right);
    }
}
