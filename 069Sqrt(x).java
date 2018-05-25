class Solution {
    public int mySqrt(int x) {
        if(x <= 1) return x;
        return helper(x,0,x);
    }
    
    int helper(int x,int lo,int hi) {
        //lo<= sqrt(x) < hi
        if(hi - lo <= 1) return lo;
        int mid = lo+(hi-lo)/2;
        if(x/mid < mid) return helper(x,lo,mid);
        // x = (x/mid)*mid + x % mid
        else return helper(x,mid,hi);
    }
}


class Solution {
    public int mySqrt(int n) {
        if(n == 0) return 0;
        long x = n;
        while(x > n/x) {
            x = (x + n/x)/2;
        }
        return (int)x;
    }
}
