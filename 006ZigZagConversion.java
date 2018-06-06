class Solution {
    public String convert(String s, int n) {
        if(n == 1) return s;
        char[][] ch = new char[n][((s.length()/(2*n-2))+1) * (n-1)];
        int row = 0,col = 0;
        for(int i = 0;i < s.length();i++) {
            ch[row][col] = s.charAt(i);
            if((i / (n-1)) % 2 == 0) {
                row++;
            } else {
                row--;
                col++;
            }
        }
        StringBuilder ans = new StringBuilder("");
        for(int i = 0;i < ch.length;i++) {
            for(int j = 0;j < ch[0].length;j++) {
                if(ch[i][j] != '\u0000') ans.append(ch[i][j]);
            }
        }
        return ans.toString();
    }
}
