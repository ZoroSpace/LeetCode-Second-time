class Solution {
    public double myPow(double x, int n) {
        if(n == Integer.MIN_VALUE) return 1.0/(myPow(x,Integer.MAX_VALUE) * x);
        if(n < 0) return 1.0/myPow(x,-n);
        if(n == 0) return 1.0;
        double half = myPow(x,n/2);
        if(n % 2 == 0) return half * half;
        else return x * half * half;
    }
}
