class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        StringBuilder result = new StringBuilder("");
        for(int i = 0;i < strs[0].length();i++) {
            for(int j = 1;j < strs.length;j++) {
                if(i == strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) return result.toString();
            }
            result.append(strs[0].charAt(i));
        }
        return result.toString();
    }
}
