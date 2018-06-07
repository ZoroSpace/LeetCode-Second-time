class Solution {
    public String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        path = path+"/";
        for(int i = 0;i < path.length();i++) {
            char c = path.charAt(i);
            if(c == '/') {
                String s = sb.toString();
                if(s.length() == 0 || s.equals(".")) {}
                else if(s.equals("..")) {
                    if(stack.size() != 0) stack.pollLast();
                }
                else stack.offerLast(s);
                sb = new StringBuilder("");
            } else sb.append(c);
        }
        for(String s : stack) {
            if(s.length() != 0) sb.append('/').append(s);
        }
        String ans = sb.toString();
        return ans.length() == 0 ? "/" : ans;
    }
}
