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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        return helper(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
    
    TreeNode helper(int[] preorder,int[] inorder,int prel,int prer,int inl,int inr) {
        if(prel > prer) return null;
        TreeNode root = new TreeNode(preorder[prel]);
        if(prel == prer) return root;
        int rootIndex = indexOf(inorder,preorder[prel]);
        int rootRightIndex = prel+rootIndex-inl;
        root.left = helper(preorder,inorder,prel+1,rootRightIndex,inl,rootIndex-1);
        root.right = helper(preorder,inorder,rootRightIndex+1,prer,rootIndex+1,inr);
        return root;
    }

    int indexOf(int[] nums,int tar) {
        for(int i = 0;i < nums.length;i++) {
            if(nums[i] == tar) return i;
        }
        return -1;
    }
}
