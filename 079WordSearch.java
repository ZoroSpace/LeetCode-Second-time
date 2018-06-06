class Solution {
    public boolean exist(char[][] board, String word) {
        //不能穿墙
        if(word.length() == 0) return false;
        if(board.length == 0 || board[0].length == 0) return false;
        int m = board.length,n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(helper(board,word,0,visited,i,j)) return true;
            }
        }
        return false;
    }
    
    boolean helper(char[][] board,String word,int index,boolean[][] visited,int row,int col) {
        if(word.charAt(index) == board[row][col]) index++;
        else return false;
        if(index == word.length()) return true;
        visited[row][col] = true;
        if(row > 0 && !visited[row-1][col]) {
            if(helper(board,word,index,visited,row-1,col)) return true;
        }
        if(row < board.length - 1 && !visited[row+1][col]) {
            if(helper(board,word,index,visited,row+1,col)) return true;
        }
        if(col > 0 && !visited[row][col-1]) {
            if(helper(board,word,index,visited,row,col-1)) return true;
        }
        if(col < board[0].length - 1 && !visited[row][col+1]) {
            if(helper(board,word,index,visited,row,col+1)) return true;
        }
        visited[row][col] = false;
        return false;
    }
}
