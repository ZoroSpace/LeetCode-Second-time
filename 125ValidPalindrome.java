class Solution {
    public boolean isPalindrome(String s) {
        int lo = 0,hi = s.length() - 1;
        while(lo < hi) {
            while(lo < hi && 
                  !(('a' <= s.charAt(lo) && 'z' >= s.charAt(lo)) ||
                   ('A' <= s.charAt(lo) && 'Z' >= s.charAt(lo)) ||
                   ('0' <= s.charAt(lo) && '9' >= s.charAt(lo)))) lo++;
            while(lo < hi && 
                  !(('a' <= s.charAt(hi) && 'z' >= s.charAt(hi)) ||
                   ('A' <= s.charAt(hi) && 'Z' >= s.charAt(hi)) ||
                   ('0' <= s.charAt(hi) && '9' >= s.charAt(hi)))) hi--;
            if(('0' <= s.charAt(lo) && '9' >= s.charAt(lo)) ||
              ('0' <= s.charAt(hi) && '9' >= s.charAt(hi))) {
                if(s.charAt(lo) != s.charAt(hi)) return false;
            } else if(!(s.charAt(lo) == s.charAt(hi) ||
              s.charAt(lo) == s.charAt(hi) + 'A' - 'a' ||
              s.charAt(lo) == s.charAt(hi) + 'a' - 'A')) return false;
            lo++;
            hi--;
        }
        return true;
    }
}
