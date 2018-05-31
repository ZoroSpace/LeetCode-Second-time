class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);
        helper(ans,new LinkedList<Integer>(),nums,target,0);
        return ans;
    }
    
    void helper(List<List<Integer>> ans,LinkedList<Integer> path,int[] nums,int target,int start) {
        if(target == 0) ans.add(new LinkedList<Integer>(path));
        if(start < nums.length && nums[start] > target) return;
        for(int i = start;i < nums.length;i++) {
            
            if(i != start && nums[i] == nums[i-1]) continue;
            path.add(nums[i]);
            helper(ans,path,nums,target-nums[i],i+1);
            path.remove(path.size() - 1);
        }
    }
}
