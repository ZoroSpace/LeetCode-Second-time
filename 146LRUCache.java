class LRUCache {
    HashMap<Integer,Integer> left = new HashMap<>();
    HashMap<Integer,Integer> right = new HashMap<>();
    HashMap<Integer,Integer> self = new HashMap<>();
    int capacity;
    int cur = 0;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        left.put(Integer.MAX_VALUE,Integer.MAX_VALUE);
        right.put(Integer.MAX_VALUE,Integer.MAX_VALUE);
    }
    
    public int get(int key) {
        if(self.containsKey(key)) {
            //更新
            int leftone = left.get(key);
            int rightone = right.get(key);
            left.put(rightone,leftone);
            right.put(leftone,rightone);
            
            leftone = Integer.MAX_VALUE;
            rightone = right.get(leftone);
            
            right.put(key,rightone);
            left.put(rightone,key);
            
            right.put(leftone,key);
            left.put(key,leftone);
            
            return self.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        
        int leftone,rightone;
        if(self.containsKey(key)) {
            leftone = left.get(key);
            rightone = right.get(key);
            left.put(rightone,leftone);
            right.put(leftone,rightone);
        } else cur++;
        
        leftone = Integer.MAX_VALUE;
        rightone = right.get(leftone);
        
        right.put(key,rightone);
        left.put(rightone,key);

        right.put(leftone,key);
        left.put(key,leftone);
        if(cur > capacity) {
            //移除最后一位
            int mid = left.get(Integer.MAX_VALUE);
            leftone = left.get(mid);
            rightone = right.get(mid);
            left.put(rightone,leftone);
            right.put(leftone,rightone);
            left.remove(mid);
            right.remove(mid);
            self.remove(mid);
            cur--;
        }
        
        self.put(key,value);
        //更新
        //并移除最后一位
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
