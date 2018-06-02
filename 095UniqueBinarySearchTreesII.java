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
    public List<TreeNode> generateTrees(int n) {
        return helper(1,n);
    }
    
    List<TreeNode> helper(int left,int right) {
        List<TreeNode> ans = new LinkedList<>();
        if(left == right) {
            ans.add(new TreeNode(left));
            return ans;
        }
        for(int i = left;i <= right;i++) {
            List<TreeNode> leftTree = helper(left,i-1);
            List<TreeNode> rightTree = helper(i+1,right);
            if(leftTree.size() == 0) {
                for(TreeNode r : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.right = r;
                    ans.add(root);
                }
            } else if(rightTree.size() == 0) {
                for(TreeNode l : leftTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    ans.add(root);
                }
            } else {
                for(TreeNode l : leftTree) {
                    for(TreeNode r : rightTree) {
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        root.right = r;
                        ans.add(root);
                    }
                }
            }                
        }
        return ans;
    }
}
