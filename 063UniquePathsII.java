class Solution {
    public int uniquePathsWithObstacles(int[][] a) {
        if(a.length == 0 || a[0].length == 0) return 0;
        int m = a.length,n = a[0].length;
        int[] ans = new int[n];
        ans[0] = 1;
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(a[i][j] == 1) ans[j] = 0;
                else if(j != 0) ans[j] = ans[j]+ans[j-1];
            }
        }
        return ans[n-1];
    }
}
