class Solution {
    public int maxArea(int[] height) {
        int lo = 0,hi = height.length - 1,ans = 0;
        while(lo < hi) {
            ans = Math.max(ans,Math.min(height[lo],height[hi]) * (hi - lo));
            if(height[lo] < height[hi]) lo++;
            else hi--;
        }
        return ans;
    }
}
