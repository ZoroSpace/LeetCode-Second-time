class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) return 0;
        int n = triangle.size();
        int[] sum = new int[n];
        for(int i = 0;i < n;i++) {
            for(int j = i;j >= 0;j--) {
                if(j == 0) {
                    sum[j] = sum[j] + triangle.get(i).get(j);
                } else if(j == i) {
                    sum[j] = sum[j-1] + triangle.get(i).get(j);
                } else {
                    sum[j] = Math.min(sum[j],sum[j-1]) + triangle.get(i).get(j);
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0;i < n;i++) {
            result = Math.min(result,sum[i]);
        }
        return result;
    }
}
