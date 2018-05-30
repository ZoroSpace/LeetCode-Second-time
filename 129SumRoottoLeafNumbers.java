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
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        return helper(root,0,0);
    }
    
    int helper(TreeNode root,int add,int sum) {
        
        if(root.left == null && root.right == null)  {
            sum += add*10+root.val;
            return sum;
        }
        if(root.left != null) {
            sum = helper(root.left,add*10+root.val,sum);
        }
        if(root.right != null) {
            sum = helper(root.right,add*10+root.val,sum);
        }
        return sum;
        
    }
}
