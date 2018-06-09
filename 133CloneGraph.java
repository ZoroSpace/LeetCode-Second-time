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
        HashMap<Integer,UndirectedGraphNode> map = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        LinkedList<UndirectedGraphNode> q = new LinkedList<>();
        q.offerLast(node);
        while(q.size() != 0) {
            int size = q.size();
            for(int i = 0;i < size;i++) {
                UndirectedGraphNode n = q.pollFirst();
                if(visited.contains(n.label)) continue;
                visited.add(n.label);
                UndirectedGraphNode nn = map.containsKey(n.label)?map.get(n.label):new UndirectedGraphNode(n.label);
                map.put(n.label,nn);
                List<UndirectedGraphNode> oldneibor = n.neighbors;
                for(UndirectedGraphNode u : oldneibor) {
                    
                    q.offerLast(u);
                    UndirectedGraphNode uu = map.containsKey(u.label)?map.get(u.label):new UndirectedGraphNode(u.label);
                    nn.neighbors.add(uu);
                    map.put(uu.label,uu);
                }
            }
        }
        return map.get(node.label);
    }
}
