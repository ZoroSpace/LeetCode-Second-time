class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //2-end bfs
        LinkedList<Integer> one = new LinkedList<>();
        LinkedList<Integer> two = new LinkedList<>();
        one.offerLast(0);//记录下一个单词的起始位置，正向
        two.offerLast(s.length()-1);//记录下一个单词的起始位置，逆向
        
        while(one.size() != 0 && two.size() != 0) {
            int min = s.length();
            int max = -1;
            for(int i : one) min = Math.min(min,i);
            for(int j : two) max = Math.max(max,j);
            for(int i : one) {
                for(int j : two) {
                    if(i == j+1) return true;
                }
            }
            int size = one.size();
            for(int i = 0;i < size;i++) {
                int start = one.pollFirst();
                for(String string : wordDict) {
                    if(max < start+string.length()-1) continue;
                    if(string.equals(s.substring(start,start+string.length()))) {
                        one.offerLast(start+string.length());
                    }
                }
            }
            for(int i : one) {
                for(int j : two) {
                    if(i == j+1) return true;
                }
            }
            size = two.size();
            for(int i = 0;i < size;i++) {
                int start = two.pollFirst();
                for(String string : wordDict) {
                    if(min > start-string.length()+1) continue;
                    if(string.equals(s.substring(start-string.length()+1,start+1))) {
                        two.offerLast(start-string.length());
                    }
                }
            }
        }
        return false;
    }
}
