class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<>();
        for(int i = 0;i < 9;i++) {
            for(int j = 0;j < 9;j++) {
                if(board[i][j] != '.') {
                    if(set.contains(board[i][j])) return false;
                    else set.add(board[i][j]);
                }
            }
            set.clear();
        }
        for(int i = 0;i < 9;i++) {
            for(int j = 0;j < 9;j++) {
                if(board[j][i] != '.') {
                    if(set.contains(board[j][i])) return false;
                    else set.add(board[j][i]);
                }
            }
            set.clear();
        }
        for(int i = 0;i < 3;i++) {
            for(int j = 0;j < 3;j++) {
                for(int ii = i * 3;ii < 3*i+3;ii++) {
                    for(int jj = j * 3;jj < 3*j+3;jj++) {
                        if(board[ii][jj] != '.') {
                            if(set.contains(board[ii][jj])) return false;
                            else set.add(board[ii][jj]);
                        }
                    }
                }
                set.clear();
            }
        }
        
        
        return true;
    }
}
