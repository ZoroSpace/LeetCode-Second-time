class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums) {
            //map.put(i,i);
            //i --> j (i<j)
            //j --> i 
            if(map.containsKey(i)) continue;
            if(map.containsKey(i+1) && (i+1 <= map.get(i+1))) {
                int t = map.get(i+1);
                if(t != i+1) map.remove(i+1);
                map.put(i,t);
                map.put(t,i);
            } else map.put(i,i);
            if(map.containsKey(i-1)) {
                if(i-1 >= map.get(i-1)) {
                    int t1 = map.get(i-1);
                    int t2 = map.get(i);
                    if(i != t2) map.remove(i);
                    if(i-1 != t1) map.remove(i-1);
                    map.put(t1,t2);
                    map.put(t2,t1);
                }
            }
        }
        int ans = 1;
        for(int i : map.keySet()) {
            ans = Math.max(ans,map.get(i) - i+1);
        }
        return ans;
    }
}
