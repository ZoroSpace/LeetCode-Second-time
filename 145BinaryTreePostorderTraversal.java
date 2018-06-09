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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        helper(ans,root);
        return ans;
    }
    
    void helper(List<Integer> ans,TreeNode root) {
        if(root == null) return;
        helper(ans,root.left);
        helper(ans,root.right);
        ans.add(root.val);
    }
    
    
}
