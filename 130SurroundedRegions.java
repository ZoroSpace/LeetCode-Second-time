class Solution {
    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0) return;
        int m = board.length,n = board[0].length;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i < m;i++) {
            if(board[i][0] == 'O') set.add(i*n);
            if(n > 1 && board[i][n-1] == 'O') set.add(i*n+n-1);
        }
        for(int i = 0;i < n;i++) {
            if(board[0][i] == 'O') set.add(i);
            if(m > 1 && board[m-1][i] == 'O') set.add((m-1) * n+i);
        }
        
        LinkedList<Integer> q = new LinkedList<>(set);
        while(q.size() != 0) {
            int size = q.size();
            for(int i = 0;i < size;i++) {
                int k = q.pollFirst();
                //判断上下左右是否有新的O，如果有，就入栈。
                int row = k / n;
                int col = k % n;
                if(!set.contains(k-n) && row > 0 && board[row-1][col] == 'O') {
                    set.add(k-n);
                    q.offerLast(k-n);
                }
                if(!set.contains(k+n) && row < m-1 && board[row+1][col] == 'O') {
                    set.add(k+n);
                    q.offerLast(k+n);
                }
                if(col > 0 && board[row][col-1] == 'O' && !set.contains(k-1)) {
                    set.add(k-1);
                    q.offerLast(k-1);
                }
                if(col < n-1 && board[row][col+1] == 'O' && !set.contains(k+1)) {
                    set.add(k+1);
                    q.offerLast(k+1);
                }
            }
        }
        //针对所有set里的int，不改变board。
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(!set.contains(i*n+j) && board[i][j] != 'X') board[i][j] = 'X';
            }
        }
    }
}
