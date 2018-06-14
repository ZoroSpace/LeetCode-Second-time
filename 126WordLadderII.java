class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new LinkedList<>();
        HashSet<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return ans;
        HashSet<String> visited = new HashSet<>();
        HashSet<String> edge = new HashSet<>();
        visited.add(beginWord);
        edge.add(beginWord);
        LinkedList<String> path = new LinkedList<>();
        path.offerLast(beginWord);
        LinkedList<LinkedList<String>> q = new LinkedList<>();
        q.offerLast(path);
        while(!edge.contains(endWord) && q.size() != 0) {
            HashSet<String> edge2 = new HashSet<>();
            HashSet<String> visited2 = new HashSet<>(visited);
            int size = q.size();
            for(int j = 0;j < size;j++) {
                path = q.pollFirst();
                String s = path.peekLast();
                LinkedList<String> path2 = new LinkedList<>();;
                
                for(int i = 0;i < s.length();i++) {
                    char[] chars = s.toCharArray();
                    for(char c = 'a';c <= 'z';c++) {
                        chars[i] = c;
                        String temp = new String(chars);
                        if(wordSet.contains(temp) && !visited.contains(temp)) {
                            path2 = new LinkedList<>(path);
                            path2.offerLast(temp);
                            q.offerLast(path2);
                            edge2.add(temp);
                            visited2.add(temp);
                        }
                        if(temp.equals(endWord)) ans.add(path2);
                    }
                }
            }
            edge = edge2;
            visited = visited2;
        }
        return ans;
    }
}
