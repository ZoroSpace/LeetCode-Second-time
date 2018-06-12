/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
        LinkedList<Interval> ans = new LinkedList<>();
        boolean notadd = true;
        for(Interval inter : intervals) {
            if(inter.end < newInterval.start) ans.add(inter);
            else if(inter.start <= newInterval.end) {
                if(notadd) {
                    ans.add(newInterval);
                    notadd = false;
                }
                newInterval.start = Math.min(newInterval.start,inter.start);
                newInterval.end = Math.max(newInterval.end,inter.end);
            } else {
                if(notadd) {
                    ans.add(newInterval);
                    notadd = false;
                }
                ans.add(inter);
            }
        }
        if(notadd) ans.add(newInterval);
        return ans;
    }
}
