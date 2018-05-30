class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new LinkedList<>();
        if(digits.length() == 0) return ans;
        ans.add("");
        for(int i = 0;i < digits.length();i++) {
            char c = digits.charAt(i);
            String s = "";
            switch(c) {
                case '2':
                    s = "abc";
                    break;
                case '3':
                    s = "def";
                    break;
                case '4':
                    s = "ghi";
                    break;
                case '5':
                    s = "jkl";
                    break;
                case '6':
                    s = "mno";
                    break;
                case '7':
                    s = "pqrs";
                    break;
                case '8':
                    s = "tuv";
                    break;
                case '9':
                    s = "wxyz";
                    break;
            }
            List<String> old = new LinkedList<>(ans);
            ans.clear();
            for(String sb : old) {
                for(int j = 0;j < s.length();j++) {
                    ans.add(sb+s.charAt(j));
                }
            }
        }
        return ans;
    }
}
