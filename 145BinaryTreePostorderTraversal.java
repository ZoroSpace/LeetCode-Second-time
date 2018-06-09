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
        LinkedList<Integer> ans = new LinkedList<>();
        if(root == null) return ans;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(root != null) {
            stack.offerLast(root);
            ans.offerFirst(root.val);
            root = root.right;
        }
        while(stack.size() != 0) {
            root = stack.pollLast();
            if(root.left != null) {
                root = root.left;
                while(root != null) {
                    stack.offerLast(root);
                    ans.offerFirst(root.val);
                    root = root.right;
                }
            }
        }
        return ans;
    }
}
