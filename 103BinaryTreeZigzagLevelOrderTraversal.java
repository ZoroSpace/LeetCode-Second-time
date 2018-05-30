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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null) return ans;
        LinkedList<TreeNode> nodeList = new LinkedList<>();
        nodeList.offerLast(root);
        int size = nodeList.size();
        boolean l2r = true;
        while(size != 0) {
            LinkedList<Integer> numList = new LinkedList<>();
            for(int i = 0;i < size;i++) {
                root = nodeList.pollFirst();
                if(root.left != null) nodeList.offerLast(root.left);
                if(root.right != null) nodeList.offerLast(root.right);
                if(l2r) numList.offerLast(root.val);
                else numList.offerFirst(root.val);
            }
            l2r = !l2r;
            ans.add(numList);
            size = nodeList.size();
        }
        return ans;
    }
}
