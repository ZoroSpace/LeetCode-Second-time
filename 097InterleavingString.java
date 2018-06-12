class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(),n = s2.length();
        if(s1.length()+s2.length() != s3.length()) return false;
        if(s3.length() == 0) return true;
        boolean[][] dp = new boolean[m+1][n+1];
        for(int i = 1;i <= m;i++) {
            if(s1.charAt(i-1) == s3.charAt(i-1)) dp[i][0] = true;
            else break;
        }
        for(int i = 1;i <= n;i++) {
            if(s2.charAt(i-1) == s3.charAt(i-1)) dp[0][i] = true;
            else break;
        }
        
        for(int i = 1;i <= m;i++) {
            for(int j = 1;j <= n;j++) {
                if(dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1) || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1))) dp[i][j] = true;
            }
        }
        return dp[m][n];
    }
}
