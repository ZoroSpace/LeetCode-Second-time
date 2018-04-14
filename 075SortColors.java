class Solution {
    public void sortColors(int[] nums) {
        int lo = 0;
        while(lo < nums.length && nums[lo] == 0) lo++;
        for(int i = lo;lo < nums.length && i < nums.length;i++) {
            if(nums[i] == 0) {
                nums[i] = nums[lo];
                nums[lo] = 0;
                lo++;
            }
        }
        int hi = nums.length - 1;
        while(hi >= 0 && nums[hi] == 2) hi--;
        for(int i = hi;hi >= 0 && i >= 0;i--) {
            if(nums[i] == 2) {
                nums[i] = nums[hi];
                nums[hi] = 2;
                hi--;
            }
        }
        return;
    }
}
