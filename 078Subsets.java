
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return helper(nums,nums.length);
    }
    LinkedList<List<Integer>> helper(int[] nums,int n) {
        if(n == 0) {
            LinkedList<List<Integer>> result = new LinkedList<>();
            result.add(new LinkedList<Integer>());
            return result;
        }
        LinkedList<List<Integer>> result = helper(nums,n-1);
        int size = result.size();
        for(int i = 0;i < size;i++) {
            List<Integer> list = result.get(i);
            LinkedList<Integer> list2 = (LinkedList<Integer>)(((LinkedList<Integer>)list).clone());
            list2.add(nums[n-1]);
            result.add(list2);
        }
        return result;
    }
}
