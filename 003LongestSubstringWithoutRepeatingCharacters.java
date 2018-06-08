class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        int lo = 0,hi = 0;
        int ans = 1;
        HashSet<Character> set = new HashSet<>();
        while(hi < s.length()) {
            if(hi == lo) {
                set.add(s.charAt(hi));
            } else if(set.contains(s.charAt(hi))) {
                while(lo < hi) {
                    if(s.charAt(lo) != s.charAt(hi)) set.remove(s.charAt(lo));
                    else {
                        lo++;
                        break;
                    }
                    lo++;                    
                }
            } else set.add(s.charAt(hi));
            hi++;
            ans = Math.max(ans,hi - lo);
        }
        return ans;
    }
}
