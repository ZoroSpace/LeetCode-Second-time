class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while(i >= 0) {
            if(i == 0) {
                Arrays.sort(nums);
                return;
            }
            if(nums[i-1] >= nums[i]) i--;
            else break;
        }
        Arrays.sort(nums,i,nums.length);
        for(int j = i;j < nums.length;j++) {
            if(nums[j] > nums[i-1]) {
                int t = nums[i-1];
                nums[i-1] = nums[j];
                nums[j] = t;
                break;
            }
        }
        Arrays.sort(nums,i,nums.length);
    }
}
