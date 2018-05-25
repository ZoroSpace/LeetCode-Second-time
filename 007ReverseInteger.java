class Solution {
    public int reverse(int x) {
        if(x == Integer.MIN_VALUE || x == 0) return 0;
        boolean isPositive = true;
        if(x < 0) {
            x = -x;
            isPositive = false;
        }
        while(x % 10 == 0) x = x/10;
        long y = 0;
        while(x > 0) {
            y = 10*y+x%10;
            x = x/10;
        }
        if(y > Integer.MAX_VALUE) return 0;
        if(!isPositive) y = -y;
        return (int)y;
    }
}
