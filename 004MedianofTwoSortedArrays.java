class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length,n = nums2.length;
        if(m == 0 && n == 0) return 0;
        if(m == 0) return helper1(nums2,0,n-1);
        if(n == 0) return helper1(nums1,0,m-1);
        return helper2(nums1,0,m-1,nums2,0,n-1);
    }
    
    double helper1(int[] nums,int lo,int hi) {
        if((hi-lo) % 2 == 0) {
            //奇数个
            return nums[lo+(hi-lo)/2];
        } else {
            //偶数个
            return (nums[lo+(hi-lo)/2] + nums[lo+(hi-lo)/2+1])/2.0;
        }
    }
    
    double helper2(int[] nums1,int lo1,int hi1,int[] nums2,int lo2,int hi2) {
        if(nums1[lo1] >= nums2[hi2]) {
            if(hi1-lo1==hi2-lo2) {
                return (nums2[hi2]+nums1[lo1])/2.0;
            } else if(hi1-lo1>hi2-lo2) {
                return helper1(nums1,lo2+lo1-1-hi2,hi1);
            } else {
                return helper1(nums2,lo2,hi1-lo1+hi2+1);
            }
        } else if(nums1[hi1] <= nums2[lo2]){
            if(hi1-lo1==hi2-lo2) {
                return (nums2[lo2]+nums1[hi1])/2.0;
            } else if(hi1-lo1>hi2-lo2) {
                return helper1(nums1,lo1,hi1+hi2-lo2+1);
            } else {
                return helper1(nums2,lo1+lo2-1-hi1,hi2);
            }
        } else {
            double n1 = helper1(nums1,lo1,hi1);
            double n2 = helper1(nums2,lo2,hi2);
            if(n1 == n2) return n1;
            if(hi1 == lo1 && hi2 == lo2) return (nums1[lo1]+nums2[lo2])/2.0;
            if(hi1 == lo1) {
                if((hi2-lo2)%2==0) {
                    if(n1 > n2) return (n2+Math.min(n1,nums2[lo2+(hi2-lo2)/2+1]))/2.0;
                    else return (n2+Math.max(n1,nums2[lo2+(hi2-lo2)/2-1]))/2.0;
                } else {
                    if(n1 <= nums2[lo2+(hi2-lo2)/2]) return nums2[lo2+(hi2-lo2)/2];
                    else if(n1 >= nums2[lo2+(hi2-lo2)/2+1]) return nums2[lo2+(hi2-lo2)/2+1];
                    else return n1;
                }
            } else if(hi2 == lo2) {
                if((hi1-lo1)%2==0) {
                    if(n1 < n2) return (n1+Math.min(n2,nums1[lo1+(hi1-lo1)/2+1]))/2.0;
                    else return (n1+Math.max(n2,nums1[lo1+(hi1-lo1)/2-1]))/2.0;
                } else {
                    if(n2 <= nums1[lo1+(hi1-lo1)/2]) return nums1[lo1+(hi1-lo1)/2];
                    else if(n2 >= nums1[lo1+(hi1-lo1)/2+1]) return nums1[lo1+(hi1-lo1)/2+1];
                    else return n2;
                }
            } else {
                int mincut1 = (hi1-lo1)%2 != 0?(hi1-lo1)/2+1:(hi1-lo1)/2;
                int mincut2 = (hi2-lo2)%2 != 0?(hi2-lo2)/2+1:(hi2-lo2)/2;
                int mincut = Math.min(mincut1,mincut2);
                if(n1 > n2) return helper2(nums1,lo1,hi1-mincut,nums2,lo2+mincut,hi2);
                else return helper2(nums1,lo1+mincut,hi1,nums2,lo2,hi2-mincut);
            }
        }
    }
}


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length,n = nums2.length;
        if(m == 0 && n == 0) return 0;
        if(m == 0) return helper1(nums2,0,n-1);
        if(n == 0) return helper1(nums1,0,m-1);
        return helper2(nums1,0,m-1,nums2,0,n-1);
    }
    
    double helper1(int[] nums,int lo,int hi) {
        if((hi-lo) % 2 == 0) {
            //奇数个
            return nums[lo+(hi-lo)/2];
        } else {
            //偶数个
            return (nums[lo+(hi-lo)/2] + nums[lo+(hi-lo)/2+1])/2.0;
        }
    }
    
    double helper2(int[] nums1,int lo1,int hi1,int[] nums2,int lo2,int hi2) {
        if(nums1[lo1] >= nums2[hi2]) {
            if(hi1-lo1==hi2-lo2) {
                return (nums2[hi2]+nums1[lo1])/2.0;
            } else if(hi1-lo1>hi2-lo2) {
                return helper1(nums1,lo2+lo1-1-hi2,hi1);
            } else {
                return helper1(nums2,lo2,hi1-lo1+hi2+1);
            }
        } else if(nums1[hi1] <= nums2[lo2]){
            if(hi1-lo1==hi2-lo2) {
                return (nums2[lo2]+nums1[hi1])/2.0;
            } else if(hi1-lo1>hi2-lo2) {
                return helper1(nums1,lo1,hi1+hi2-lo2+1);
            } else {
                return helper1(nums2,lo1+lo2-1-hi1,hi2);
            }
        } else {
            double n1 = helper1(nums1,lo1,hi1);
            double n2 = helper1(nums2,lo2,hi2);
            // if(n1 == n2) return n1;
            if(hi1 == lo1 && hi2 == lo2) return (nums1[lo1]+nums2[lo2])/2.0;
            if(hi1 == lo1) {
                if((hi2-lo2)%2==0) {
                    if(n1 > n2) return (n2+Math.min(n1,nums2[lo2+(hi2-lo2)/2+1]))/2.0;
                    else return (n2+Math.max(n1,nums2[lo2+(hi2-lo2)/2-1]))/2.0;
                } else {
                    if(n1 <= nums2[lo2+(hi2-lo2)/2]) return nums2[lo2+(hi2-lo2)/2];
                    else if(n1 >= nums2[lo2+(hi2-lo2)/2+1]) return nums2[lo2+(hi2-lo2)/2+1];
                    else return n1;
                }
            } else if(hi2 == lo2) {
                if((hi1-lo1)%2==0) {
                    if(n1 < n2) return (n1+Math.min(n2,nums1[lo1+(hi1-lo1)/2+1]))/2.0;
                    else return (n1+Math.max(n2,nums1[lo1+(hi1-lo1)/2-1]))/2.0;
                } else {
                    if(n2 <= nums1[lo1+(hi1-lo1)/2]) return nums1[lo1+(hi1-lo1)/2];
                    else if(n2 >= nums1[lo1+(hi1-lo1)/2+1]) return nums1[lo1+(hi1-lo1)/2+1];
                    else return n2;
                }
            } else if(hi1-lo1 == 1 && hi2-lo2 == 1) {
                int[] so = new int[4];
                so[0] = nums1[lo1];
                so[1] = nums1[hi1];
                so[2] = nums2[lo2];
                so[3] = nums2[hi2];
                Arrays.sort(so);
                return (so[1]+so[2])/2.0;
            }else if(hi1-lo1 == 1 && ((hi2-lo2)%2 != 0) && (n1 < nums2[lo2+(hi2-lo2)/2+1] && nums2[lo2+(hi2-lo2)/2] < n1)) {
                return n1;
            } else if(hi2-lo2 == 1 && ((hi1-lo1)%2 != 0) && (n2 < nums1[lo1+(hi1-lo1)/2+1] && nums1[lo1+(hi1-lo1)/2] < n2)) {
                return n2;
            } else {
                int mincut1 = (hi1-lo1)%2 != 0?(hi1-lo1)/2+1:(hi1-lo1)/2;//偶数在前面
                int mincut2 = (hi2-lo2)%2 != 0?(hi2-lo2)/2+1:(hi2-lo2)/2;
                int mincut = Math.max(1,Math.min(mincut1,mincut2)-1);
                mincut = 1;
                if(n1 > n2) return helper2(nums1,lo1,hi1-mincut,nums2,lo2+mincut,hi2);
                else return helper2(nums1,lo1+mincut,hi1,nums2,lo2,hi2-mincut);
            }
        }
    }
}
