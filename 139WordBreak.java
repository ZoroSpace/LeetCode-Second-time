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


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        int n = s.length();
        boolean[][] visited = new boolean[n+1][n+1];
        for(int i = 1;i <= n;i++) {
            HashSet<Integer> set = new HashSet<>();
            for(String s1 : wordDict) {
                if(i-s1.length() >= 0 && s.substring(i-s1.length(),i).equals(s1)) {
                    set.add(i-s1.length());
                    visited[i][i-s1.length()] = true;
                }
            }
            map.put(i,set);
        }
        return helper(map,s.length(),visited);
    }
    
    boolean helper(HashMap<Integer,HashSet<Integer>> map,int index,boolean[][] visited) {
        HashSet<Integer> set = map.get(index);
        if(set.contains(0)) return true;
        for(int i : set) {
            if(visited[index][i]) {
                visited[index][i] = false;
                if(helper(map,i,visited)) return true;
            }
        }
        return false;
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[n] = true;
        for(int i = n;i > 0;i--) {
            for(int j = 0;j < i;j++) {
                if(dp[i] && wordDict.contains(s.substring(j,i))) dp[j] = true;
            }
        }
        return dp[0];
    }
}
