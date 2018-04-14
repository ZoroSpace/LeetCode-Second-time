class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length - 2) {
            if(nums[i] > 0) break;
            int lo = i+1;
            int hi = nums.length - 1;
            while(lo < hi) {
                if(nums[lo]+nums[hi]+nums[i] > 0) {
                    hi--;
                    while(lo <= hi && nums[hi] == nums[hi + 1]) {
                        hi--;
                    }
                } else if(nums[lo] + nums[hi] + nums[i] < 0) {
                    lo++;
                    while(lo <= hi && nums[lo] == nums[lo - 1]) {
                        lo++;
                    }
                } else {
                    LinkedList<Integer> level = new LinkedList<>();
                    level.offer(nums[lo]);
                    level.offer(nums[i]);
                    level.offer(nums[hi]);
                    result.offer(level);
                    lo++;
                    while(lo <= hi && nums[lo] == nums[lo - 1]) {
                        lo++;
                    }
                }
            }
            i++;
            while(i < nums.length - 2 && nums[i] == nums[i - 1]) {
                i++;
            }
        }
        return result;
    }
}
