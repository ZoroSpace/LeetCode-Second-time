/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        HashMap<UndirectedGraphNode,Integer> map1 = new HashMap<>();
        HashMap<Integer,UndirectedGraphNode> map3 = new HashMap<>();
        int counter = 0;
        LinkedList<UndirectedGraphNode> q = new LinkedList<>();
        q.offerLast(node);
        while(q.size() != 0) {
            int size = q.size();
            for(int i = 0;i < size;i++) {
                UndirectedGraphNode u = q.pollFirst();
                if(!map1.containsKey(u)) {
                    map1.put(u,counter);
                    map3.put(counter,new UndirectedGraphNode(u.label));
                    counter++;
                    List<UndirectedGraphNode> list = u.neighbors;
                    for(UndirectedGraphNode n : list) q.offerLast(n);
                }
            }
        }
        for(UndirectedGraphNode n : map1.keySet()) {
            ArrayList<UndirectedGraphNode> list = new ArrayList<>();
            for(UndirectedGraphNode u : n.neighbors) {
                list.add(map3.get(map1.get(u)));
            }
            
            map3.get(map1.get(n)).neighbors = list; 
        }
        return map3.get(map1.get(node));
        
    }
}
