class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0) return false;
        return helper(nums,target,0,nums.length - 1);
    }
    boolean helper(int[] nums,int target,int lo,int hi) {
        if(hi - lo >= 2) {
            int mid = (hi - lo)/2+lo;
            if(nums[hi] > nums[lo]) {
                if(nums[mid] == target) return true;
                if(nums[mid] > target) return helper(nums,target,lo,mid);
                else return helper(nums,target,mid,hi);
            } else {
                return helper(nums,target,lo,mid) || helper(nums,target,mid,hi);
            }
        } else return nums[lo] == target || nums[hi] == target;
    }
}
