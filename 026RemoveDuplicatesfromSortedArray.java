class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int counter = 1;
        for(int i = 1;i < nums.length;i++) {
            if(nums[slow] != nums[i]) {
                slow++;
                nums[slow] = nums[i];
                counter++;
            }
        }
        return counter;
    }
}
