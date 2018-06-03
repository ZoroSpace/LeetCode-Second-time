class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        return helper(nums,target,0,nums.length-1);
    }
    
    int helper(int[] nums,int target,int lo,int hi) {
        if(hi - lo >= 2) {
            int mid = (hi-lo)/2+lo;
            if(nums[hi] > nums[lo]) {
                if(nums[lo] > target || nums[hi] < target) return -1;
                if(nums[mid] == target) return mid;
                if(nums[mid] > target) return helper(nums,target,lo,mid);
                else return helper(nums,target,mid,hi);
            } else {
                return Math.max(helper(nums,target,lo,mid),helper(nums,target,mid,hi));
            }
        } else {
            if(nums[lo] == target) return lo;
            if(nums[hi] == target) return hi;
            else return -1;
        }
    }
}
