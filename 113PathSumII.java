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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if(root == null) return ans;
        helper(ans,root,sum,new LinkedList<Integer>());
        return ans;
    }
    
    void helper(List<List<Integer>> ans,TreeNode root,int sum,LinkedList<Integer> path) {
        if(root.left == null && root.right == null && root.val == sum) {
            path.add(root.val);
            ans.add(new LinkedList<>(path));
            path.remove(path.size()-1);
            return;
        }
        if(root.left != null) {
            path.add(root.val);
            helper(ans,root.left,sum-root.val,path);
            path.remove(path.size()-1);
        }
        if(root.right != null) {
            path.add(root.val);
            helper(ans,root.right,sum-root.val,path);
            path.remove(path.size()-1);
        }
        
    }
}
