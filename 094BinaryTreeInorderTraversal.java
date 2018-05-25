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
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        List<Integer> result = new LinkedList<>();
        if(root == null) return result;
        stack.offerLast(root);
        while(root != null && root.left != null) {
            root = root.left;
            stack.offerLast(root);
        }
        while(stack.size() != 0) {
            result.add(stack.peekLast().val);
            root = stack.pollLast();
            if(root != null && root.right != null) {
                root = root.right;
                stack.offerLast(root);
                while(root != null && root.left != null) {
                    root = root.left;
                    stack.offerLast(root);
                }
            }
        }
        return result;
    }
}
