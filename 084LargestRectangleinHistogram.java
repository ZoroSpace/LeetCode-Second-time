class Solution {
    public int largestRectangleArea(int[] h) {
        int n = h.length;
        if(n == 0) return 0;
        int[] left = new int[n],right = new int[n];
        int ans = 0;
        for(int i = 0;i < n;i++) {
            int j = i;
            while(j > -1) {
                if(h[j] >= h[i]) j--;
                else {
                    left[i] = j+1;
                    break;
                }
            }
            if(j == -1) left[i] = 0;
            j = i;
            while(j < n) {
                if(h[j] >= h[i]) j++;
                else {
                    right[i] = j-1;
                    break;
                }
            }
            if(j == n) right[i] = n-1;
            ans = Math.max((right[i]-left[i]+1)*h[i],ans);
        }
        return ans;
    }
}

class Solution {
    public int largestRectangleArea(int[] h) {
        int n = h.length;
        if(n == 0) return 0;
        int[] left = new int[n],right = new int[n];
        int ans = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for(int i = 0;i < n;i++) {
            while(stack.size() != 0) {
                if(h[stack.peekLast()] >= h[i]) stack.pollLast();
                else break;
            }
            if(stack.size() == 0) left[i] = 0;
            else left[i] = stack.peekLast()+1;
            stack.offerLast(i);
        }
        stack.clear();
        for(int i = n-1;i >= 0;i--) {
            while(stack.size() != 0) {
                if(h[stack.peekLast()] >= h[i]) stack.pollLast();
                else break;
            }
            if(stack.size() == 0) right[i] = n-1;
            else right[i] = stack.peekLast()-1;
            stack.offerLast(i);
        }
        for(int i = 0;i < n;i++) {
            ans = Math.max((right[i]-left[i]+1)*h[i],ans);
        }
        return ans;
    }
}
