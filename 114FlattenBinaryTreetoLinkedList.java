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
    public void flatten(TreeNode root) {
        if(root == null) return;
        helper(root);
    }
    TreeNode helper(TreeNode root) {
        if(root.left ==null && root.right == null) {
            return root;
        } else if(root.left == null) {
            return helper(root.right);
        } else if(root.right == null) {
            root.right = root.left;
            root.left = null;
            return helper(root.right);
        } else {
            TreeNode tail = helper(root.left);
            tail.right = root.right;
            root.right = root.left;
            root.left = null;
            return helper(tail.right);
        }
    }
}
