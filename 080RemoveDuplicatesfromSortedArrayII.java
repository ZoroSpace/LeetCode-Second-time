class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2) return nums.length;
        int slow = 0,counter = 1;
        for(int fast = 1;fast < nums.length;fast++) {
            if(nums[fast] == nums[slow]) {
                if(counter < 2) {
                    slow++;
                    nums[slow] = nums[fast];
                    counter++;
                }
            } else {
                counter=1;
                slow++;
                nums[slow] = nums[fast];
            }
        }
        
        return slow+1;
    }
}
