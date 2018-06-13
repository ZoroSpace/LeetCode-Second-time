class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        //注意""的情况
        LinkedList<Integer> ans = new LinkedList<>();
        if(words.length == 0) return ans;
        int delta = words[0].length();
        if(delta == 0) {
            for(int i = 0;i <= s.length();i++) ans.add(i);
            return ans;
        }        
        
        for(int i = 0;i < delta;i++) {
            int lo = i,hi = i;
            int counter = 0;
            HashMap<String,Integer> map = new HashMap<>();
            for(String s1 : words) {
                counter++;
                if(map.containsKey(s1)) map.put(s1,map.get(s1)+1);
                else map.put(s1,1);
            }
            while(hi + delta <= s.length()) {
                String cpr = s.substring(hi,hi+delta);
                String cpr2 = s.substring(lo,lo+delta);
                if(map.containsKey(cpr)) {
                    if(map.get(cpr) > 0) {
                        map.put(cpr,map.get(cpr)-1);
                        counter--;
                        hi = hi + delta;
                    } else {
                        map.put(cpr2,map.get(cpr2)+1);
                        counter++;
                        lo = lo + delta;
                    }
                } else {
                    if(map.containsKey(cpr2)) {
                        map.put(cpr2,map.get(cpr2)+1);
                        counter++;
                        lo = lo + delta;
                    } else {
                        lo = lo+delta;
                        hi = hi + delta;
                    }
                }
                if(counter == 0) {
                    ans.add(lo);
                    map.put(cpr2,map.get(cpr2)+1);
                    counter++;
                    lo = lo + delta;
                }
            }
        }
        return ans;
    }
}
