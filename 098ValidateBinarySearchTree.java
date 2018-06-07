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
    public boolean isValidBST(TreeNode root) {
        return helper(root,-Double.MAX_VALUE,Double.MAX_VALUE);
    }
    boolean helper(TreeNode node,double lo,double hi) {
        if(node == null) return true;
        if(node.val <= lo || node.val >= hi) return false;
        return helper(node.left,lo,node.val) && helper(node.right,node.val,hi);
    }
}
