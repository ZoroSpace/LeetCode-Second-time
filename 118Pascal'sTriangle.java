class Solution {
    public List<List<Integer>> generate(int n) {
        int[][] mat = new int[n][n];
        for(int i = 0;i < n;i++) {
            for(int j = 0;j <= i;j++) {
                if(j == 0 || j == i) {
                    mat[i][j] = 1;
                } else mat[i][j] = mat[i-1][j-1]+mat[i-1][j];
            }
        }
        LinkedList<List<Integer>> result = new LinkedList<>();
        for(int i = 0;i < n;i++) {
            LinkedList<Integer> level = new LinkedList<>();
            for(int j = 0;j <= i;j++) {
                level.offer(mat[i][j]);
            }
            result.offer(level);
        }
        return result;
    }
    
}
