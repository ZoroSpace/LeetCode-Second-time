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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return helper(root,sum);
    }
    
    boolean helper(TreeNode nodeX,int sum) {
        if(nodeX.left == null && nodeX.right == null) {
            if(nodeX.val == sum) return true;
            else return false;
        } else if(nodeX.left == null) {
            return helper(nodeX.right,sum - nodeX.val);
        } else if(nodeX.right == null) {
            return helper(nodeX.left,sum - nodeX.val);
        } else {
            return helper(nodeX.left,sum - nodeX.val) || helper(nodeX.right,sum - nodeX.val);
        }
    }
}
