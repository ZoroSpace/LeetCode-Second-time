class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);
        helper(ans,new LinkedList<>(),nums,0,0);
        return ans;
    }
    
    void helper(List<List<Integer>> ans,LinkedList<Integer> path,int[] nums,int cur,int start) {
        if(cur == nums.length) {
            ans.add(new LinkedList<Integer>(path));
            return;
        }
        for(int i = start;i <= cur;i++) {
            path.add(i,nums[cur]);
            if(cur+1 < nums.length && nums[cur] == nums[cur+1]) helper(ans,path,nums,cur+1,i+1);
            else helper(ans,path,nums,cur+1,0);
            path.remove(i);
        }
    }
}
