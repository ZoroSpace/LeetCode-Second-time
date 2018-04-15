class Solution {
    public String addBinary(String a, String b) {
        if(a.length() == 0 && b.length() == 0) return "0";
        if(a.length() == 0) return b;
        if(b.length() == 0) return a;
        StringBuilder result = new StringBuilder("");
        int i = a.length() - 1;
        int j = b.length() - 1;
        int c = 0;
        while(i >= 0 && j >= 0) {
            int sum = a.charAt(i) - '0' + b.charAt(j) - '0' + c;
            i--;
            j--;
            if(sum < 2) {
                c = 0;
                result.append(sum);
            } else {
                c = 1;
                result.append(sum - 2);
            }
        }
        if(i == -1) {
            while(j >= 0) {
                int sum = b.charAt(j) - '0' + c;
                j--;
                if(sum < 2) {
                    c = 0;
                    result.append(sum);
                } else {
                    c = 1;
                    result.append(0);
                }
            }
        } else {
            while(i >= 0) {
                int sum = a.charAt(i) - '0' + c;
                i--;
                if(sum < 2) {
                    c = 0;
                    result.append(sum);
                } else {
                    c = 1;
                    result.append(0);
                }
            }
        }
        if(c == 1) result.append(1);
        return result.reverse().toString();
    }
}
