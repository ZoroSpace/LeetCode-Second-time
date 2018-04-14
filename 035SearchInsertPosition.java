class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0) return 0;
        return helper(nums,target,0,nums.length - 1);
    }
    
    int helper(int[] nums,int target,int lo,int hi) {
        int mid = (hi - lo)/2 + lo;
        if(target == nums[mid]) return mid;
        if(target < nums[mid]) {
            if(lo == hi) return mid;
            else return helper(nums,target,lo,mid);
        } else {
            if(lo == hi) return mid+1;
            else return helper(nums,target,mid+1,hi);
        }
        
    }
}
