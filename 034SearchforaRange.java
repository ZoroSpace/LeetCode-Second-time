class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) {
            int[] ans = new int[2];
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }
        return helper(nums,target,0,nums.length-1);
    }
    
    int[] helper(int[] nums,int target,int lo,int hi) {
        int[] ans = new int[2];
        int mid = (hi-lo)/2+lo;
        if(hi-lo > 1) {
            if(nums[mid] > target) return helper(nums,target,lo,mid);
            else if(nums[mid] < target) return helper(nums,target,mid,hi);
            else {
                int[] b = helper(nums,target,lo,mid);
                int[] c = helper(nums,target,mid,hi);
                ans[0] = b[0];
                ans[1] = c[1];
            }
        } else {
            if(nums[lo] == nums[hi]) {
                if(nums[lo] == target) {
                    ans[0] = lo;
                    ans[1] = hi;
                } else {
                    ans[0] = -1;
                    ans[1] = -1;
                }
            } else {
                if(nums[lo] == target) {
                    ans[0] = lo;
                    ans[1] = lo;
                } else if(nums[hi] == target) {
                    ans[0] = hi;
                    ans[1] = hi;
                } else {
                    ans[0] = -1;
                    ans[1] = -1;
                }
            }
        }
        return ans;
    }
    
}
