class Solution {
    public boolean isScramble(String s1, String s2) {
        return helper1(s1,s2,0,s1.length() - 1,0,s1.length() - 1);
    }
    
    boolean helper1(String s1,String s2,int lo1,int hi1,int lo2,int hi2) {
        if(lo1 == hi1) return s1.charAt(lo1) == s2.charAt(lo2);
        if(s1.equals(s2)) return true;
        int[] count = new int[26];
        for(int i = lo1;i <= hi1;i++) count[s1.charAt(i) - 'a']++;
        for(int i = lo2;i <= hi2;i++) count[s2.charAt(i) - 'a']--;
        for(int i = 0;i < 26;i++) {
            if(count[i] != 0) return false;
        }
        
        for(int i = lo1;i < hi1;i++) {
            if(helper1(s1,s2,lo1,i,lo2,lo2+i-lo1) && helper1(s1,s2,i+1,hi1,hi2-hi1+i+1,hi2)) return true;
            if(helper1(s1,s2,lo1,i,hi2-(i-lo1),hi2) && helper1(s1,s2,i+1,hi1,lo2,lo2+hi1-(i+1))) return true;
        }
        return false;
    }
}
