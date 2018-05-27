class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return helper(nums,nums.length - 1);
    }
    
    List<List<Integer>> helper(int[] nums,int index) {
        List<List<Integer>> result = new LinkedList<>();
        if(index == -1) {
            LinkedList<Integer> list = new LinkedList<>();
            result.add(list);
            return result;
        }
        List<List<Integer>> last = helper(nums,index - 1);
        for(List<Integer> list : last) {
            for(int i = 0;i < index+1;i++) {
                List<Integer> list1 = (LinkedList<Integer>)(((LinkedList<Integer>)list).clone());
                list1.add(i,nums[index]);
                result.add(list1);
            }
        }
        return result;
    }
}
