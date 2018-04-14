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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if(root == null) return result;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int size = q.size();
        while(size != 0) {
            LinkedList<Integer> level = new LinkedList<>();
            for(int i = 0;i < size;i++) {
                TreeNode nodeX = q.poll();
                level.offer(nodeX.val);
                if(nodeX.left != null) q.offer(nodeX.left);
                if(nodeX.right != null) q.offer(nodeX.right);
            }
            size = q.size();
            result.push(level);
        }
        return result;
    }
}
