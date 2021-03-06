class Solution {
    private int ans = Integer.MAX_VALUE;
    public int minCut(String s) {
        boolean[][] isP = new boolean[s.length()][s.length()];
        for(int i = 0;i < s.length();i++) {
            for(int j = i;j < s.length();j++) {
                isP[i][j] = isValid(s.substring(i,j+1));
            }
        }
        helper(s,0,-1,isP);
        return ans;
    }
    
    void helper(String s,int start,int level,boolean[][] isP) {
        if(ans < level) return;
        if(start == s.length()) {
            ans = Math.min(ans,level);
            return;
        }
        for(int i = s.length();i >= start+1;i--) {
            if(isP[start][i-1]) {
                helper(s,i,level+1,isP);
            }
        }
    }
    boolean isValid(String s) {
        for(int i = 0;i < s.length()/2;i++) {
            if(s.charAt(i) != s.charAt(s.length()-1-i)) return false;
        }
        return true;
    }
    
}


class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] pal = new boolean[n][n];
        int[] ans = new int[n];
        for(int i = 0;i < n;i++) ans[i] = i;
        for(int i = 0;i < n;i++) {
            for(int j = 0;j <= i;j++) {
                if(i == j || (s.charAt(i) == s.charAt(j) && (pal[i-1][j+1] || i == j+1))) {
                    pal[i][j] = true;//从j到i是回文
                    if(j == 0) ans[i] = 0;
                    else ans[i] = Math.min(ans[i],ans[j-1]+1);
                }
            }
        }
        return ans[n-1];
    }
}


class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[] pal = new boolean[n];
        int[] ans = new int[n];
        for(int i = 0;i < n;i++) ans[i] = i;
        for(int i = 0;i < n;i++) {
            for(int j = 0;j <= i;j++) {
                if(i == j || (s.charAt(i) == s.charAt(j) && (i == j+1 || pal[j+1]))) {
                    pal[j] = true;
                    if(j == 0) ans[i] = 0;
                    else ans[i] = Math.min(ans[i],ans[j-1]+1);
                } else pal[j] = false;
            }
        }
        return ans[n-1];
    }
}
