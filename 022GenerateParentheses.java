class Solution {
    public List<String> generateParenthesis(int n) {
        List<StringBuilder> sblist = helper(n,n,n);
        List<String> result = new LinkedList<>();
        for(StringBuilder s : sblist) {
            result.add(s.toString());
        }
        return result;
    }
    
    List<StringBuilder> helper(int n,int left,int right) {
        if(left == 0) {
            List<StringBuilder> sblist = new LinkedList<StringBuilder>();
            sblist.add(new StringBuilder(""));
            return sblist;
        }
        if(left == right) {
            List<StringBuilder> last = helper(n,left,right-1);
            for(StringBuilder s : last) s.append(')');
            return last;
        } else {
            List<StringBuilder> result = new LinkedList<>();
            if(right > 0) {
                List<StringBuilder> last1 = helper(n,left,right-1);
                for(StringBuilder s : last1) {
                    s.append(')');
                    result.add(s);
                }
            }
            List<StringBuilder> last2 = helper(n,left-1,right);
            for(StringBuilder s : last2) {
                s.append('(');
                result.add(s);
            }
            return result;
        }
    }
}
