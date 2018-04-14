class Solution {
    public int maxSubArray(int[] nums) {
        int result = 0;
        int maxSoFar = 0;
        int maxEl = nums[0];
        for(int i = 0;i < nums.length;i++) {
            maxEl = Math.max(maxEl,nums[i]);
        }
        if(maxEl <= 0) return maxEl;
        for(int i = 0;i < nums.length;i++) {
            maxSoFar = Math.max(0,maxSoFar+nums[i]);
            result = Math.max(result,maxSoFar);
        }
        return result;
    }
}
