class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(char c : t.toCharArray()) {
            if(map.containsKey(c)) map.put(c,map.get(c)+1);
            else map.put(c,1);
        }
        int fast = 0,slow = 0;
        int lo = 0,hi = s.length();
        while(fast < s.length()) {
            char c = s.charAt(fast);
            if(!map.containsKey(c)) {
                fast++;
                continue;
            }
            map.put(c,map.get(c)-1);
            boolean contain = true;
            for(int i : map.values()) {
                if(i > 0) {
                    contain = false;
                }
            }
            while(contain) {
                if(fast - slow < hi - lo) {
                    hi = fast;
                    lo = slow;
                }
                if(map.containsKey(s.charAt(slow))) {
                    map.put(s.charAt(slow),map.get(s.charAt(slow))+1);
                }
                slow++;
                for(int i : map.values()) {
                    if(i > 0) {
                        contain = false;
                    }
                }
            }
            fast++;
        }
        return hi == s.length()?"":s.substring(lo,hi+1);
    }
}
