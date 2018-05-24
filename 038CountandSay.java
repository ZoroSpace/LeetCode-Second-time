class Solution {
    public String countAndSay(int n) {
        if(n <= 1) return "1";
        String old = countAndSay(n-1);
        int counter = 1;
        char cur = old.charAt(0);
        StringBuilder result = new StringBuilder("");
        for(int i = 0;i < old.length();i++) {
            if(i == old.length() - 1) {
                result.append(counter);
                result.append(cur);
                break;
            }
            if(old.charAt(i) == old.charAt(i+1)) {
                cur = cur;
                counter++;
            } else {
                result.append(counter);
                result.append(cur);
                cur = old.charAt(i+1);
                counter = 1;
            }
        }
        return result.toString();
    }
}
