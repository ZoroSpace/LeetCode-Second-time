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
