class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur1 = m-1;
        int cur2 = n-1;
        int cur = m+n-1;
        while(cur1 > -1 && cur2 > -1) {
            if(nums1[cur1] > nums2[cur2]) {
                nums1[cur] = nums1[cur1];
                cur1--;
                cur--;
            } else {
                nums1[cur] = nums2[cur2];
                cur2--;
                cur--;
            }
        }
        if(cur2 == -1) return;
        else {
            for(int i = 0;i <= cur2;i++) nums1[i] = nums2[i];
            return;
        }
    }
}
