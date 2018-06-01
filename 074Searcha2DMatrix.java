class Solution {
    public boolean searchMatrix(int[][] a, int target) {
        if(a.length == 0 || a[0].length == 0) return false;
        int m = a.length,n = a[0].length;
        if(a[0][0] > target || a[m-1][n-1] < target) return false;
        int lo = 0,hi = m*n-1;
        while(lo <= hi) {
            int mid = (lo+hi)/2;
            int r = mid/n,c = mid%n;
            if(a[r][c] == target) return true;
            else if(a[r][c] > target) hi = mid-1;
            else lo = mid+1;
        }
        return false;
    }
}
