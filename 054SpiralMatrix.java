class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> ans = new LinkedList<>();
        if(mat.length == 0 || mat[0].length == 0) return ans;
        helper(ans,mat,0,0,mat.length-1,mat[0].length-1);
        return ans;
    }
    
    void helper(List<Integer> ans,int[][] mat,int r1,int c1,int r2,int c2) {
        if(r1 > r2 || c1 > c2) return;
        if(r1 == r2) {
            for(int i = c1;i <= c2;i++) ans.add(mat[r1][i]);
        } else if(c1 == c2) {
            for(int i = r1;i <= r2;i++) ans.add(mat[i][c1]);
        } else {
            for(int i = c1;i < c2;i++) ans.add(mat[r1][i]);
            for(int i = r1;i < r2;i++) ans.add(mat[i][c2]);
            for(int i = c2;i > c1;i--) ans.add(mat[r2][i]);
            for(int i = r2;i > r1;i--) ans.add(mat[i][c1]);
            helper(ans,mat,r1+1,c1+1,r2-1,c2-1);
        }
    }
}
