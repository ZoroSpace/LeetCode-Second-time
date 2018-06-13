class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(),n = p.length();
        boolean[][] ans = new boolean[m+1][n+1];
        ans[0][0] = true;
        for(int i = 1;i < n+1;i++) {
            if(p.charAt(i-1) == '*') ans[0][i] = ans[0][i-2];
            
        }
        for(int i = 1;i < m+1;i++) {
            for(int j = 1;j < n+1;j++) {
                if(p.charAt(j-1) == '.') {
                    ans[i][j] = ans[i-1][j-1];
                } else if(p.charAt(j-1) == '*') {
                    if(ans[i][j-2] || ans[i][j-1]) ans[i][j] = true;
                    else if(p.charAt(j-2) == '.' || p.charAt(j-2) == s.charAt(i-1)) ans[i][j] = ans[i-1][j];
                } else {
                    if(s.charAt(i-1) == p.charAt(j-1)) ans[i][j] = ans[i-1][j-1];
                }
            }
        }
        return ans[m][n];
    }
}
