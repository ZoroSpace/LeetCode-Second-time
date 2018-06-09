class Solution {
    public int divide(int x, int y) {
        if(x == Integer.MIN_VALUE && y == -1) return Integer.MAX_VALUE;
        if(x < 0 && y < 0) return helper(-((long)x),-((long)y));
        else if(x >= 0 && y > 0) return helper(x,y);
        else if(x < 0) return -helper(-((long)x),y);
        else return -helper(x,-((long)y));
    }
    
    int helper(long x,long y) {
        if(x < y) return 0;
        int ans = 0;
        int counter1 = 0,counter2 = 0;
        long cpr = 0x8000000000L;
        while(x < cpr) {
            counter1++;
            cpr = cpr>>1;
        }
        cpr = 0x8000000000L;
        while(y < cpr) {
            counter2++;
            cpr = cpr>>1;
        }
        for(int i = 0;i < counter2-counter1;i++) {
            y = y << 1;
        }
        for(int i = 0;i < counter2-counter1+1;i++) {
            ans = ans<<1;
            if(x >= y) {
                ans++;
                x = x - y;
            }
            y = y>>1;
        }
        return Math.min(Integer.MAX_VALUE,(int)ans);
    }
}
