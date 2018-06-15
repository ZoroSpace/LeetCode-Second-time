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

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        int counter = 0;
        for(int i = 0;i < t.length();i++) {
            if(map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i),map.get(t.charAt(i)) + 1);
            } else map.put(t.charAt(i),1);
            counter++;
        }
        int anslo = 0,anshi = s.length()+1;
        int lo = 0,hi = 0;
        while(hi < s.length()) {
            char c = s.charAt(hi);
            if(map.containsKey(c)) {
                map.put(c,map.get(c)-1);
                if(map.get(c) >= 0) counter--;
            }
            hi++;
            while(counter == 0) {
                if(hi - lo < anshi - anslo) {
                    anshi = hi;
                    anslo = lo;
                }
                char clo = s.charAt(lo);
                if(map.containsKey(clo)) {
                    map.put(clo,map.get(clo)+1);
                    if(map.get(clo) > 0) counter++;
                }
                lo++;
            }
        }
        return anshi-anslo == s.length()+1 ? "":s.substring(anslo,anshi);
    }
}
