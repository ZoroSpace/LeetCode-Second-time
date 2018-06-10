class Solution {
    public void solveSudoku(char[][] board) {
        helper(board,0);
    }
    
    boolean helper(char[][] board,int i) {
        while(i < 81 && board[i/9][i%9] != '.') i++;
        if(i == 81) return true;
        for(int j = 1;j <= 9;j++) {
            if(isValidSudoku(board,i/9,i%9,(char)('0'+j))) {
                board[i/9][i%9] = (char)('0'+j);
                if(helper(board,i+1)) return true;
                else board[i/9][i%9] = '.';
            }
        }
        return false;
    }
    boolean isValidSudoku(char[][] board, int row, int col, char c){
    for(int i = 0; i < 9; i++) {
        if(board[i][col] != '.' && board[i][col] == c) return false; //check row
        if(board[row][i] != '.' && board[row][i] == c) return false; //check column
        if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' && 
board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
    }
    return true;
    }
}


class Solution {
    public void solveSudoku(char[][] board) {
        helper(board,0);
    }
    
    boolean helper(char[][] board,int i) {
        while(i < 81 && board[i/9][i%9] != '.') i++;
        if(i == 81) return true;
        for(int j = 1;j <= 9;j++) {
            board[i/9][i%9] = (char)('0'+j);
            if(isValidSudoku(board)&&(helper(board,i+1))) return true;
            else {
                board[i/9][i%9] = '.';
            }
        }
        return false;
    }
    boolean isValidSudoku(char[][] board) {
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

