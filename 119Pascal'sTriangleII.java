class Solution {
    public List<Integer> getRow(int n) {
        n = n+1;
        LinkedList<Integer> result = new LinkedList<>();
        int[] a = new int[n];
        for(int i = 0;i < n;i++) {
            for(int j = i;j >= 0;j--) {
                if(j == i || j == 0) a[j] = 1;
                else a[j] = a[j] + a[j-1];
            }
        }
        for(int i = 0;i < n;i++) result.offer(a[i]);
        return result;
    }
}
