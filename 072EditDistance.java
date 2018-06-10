class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length() == 0 || word2.length() == 0) return Math.max(word1.length(),word2.length());
        int m = word1.length(),n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 1;i <= m;i++) dp[i][0] = i;
        for(int i = 1;i <= n;i++) dp[0][i] = i;
        for(int i = 1;i <= m;i++) {
            for(int j = 1;j <= n;j++) {
                //word1:i-1.word2:j-1.
                if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else {
                    dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j]);
                    dp[i][j] = Math.min(dp[i-1][j-1],dp[i][j]);
                    dp[i][j]++;
                }
            }
        }
        return dp[m][n];
    }
}
