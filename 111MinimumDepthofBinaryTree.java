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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1;
        int result = Integer.MAX_VALUE;
        int size = q.size();
        while(size != 0) {
            for(int i = 0;i < size;i++) {
                TreeNode nodeX = q.poll();
                if(nodeX.left == null && nodeX.right == null) result = Math.min(result,level);
                if(nodeX.left != null) q.offer(nodeX.left);
                if(nodeX.right != null) q.offer(nodeX.right);
            }
            size = q.size();
            level++;
        }
        return result;
    }
}
