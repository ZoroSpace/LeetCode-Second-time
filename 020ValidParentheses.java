class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for(int i = 0;i < s.length();i++) {
            switch(s.charAt(i)) {
                case '(' :
                    stack.offerLast('(');
                    break;
                case ')' :
                    if(stack.size() != 0 && stack.peekLast() == '(') stack.pollLast();
                    else stack.offerLast(')');
                    break;
                case '[' :
                    stack.offerLast('[');
                    break;
                case ']' :
                    if(stack.size() != 0 && stack.peekLast() == '[') stack.pollLast();
                    else stack.offerLast(']');
                    break;
                case '{' :
                    stack.offerLast('{');
                    break;
                case '}' :
                    if(stack.size() != 0 && stack.peekLast() == '{') stack.pollLast();
                    else stack.offerLast('}');
                    break;
            }
        }
        return stack.size() == 0;
    }
}
