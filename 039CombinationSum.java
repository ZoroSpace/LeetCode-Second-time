class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        return helper(ans,new LinkedList<>(),target,0,nums);
    }
    
    List<List<Integer>> helper(List<List<Integer>> ans,LinkedList<Integer> list,int target,int start,int[] nums) {
        if(target == 0) {
            ans.add(new LinkedList<Integer>(list));
            return ans;
        } else if(target < 0) return ans;
        else {
            for(int i = start;i < nums.length;i++) {
                list.add(nums[i]);
                ans = helper(ans,list,target - nums[i],i,nums);
                list.remove(list.size() - 1);
            }
            return ans;
        }
            
    }
}
