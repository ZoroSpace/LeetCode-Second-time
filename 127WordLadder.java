class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        HashSet<String> wordSet = new HashSet<>(wordList);
        HashSet<String> set = new HashSet<>();
        LinkedList<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.offerLast(beginWord);
        int counter = 0;
        while(q.size() != 0) {
            counter++;
            int size = q.size();
            for(int i = 0;i < size;i++) {
                String s = q.pollFirst();
                if(s.equals(endWord)) return counter;
                for(int j = 0;j < s.length();j++) {
                    char[] chars = s.toCharArray();
                    for(char k = 'a';k <= 'z';k++) {
                        if(chars[j] == k) continue;
                        chars[j] = k;
                        String t = new String(chars);
                        if(!visited.contains(t) && wordSet.contains(t)) {
                            visited.add(t);
                            wordSet.remove(t);
                            q.offerLast(t);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
