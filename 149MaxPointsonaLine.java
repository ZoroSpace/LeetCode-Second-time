/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    class Divide {
        int a;//a/b 真分数 辗转相除法
        int b;//
        Divide(int a,int b) {
            this.a = a;
            this.b = b;
        }
    }
    public int maxPoints(Point[] points) {
        int n = points.length;
        if(n <= 2) return n;
        int ans = 1;
        for(int i = 0;i < n;i++) {
            ArrayList<Divide> list = new ArrayList<>();
            int counter = 1;
            for(int j = 0;j < n;j++) {
                if(i == j) continue;
                int dx = points[i].x - points[j].x;
                int dy = points[i].y - points[j].y;
                if(dx == 0 && dy == 0) counter++;
                else if(dx == 0) list.add(new Divide(0,1));
                else if(dy == 0) list.add(new Divide(1,0));
                else {
                    if(dx < 0) {
                        dx = -dx;
                        dy = -dy;
                    }
                    list.add(helper(dy,dx));
                }
            }
            Collections.sort(list,new Comparator<Divide>() {
                public int compare(Divide d1,Divide d2) {
                    if(d1.a < d2.a) return -1;
                    if(d1.a > d2.a) return 1;
                    if(d1.b > d2.b) return 1;
                    return 0;
                }
            });
            
            if(counter < points.length) {
                counter++;
                int a = list.get(0).a;
                int b = list.get(0).b;
                for(int j = 1;j < list.size();j++) {
                    if(list.get(j).a == a && list.get(j).b == b) counter++;
                    else {
                        a = list.get(j).a;
                        b = list.get(j).b;
                        counter = 2;
                    }
                    ans = Math.max(counter,ans);
                }
            } else ans = Math.max(counter,ans);
        }
        return ans;
            
        
        
    }
    Divide helper(int dy,int dx) {
        
        int y = Math.abs(dy);
        int x = Math.abs(dx);
        int c = y > x?gcd(y,x):gcd(x,y);
        return new Divide(dy/c,dx/c);
    }
    
    int gcd(int y,int x) {
        // y > x
        // 辗转相除法
        return y%x == 0 ? x : gcd(x,y%x);
    }
}
