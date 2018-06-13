class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        LinkedList<Integer> stack = new LinkedList<>();
        for(int i = 0;i < n;i++) {
            if(s.charAt(i) == '(') {
                stack.offerLast(i);
                dp[i] = i;
            } else {
                if(stack.size() != 0 && s.charAt(stack.peekLast()) == '(') {
                    dp[i] = stack.pollLast();
                } else {
                    stack.offerLast(i);
                    dp[i] = i;
                }
            }
        }
        int hi = n-1;
        int ans = 0,cur = 0;
        while(hi >= 0) {
            if(dp[hi] == hi) {
                
                cur = 0;
                hi--;
                continue;
            }
            cur = cur + hi - dp[hi]+1;
            ans = Math.max(ans,cur);
            hi = dp[hi] - 1;
        }
        return ans;
    }
}
