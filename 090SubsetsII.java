class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        ans.add(new LinkedList<Integer>());
        if(nums.length == 0) return ans;
        Arrays.sort(nums);
        helper(ans,new LinkedList<Integer>(),nums,0);
        return ans;
    }
    
    void helper(List<List<Integer>> ans,LinkedList<Integer> path,int[] nums,int start) {
        if(start == nums.length) return;
        int j;
        for(j = start;j <= nums.length;j++) {
            if(j == nums.length || nums[j] != nums[start]) break;
        }
        for(int i = start;i < j;i++) {
            path.add(nums[i]);
            ans.add(new LinkedList<Integer>(path));
            helper(ans,path,nums,j);
        }
        for(int i = start;i < j;i++) {
            path.remove(path.size()-1);
        }
        helper(ans,path,nums,j);
    }
}
