class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        LinkedList<String> ans = new LinkedList<>();
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        boolean[][] visited = new boolean[s.length()+1][s.length()+1];
        for(int i = 1;i <= s.length();i++) {
            HashSet<Integer> set = new HashSet<>();
            for(String s1 : wordDict) {
                if(i-s1.length() >= 0 && wordDict.contains(s.substring(i-s1.length(),i))) {
                    set.add(i-s1.length());
                    visited[i][i-s1.length()] = true;
                }
            }
            map.put(i,set);
        }
        
        if(helper1(map,s.length(),visited)) helper2(ans,"",s.length(),map,s);
        return ans;
    }
    boolean helper1(HashMap<Integer,HashSet<Integer>> map,int index,boolean[][] visited) {
        if(index == 0) return true;
        HashSet<Integer> set = map.get(index);
        for(int i : set) {
            if(visited[index][i]) {
                visited[index][i] = false;
                if(helper1(map,i,visited)) return true;
            }
        }
        return false;
    }
    void helper2(LinkedList<String> ans,String path,int index,HashMap<Integer,HashSet<Integer>> map,String s) {
        if(index == 0) {
            ans.add(path.substring(1,path.length()));
            return;
        }
        HashSet<Integer> set = map.get(index);
        for(int i : set) {
            helper2(ans," "+s.substring(i,index) + path,i,map,s);
        }
    }
}

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        LinkedList<String> ans = new LinkedList<>();
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        boolean[][] visited = new boolean[s.length()+1][s.length()+1];
        for(int i = 1;i <= s.length();i++) {
            HashSet<Integer> set = new HashSet<>();
            for(int j = 0;j < i;j++) {
                if(wordDict.contains(s.substring(j,i))) {
                    set.add(j);
                    visited[i][j] = true;
                }
            }
            map.put(i,set);
        }
        
        if(helper1(map,s.length(),visited)) helper2(ans,"",s.length(),map,s);
        return ans;
    }
    boolean helper1(HashMap<Integer,HashSet<Integer>> map,int index,boolean[][] visited) {
        if(index == 0) return true;
        HashSet<Integer> set = map.get(index);
        for(int i : set) {
            if(visited[index][i]) {
                visited[index][i] = false;
                if(helper1(map,i,visited)) return true;
            }
        }
        return false;
    }
    void helper2(LinkedList<String> ans,String path,int index,HashMap<Integer,HashSet<Integer>> map,String s) {
        if(index == 0) {
            ans.add(path.substring(1,path.length()));
            return;
        }
        HashSet<Integer> set = map.get(index);
        for(int i : set) {
            helper2(ans," "+s.substring(i,index) + path,i,map,s);
        }
    }
}

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        LinkedList<String> ans = new LinkedList<>();
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[n] = true;
        for(int i = n;i > 0;i--) {
            for(int j = 0;j < i;j++) {
                if(dp[i] && wordDict.contains(s.substring(j,i))) dp[j] = true;
            }
        }
        if(!dp[0]) return ans;
        
        for(int i = 1;i <= s.length();i++) {
            HashSet<Integer> set = new HashSet<>();
            for(int j = 0;j < i;j++) {
                if(wordDict.contains(s.substring(j,i))) {
                    set.add(j);
                }
            }
            map.put(i,set);
        }

        helper2(ans,"",s.length(),map,s);
        return ans;
    }

    void helper2(LinkedList<String> ans,String path,int index,HashMap<Integer,HashSet<Integer>> map,String s) {
        if(index == 0) {
            ans.add(path.substring(1,path.length()));
            return;
        }
        HashSet<Integer> set = map.get(index);
        for(int i : set) {
            helper2(ans," "+s.substring(i,index) + path,i,map,s);
        }
    }
}
