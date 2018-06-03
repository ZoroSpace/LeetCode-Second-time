class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        int delta = Integer.MAX_VALUE;
        for(int i = 0;i < nums.length - 2;i++) {
            int lo = i+1,hi = nums.length - 1;
            while(lo < hi) {
                int t = Math.abs(nums[lo] + nums[hi] - target + nums[i]);
                if(t == 0) return nums[lo] + nums[hi] + nums[i];
                if(t < delta) {
                    delta = t;
                    ans = nums[lo] + nums[hi] + nums[i];
                }
                if(nums[lo] + nums[hi] - target + nums[i] < 0) lo++;
                else hi--;
            }
        }
        return ans;
    }
}
