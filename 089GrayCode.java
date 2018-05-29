class Solution {
    public List<Integer> grayCode(int n) {
        int m = (int)(Math.pow(2,n));
        List<Integer> ans = new LinkedList<>();
        for(int i = 0;i < m;i++) {
            ans.add(i ^ (i >> 1));
        }
        return ans;
    }
}
