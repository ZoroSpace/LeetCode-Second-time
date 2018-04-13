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
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length - 1);
    }
    TreeNode helper(int[] nums,int lo,int hi) {
        if(lo > hi) return null;
        int mid = (hi - lo)/2 + lo;
        TreeNode nodeX = new TreeNode(nums[mid]);
        nodeX.left = helper(nums,lo,mid - 1);
        nodeX.right = helper(nums,mid+1,hi);
        return nodeX;
    }
}
