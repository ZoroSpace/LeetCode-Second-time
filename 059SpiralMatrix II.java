class Solution {
    public int[][] generateMatrix(int n) {
        int all = n*n;
        int row = 0,col = 0;
        int[][] ans = new int[n][n];
        for(int i = 1;i <= all;i++) {
            ans[row][col] = i;
            if((col == n-1 || ans[row][col+1] != 0) && !(row == n-1 || ans[row+1][col] != 0)) {
                row++;
            } else if((row == n-1 || ans[row+1][col] != 0) && !(col == 0 || ans[row][col-1] != 0)) {
                col--;
            } else if((col == 0 || ans[row][col-1] != 0) && !(row == 0 || ans[row-1][col] != 0)) {
                row--;
            } else {
                col++;
            }
        }
        return ans;
    }
}
