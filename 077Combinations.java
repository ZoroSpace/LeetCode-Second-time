class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new LinkedList<>();
        return helper(ans,new LinkedList<Integer>(),n,k,1);
    }
    
    List<List<Integer>> helper(List<List<Integer>> ans,LinkedList<Integer> path,int n,int k,int start) {
        if(path.size() == k) {
            ans.add(new LinkedList<Integer>(path));
        } else {
            for(int i = start;i <= n;i++) {
                path.add(i);
                ans = helper(ans,path,n,k,i+1);
                path.remove(path.size() - 1);
            }
        }
        return ans;
    }
}
