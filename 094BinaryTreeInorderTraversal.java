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
    private List<Integer> result;
    public List<Integer> inorderTraversal(TreeNode root) {
        result = new LinkedList<Integer>();
        helper(root);
        return result;
    }
    void helper(TreeNode root) {
        if(root == null) return;
        helper(root.left);
        result.add(root.val);
        helper(root.right);
    }
}
