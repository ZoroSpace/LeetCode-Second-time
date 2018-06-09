class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if(str.length() == 0) return 0;
        long ans = 0;
        boolean pos = true;
        for(int i = 0;i < str.length();i++) {
            if(i == 0) {
                if(str.charAt(0) == '-' || str.charAt(0) == '+') {
                    pos = str.charAt(0) == '+';
                    continue;
                }
            }
            if(str.charAt(i) <= '9' && str.charAt(i) >= '0') {
                ans = ans * 10 + str.charAt(i) - '0';
            } else break;
            if(ans > Integer.MAX_VALUE) break;
        }
        if(pos) {
            if(ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else return (int) ans;
        }
        if(-ans > Integer.MIN_VALUE) return (int)(-ans);
        else return Integer.MIN_VALUE;
    }
}
