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
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        return helper(root,result);
    }
    
    LinkedList<Integer> helper(TreeNode root,LinkedList<Integer> result) {
        if(root == null) return result;
        result.add(root.val);
        if(root.left != null) result = helper(root.left,result);
        if(root.right != null) result = helper(root.right,result);
        return result;
    }
}
