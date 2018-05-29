class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length,n = grid[0].length;
        int[] ans = new int[n];
        for(int j = 1;j < n;j++) {
            ans[j] = Integer.MAX_VALUE;
        }
        for(int i = 0;i < m;i++) {
            ans[0] = ans[0]+grid[i][0];
            for(int j = 1;j < n;j++) {
                ans[j] = Math.min(ans[j-1],ans[j])+grid[i][j];
            }
        }
        return ans[n-1];
    }
}
