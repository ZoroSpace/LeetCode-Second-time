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

class Solution {
    public void setZeroes(int[][] a) {
        if(a.length == 0 || a[0].length == 0) return;
        boolean fr = false,fc = false;
        int m = a.length,n = a[0].length;
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(a[i][j] == 0) {
                    if(i == 0) fr = true;
                    if(j == 0) fc = true;
                    a[i][0] = 0;
                    a[0][j] = 0;
                }
            }
        }
        
        for(int i = 1;i < m;i++) {
            for(int j = 1;j < n;j++) {
                if(a[i][0] == 0 || a[0][j] == 0) a[i][j] = 0;
            }
        }
        
        if(fc) {
            for(int i = 0;i < m;i++) a[i][0] = 0;
        }
        if(fr) {
            for(int j = 0;j < n;j++) a[0][j] = 0;
        }
    }
}
