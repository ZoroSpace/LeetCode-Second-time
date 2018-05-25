class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        if(haystack.length() < needle.length()) return -1;
        for(int i = 0;i < haystack.length() - needle.length() + 1;i++) {
            boolean flag = true;
            for(int j = 0;j < needle.length() && flag;j++) {
                if(haystack.charAt(i+j) != needle.charAt(j)) {
                    flag = false;
                }
            }
            if(flag) return i;
        }
        return -1;
    }
}
