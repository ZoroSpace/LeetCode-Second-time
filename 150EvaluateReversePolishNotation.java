class Solution {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        for(String s : tokens) {
            char c = s.charAt(0);
            if(c <= '9' && c >= '0' || s.length() > 1) {
                stack.offerLast(Integer.valueOf(s));
            } else {
                int i = stack.pollLast();
                int j = stack.pollLast();
                int k = 0;
                switch(c) {
                    case '+':
                        k = i+j;
                        break;
                    case '-':
                        k = j-i;
                        break;
                    case '*':
                        k = i*j;
                        break;
                    case '/':
                        k = j/i;
                        break;
                    default:break;
                }
                stack.offerLast(k);
            }
        }
        return stack.pollLast();
    }
}
