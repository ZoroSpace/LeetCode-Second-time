class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new LinkedList<>();
        if(s.length() == 0) return ans;
        helper(ans,"",s,0,0);
        return ans;
    }
    void helper(List<String> ans,String path,String s,int start,int level) {
        if(level == 4) {
            if(start == s.length()) ans.add(new String(path.substring(0,path.length()-1)));
            return;
        }
        for(int i = start+1;i <= s.length() && i <= start+3;i++) {
            String add = s.substring(start,i);
            if(add.charAt(0) == '0' && add.length() > 1) continue;
            if(Integer.valueOf(add) < 256) {
                helper(ans,path+add+".",s,i,level+1);
            }
        }
    }
}
