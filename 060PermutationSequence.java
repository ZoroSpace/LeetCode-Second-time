class Solution {
    public String getPermutation(int n, int k) {
        k = k-1;
        StringBuilder ans = new StringBuilder("");
        LinkedList<Integer> list = new LinkedList<>();
        int[] pow = new int[n];
        pow[0] = 1;
        for(int i = 1;i < n;i++) pow[i] = pow[i-1]*i;
        for(int i = 1;i <= n;i++) list.add(i);
        for(int i = n-1;i > -1;i--) {
            int c = k / pow[i];
            k = k % pow[i];
            ans.append(list.get(c));
            list.remove(c);
            
        }
        return ans.toString();
    }
}
