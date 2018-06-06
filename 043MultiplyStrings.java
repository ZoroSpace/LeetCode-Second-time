class Solution {
    public String multiply(String s1, String s2) {
        // return mul(s1,2);
        if(s1.length() == 0 || s2.length() == 0) return "";
        boolean neg = false;
        if(s1.charAt(0) == '-') {
            s1 = s1.substring(1,s1.length());
            neg = !neg;
        }
        if(s2.charAt(0) == '-') {
            s2 = s2.substring(1,s2.length());
            neg = !neg;
        }
        if(s1.length() == 1 && s1.charAt(0) == '0'||(s2.length() == 1 && s2.charAt(0) == '0'))  return "0";
        String ans = "";
        for(int i = 0;i < s2.length();i++) {
            ans = ans+"0";
            ans = add(ans,mul(s1,s2.charAt(i)-'0'));
        }
        if(neg) ans = "-" + ans;
        return ans;
    }
    String add(String s1,String s2) {
        int carry = 0;
        int cur = 0;
        String ans = "";
        while(cur < s1.length() && cur < s2.length()) {
            int c1 = s1.charAt(s1.length() - 1 - cur) - '0';
            int c2 = s2.charAt(s2.length() - 1 - cur) - '0';
            int c3 = c1 + c2;
            ans = (c3+carry)%10 + ans;
            carry = (c3+carry) / 10;
            cur++;
        }
        if(cur == s1.length()) {
            for(int i = s1.length();i < s2.length();i++) {
                int c2 = s2.charAt(s2.length() - 1 - i) - '0';
                ans = (c2+carry) % 10 + ans;
                carry = (c2+carry) / 10;
            }
        } else {
            for(int i = s2.length();i < s1.length();i++) {
                int c1 = s1.charAt(s1.length() - 1 - i) - '0';
                ans = (c1+carry) % 10 + ans;
                carry = (c1+carry) / 10;
            }
        }
        if(carry > 0) ans = carry + ans;
        return ans;
    }
    
    String mul(String s1,int c) {
        if(c == 0) return "0";
        String ans = "";
        int carry = 0;
        for(int i = s1.length() - 1;i > -1;i--) {
            int c1 = s1.charAt(i) - '0';
            int prd = c1*c;
            ans = (prd + carry) % 10 + ans;
            carry = (prd + carry) / 10;
        }
        if(carry > 0) ans = carry + ans;
        return ans;
    }
    
}
