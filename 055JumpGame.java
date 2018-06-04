class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length <= 1) return true;
        int j = nums.length - 1;
        for(int i = j - 1;i > -1;i--) {
            if(nums[i] + i >= j) j = i;
            if(j == 0) return true;
        }
        return false;
    }
}
