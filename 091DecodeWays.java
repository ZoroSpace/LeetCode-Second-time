class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for(int i = 1;i < s.length();i++) {
            if(s.charAt(i) == '0') {
                if(s.charAt(i-1) != '1' && s.charAt(i-1) != '2') return 0;
                if(i == 1) dp[i] = 1;
                else dp[i] = dp[i-2];
            } else if(s.charAt(i) <= '6') {
                if(s.charAt(i-1) != '1' && s.charAt(i-1) != '2') dp[i] = dp[i-1];
                else if(i == 1) dp[i] = 2;
                else dp[i] = dp[i-1] + dp[i-2];
            } else {
                if(s.charAt(i-1) != '1')  dp[i] = dp[i-1];
                else if(i == 1) dp[i] = 2;
                else dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[s.length() - 1];
    }
}
