class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int y = 0;
        int t = x;
        while(t > 0) {
            y = 10*y+t%10;
            t = t/10;
        }
        return x == y;
    }
}
