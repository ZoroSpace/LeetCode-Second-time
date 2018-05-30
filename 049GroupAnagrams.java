class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String k = String.valueOf(c);
            if(!map.containsKey(k)) map.put(k,new LinkedList<String>());
            map.get(k).add(s);
        }
        return new LinkedList<List<String>>(map.values());
    }
}
