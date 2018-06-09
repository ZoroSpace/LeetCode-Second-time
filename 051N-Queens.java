class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new LinkedList<>();
        helper(ans,new LinkedList<String>(),n,0,new boolean[2*n-1],new boolean[2*n-1],new boolean[n]);
        return ans;
    }
    
    void helper(List<List<String>> ans,LinkedList<String> path,int n,int i,boolean[] lcross,boolean[] rcross,boolean[] verticle) {
        if(i == n) {
            ans.add(new LinkedList<String>(path));
            return;
        }
        for(int j = 0;j < n;j++) {
            if(lcross[i+j] || rcross[j-i+n-1] || verticle[j]) continue;
            lcross[i+j] = true;
            rcross[j-i+n-1] = true;
            verticle[j] = true;
            StringBuilder sb = new StringBuilder("");
            for(int k = 0;k < n;k++) {
                if(k == j) sb.append('Q');
                else sb.append('.');
            }
            path.add(sb.toString());
            helper(ans,path,n,i+1,lcross,rcross,verticle);
            lcross[i+j] = false;
            rcross[j-i+n-1] = false;
            verticle[j] = false;
            path.remove(path.size() - 1);
        }
    }
}
