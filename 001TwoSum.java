class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] old = new int[nums.length];
        for(int i = 0;i < nums.length;i++) {
            old[i] = nums[i];
        }
        Arrays.sort(nums);
        int lo = 0;
        int hi = nums.length - 1;
        while(nums[lo] + nums[hi] != target) {
            if(nums[lo] + nums[hi] > target) hi--;
            else lo++;
        }
        int[] result = new int[2];
        for(int i = 0;i < old.length;i++) {
            if(nums[lo] == old[i]) {
                result[0] = i;
                break;
            }
        }
        for(int i = old.length - 1;i >= 0;i--) {
            if(nums[hi] == old[i]) {
                result[1] = i;
                break;
            }
        }
        return result;
    }
}
