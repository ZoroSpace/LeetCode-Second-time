class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new LinkedList<>();
        helper(ans,new LinkedList<String>(),s,0);
        return ans;
    }
    void helper(List<List<String>> ans,LinkedList<String> path,String s,int start) {
        if(start == s.length()) {
            ans.add(new LinkedList<String>(path));
            return;
        }
        for(int i = start;i < s.length();i++) {
            if(isPa(s.substring(start,i+1))) {
                path.add(s.substring(start,i+1));
                helper(ans,path,s,i+1);
                path.remove(path.size()-1);
            }
        }
    }
    boolean isPa(String s) {
        for(int i = 0;i < s.length()/2;i++) {
            if(s.charAt(i) != s.charAt(s.length()-i-1)) return false;
        }
        return true;
    }
}
