class Solution {
    public int romanToInt(String s) {
        if(s.length() == 0) return 0;
        int result = 0;
        int cur = helper(s.charAt(0));
        for(int i = 1;i < s.length();i++) {
            if(s.charAt(i) == s.charAt(i-1)) {
                cur = cur + helper(s.charAt(i));
            } else if(helper(s.charAt(i)) > helper(s.charAt(i-1))) {
                result = result - cur;
                cur = helper(s.charAt(i));
            } else {
                result = result + cur;
                cur = helper(s.charAt(i));
            }
        }
        return result + cur;
    }
    
    int helper(char c) {
        switch(c) {
            case 'M':return 1000;
            case 'D':return 500;
            case 'C':return 100;
            case 'L':return 50;
            case 'X':return 10;
            case 'V':return 5;
            case 'I':return 1;
        }
        return 0;
    }
}
