class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        for(int i = 0;i < nums.length - 3;i++) {
            for(int j = i+1;j < nums.length - 2;j++) {
                int lo = j+1;
                int hi = nums.length - 1;
                while(lo < hi) {
                    int t = nums[lo] + nums[hi] + nums[i] + nums[j];
                    if(t > target) hi--;
                    else if(t < target) lo++;
                    else {
                        result.offer(Arrays.asList(nums[lo],nums[hi],nums[i],nums[j]));
                        while(lo < hi && nums[lo] == nums[lo + 1]) {
                            lo++;
                        }
                        lo++;
                    }
                }
                while(j < nums.length - 2 && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            while(i < nums.length - 3 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }
}
