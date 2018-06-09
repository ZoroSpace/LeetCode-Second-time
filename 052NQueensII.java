class Solution {
    private int ans;
    public int totalNQueens(int n) {
        boolean[] leftCross = new boolean[2*n-1];
        boolean[] rightCross = new boolean[2*n-1];
        boolean[] verticle = new boolean[n];
        helper(n,0,leftCross,rightCross,verticle);
        return ans;
    }
    void helper(int n,int level,boolean[] leftCross,boolean[] rightCross,boolean[] verticle) {
        if(level == n) {
            ans++;
            return;
        }
        for(int i = 0;i < n;i++) {
            //level行，i列,(level,i)
            if(leftCross[level+i] || rightCross[i-level+n-1] || verticle[i]) continue;
            boolean t1 = leftCross[level+i];
            boolean t2 = rightCross[i-level+n-1];
            boolean t3 = verticle[i];
            leftCross[level+i] = true;
            rightCross[i-level+n-1] = true;
            verticle[i] = true;
            helper(n,level+1,leftCross,rightCross,verticle);
            leftCross[level+i] = t1;
            rightCross[i-level+n-1] = t2;
            verticle[i] = t3;
        }
    }
}
