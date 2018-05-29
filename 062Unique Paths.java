class Solution {
    public int uniquePaths(int m, int n) {
        int[] mat = new int[m];
        mat[0] = 1;
        for(int i = 0;i < n;i++) {
            for(int j = 1;j < m;j++) {
                mat[j] = mat[j] + mat[j-1];
            }
        }
        return mat[m-1];
    }
}
