class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        LinkedList<String> line = new LinkedList<>();
        List<String> ans = new LinkedList<>();
        int counter = 0;
        for(int i = 0;i < words.length;i++) {
            line.offerLast(words[i]);
            counter = counter + words[i].length() + 1;
            if(counter - 1 > maxWidth) {
                i--;
                line.pollLast();
                
                helper1(ans,line,maxWidth);
                line.clear();
                counter = 0;
            }
            if(i == words.length - 1) {
                helper2(ans,line,maxWidth);
            }
        }
        return ans;
    }
    void helper1(List<String> ans,LinkedList<String> line,int maxWidth) {
        int m = line.size();
        for(String s : line) maxWidth = maxWidth - s.length();
        StringBuilder sb = new StringBuilder();
        sb.append(line.get(0));
        if(m == 1) {
            for(int i = 0;i < maxWidth;i++) sb.append(' ');
            ans.add(sb.toString());
        } else {
            int a = maxWidth/(m-1);
            int b = maxWidth%(m-1);
            String less = "";
            for(int i = 0;i < a;i++) less = less+" ";
            String more = less + " ";
            for(int i = 0;i < b;i++) {
                sb.append(more);
                sb.append(line.get(i+1));
            }
            for(int i = 1;i < m - b;i++) {
                sb.append(less);
                sb.append(line.get(i+b));
            }
            ans.add(sb.toString());
        }
        
    }
    void helper2(List<String> ans,LinkedList<String> line,int maxWidth) {
        StringBuilder sb = new StringBuilder();
        int counter = line.get(0).length();
        sb.append(line.get(0));
        for(int i = 1;i < line.size();i++) {
            sb.append(' ');
            sb.append(line.get(i));
            counter = counter + line.get(i).length() + 1;
        }
        for(int i = counter; i < maxWidth;i++) sb.append(' ');
        ans.add(sb.toString());
    }
}
