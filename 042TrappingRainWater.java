class Solution {
    public int trap(int[] a) {
        int lo = 0,hi = a.length - 1,ans = 0;
        while(lo < hi) {
            if(a[lo] >= a[hi]) {
                if(a[hi] > a[hi-1]) {
                    ans = ans + a[hi] - a[hi-1];
                    a[hi-1] = a[hi];
                }
                hi--;
            } else {
                if(a[lo] > a[lo+1]) {
                    ans = ans + a[lo] - a[lo+1];
                    a[lo+1] = a[lo];
                }
                lo++;
            } 
        }
        return ans;
    }
}
