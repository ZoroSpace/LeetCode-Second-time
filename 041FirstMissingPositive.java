class Solution {
    public int firstMissingPositive(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums) {
            if(i <= 0 || map.containsKey(i)) continue;
            map.put(i,i);
            if(map.containsKey(i-1)) {
                int t = map.get(i-1);
                map.put(i,t);
                map.put(t,i);
            }
            if(map.containsKey(i+1)) {
                int head = map.get(i);
                int tail = map.get(i+1);
                map.put(head,tail);
                map.put(tail,head);
            }
        }
        
        
        if(!map.containsKey(1)) return 1;
        else return map.get(1)+1;
    }
}
