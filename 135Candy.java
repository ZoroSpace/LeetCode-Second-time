class Solution {
    public int candy(int[] r) {
        int n = r.length;
        if(n == 0) return 0;
        if(n == 1) return 1;
        int[] can = new int[n];
        for(int i = 0;i < n;i++) {
            if(i == 0) {
                if(r[i] <= r[i+1]) can[i] = 1;
            } else if(i == n-1) {
                if(r[i] <= r[i-1]) can[i] = 1;
            } else {
                if(r[i] <= r[i+1] && r[i] <= r[i-1]) can[i] = 1;
            }
        }
        for(int i = 1;i < n;i++) {
            if(r[i] > r[i-1]) can[i] = can[i-1]+1;
        }
        for(int i = n-2;i >= 0;i--) {
            if(r[i] > r[i+1]) can[i] = Math.max(can[i],can[i+1]+1);
        }
        int ans = 0;
        for(int i = 0;i < n;i++) {
            if(can[i] == 0) can[i] = 1;
            ans = ans+can[i];
        }
        return ans;
    }
}
