class Solution {
    public int maximalRectangle(char[][] a) {
        if(a.length == 0 || a[0].length == 0) return 0;
        int m = a.length,n = a[0].length;
        int[] h = new int[n],left = new int[n],right = new int[n];
        LinkedList<Integer> stack = new LinkedList<>();
        int ans = 0;
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(a[i][j] == '0') h[j] = 0;
                else h[j]++;
            }
            stack.clear();
            for(int j = 0;j < n;j++) {
                while(stack.size() != 0) {
                    if(h[stack.peekLast()] >= h[j]) stack.pollLast();
                    else break;
                }
                if(stack.size() == 0) left[j] = 0;
                else left[j] = stack.peekLast()+1;
                stack.offerLast(j);
            }
            stack.clear();
            for(int j = n-1;j >= 0;j--) {
                while(stack.size() != 0) {
                    if(h[stack.peekLast()] >= h[j]) stack.pollLast();
                    else break;
                }
                if(stack.size() == 0) right[j] = n-1;
                else right[j] = stack.peekLast()-1;
                stack.offerLast(j);
            }
            for(int j = 0;j < n;j++) ans = Math.max(ans,(right[j]-left[j]+1)*h[j]);
        }
        return ans;
    }
}
