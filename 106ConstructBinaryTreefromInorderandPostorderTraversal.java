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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0) return null;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < inorder.length;i++) {
            map.put(inorder[i],i);
        }
        return helper(inorder,postorder,0,inorder.length - 1,0,inorder.length - 1,map);
    }
    
    TreeNode helper(int[] inorder,int[] postorder,int inl,int inr,int pol,int por,HashMap<Integer,Integer> map) {
        if(inl > inr) return null;
        TreeNode root = new TreeNode(postorder[por]);
        if(inl == inr) return root;
        int rootIndex = map.get(postorder[por]);
        int rootRightIndex = por+rootIndex-inr;
        root.left = helper(inorder,postorder,inl,rootIndex-1,pol,rootRightIndex-1,map);
        root.right = helper(inorder,postorder,rootIndex+1,inr,rootRightIndex,por-1,map);
        return root;
    }
}
