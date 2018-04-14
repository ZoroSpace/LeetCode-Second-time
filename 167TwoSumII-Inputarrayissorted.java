class Solution {
    public int[] twoSum(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while(nums[lo] + nums[hi] != target) {
            if(nums[lo] + nums[hi] > target) hi--;
            else lo++;
        }
        int[] result = new int[2];
        result[0] = lo+1;
        result[1] = hi+1;
        return result;
    }
}
