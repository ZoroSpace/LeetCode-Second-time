class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n <= 1) return 0;
        if(n == 2) return 1;
        int ans = 0;
        int start = 0;
        int maxpoint = 0;
        int max = 0;
        while(start + nums[start] < n-1) {
            ans++;
            for(int i = start+1;i <= start+nums[start];i++) {
                if(max < i+nums[i]) {
                    max = i+nums[i];
                    maxpoint = i;
                }
            }
            start = maxpoint;
        }
        return ans+1;
    }
}
