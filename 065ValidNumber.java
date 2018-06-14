class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if(helper1(s)) return true;
        if(helper2(s)) return true;
        if(helper3(s)) return true;
        return false;
    }
    
    boolean helper1(String s) {
        //带符号整数
        if(s.length() == 0) return false;
        if(s.charAt(0) == '+' || s.charAt(0) == '-') s = s.substring(1,s.length());
        if(s.length() == 0) return false;
        for(int i = 0;i < s.length();i++) {
            if(s.charAt(i) > '9' || s.charAt(i) < '0') return false;
        }
        return true;
    }
    
    boolean helper2(String s) {
        //带符号小数
        if(s.length() == 0) return false;
        if(s.charAt(0) == '+' || s.charAt(0) == '-') s = s.substring(1,s.length());
        if(s.length() == 0) return false;
        int i = 0;
        for(;i < s.length();i++) {
            if(s.charAt(i) == '.') break;
        }
        if(i == s.length()) return false;
        if(s.length() == 1) return false;
        
        for(int j = i+1;j < s.length();j++) {
            if(s.charAt(j) > '9' || s.charAt(j) < '0') return false;
        }
        
        if(i == 0) return true;
        return helper1(s.substring(0,i));
    }
    
    boolean helper3(String s) {
        if(s.length() == 0) return false;
        int i = 0;
        for(;i < s.length();i++) {
            if(s.charAt(i) == 'e') break;
        }
        if(i == s.length() || i == 0 || i == s.length() - 1) return false;
        return (helper2(s.substring(0,i)) || helper1(s.substring(0,i))) && helper1(s.substring(i+1,s.length()));
    }
}
