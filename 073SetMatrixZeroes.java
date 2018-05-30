class Solution {
    public void setZeroes(int[][] mat) {
        if(mat.length == 0 || mat[0].length == 0) return;
        int m = mat.length,n = mat[0].length;
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(mat[i][j] == 0) fill(mat,i,j);
            }
        }
        
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(mat[i][j] == Integer.MAX_VALUE-3231) mat[i][j] = 0;
            }
        }
    }
    
    void fill(int[][] mat,int i,int j) {
        int m = mat.length,n = mat[0].length;
        for(int ii = 0;ii < m;ii++) {
            if(mat[ii][j] != 0) mat[ii][j] = Integer.MAX_VALUE-3231;
        }
        for(int jj = 0;jj < n;jj++) {
            if(mat[i][jj] != 0) mat[i][jj] = Integer.MAX_VALUE-3231;
        }
    }
}
