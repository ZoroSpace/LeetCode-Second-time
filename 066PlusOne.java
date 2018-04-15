class Solution {
    public int[] plusOne(int[] digits) {
        int c = 1;
        for(int i = digits.length - 1;i >= 0;i--) {
            digits[i] = digits[i] + c;
            if(digits[i] == 10) {
                digits[i] = 0;
                c = 1;
            } else return digits;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        System.arraycopy(digits,0,result,1,digits.length);
        return result;
    }
}
