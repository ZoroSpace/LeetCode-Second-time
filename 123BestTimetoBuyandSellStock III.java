class Solution {
    public int maxProfit(int[] p) {
        int n =p.length;
        if(n == 0) return 0;
        int ans = 0;
        int[] dp1 = new int[n];//从第0天到第i天最多可获利多少
        int[] dp2 = new int[n];//从第i天到第n-1天最多可获利多少
        dp1[0] = p[0];
        for(int i = 1;i < n;i++) dp1[i] = Math.min(dp1[i-1],p[i]);
        for(int i = 0;i < n;i++) dp1[i] = p[i] - dp1[i];
        for(int i = 1;i < n;i++) dp1[i] = Math.max(dp1[i],dp1[i-1]);
        dp2[n-1] = p[n-1];
        for(int i = n-2;i > -1;i--) dp2[i] = Math.max(p[i],dp2[i+1]);
        for(int i = 0;i < n;i++) dp2[i] = dp2[i] - p[i];
        for(int i = n-2;i > -1;i--) dp2[i] = Math.max(dp2[i],dp2[i+1]);
        for(int i = 1;i < n;i++) {
            ans = Math.max(ans,dp1[i-1]+dp2[i]);
        }
        ans = Math.max(ans,dp1[n-1]);
        ans = Math.max(ans,dp2[0]);
        return ans;
        
    }
}
