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
    private int ans;
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        helper(root);
        return ans;
    }
    
    int helper(TreeNode root) {
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int mid = Math.max(root.val,root.val + left);
        mid = Math.max(mid,root.val+right);
        ans = Math.max(ans,mid);
        ans = Math.max(ans,root.val+left+right);
        return mid;
        
    }
}
