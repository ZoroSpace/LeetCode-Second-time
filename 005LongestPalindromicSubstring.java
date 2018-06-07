class Solution {
    int min,max;
    public String longestPalindrome(String s) {
        for(int i = 0;i < s.length();i++) {
            helper(i,i,s);
            helper(i,i+1,s);
        }
        return s.substring(min,max+1);
    }
    void helper(int i,int j,String s) {
        if(j == s.length()) return;
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if(j - i > max - min + 2) {
            min = i+1;
            max = j-1;
        }
    }
}
