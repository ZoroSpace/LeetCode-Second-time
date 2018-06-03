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
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() == 0) return intervals;
        Collections.sort(intervals,new Comparator<Interval>() {
            public int compare(Interval i1,Interval i2) {
                if(i1.start > i2.start) return 1;
                if(i1.start == i2.start)  return 0;
                else return -1;
            }
        });
        List<Interval> ans = new LinkedList<>();
        Interval path = new Interval(intervals.get(0).start,intervals.get(0).end);
        for(Interval intel : intervals) {
            if(intel.start > path.end) {
                ans.add(path);
                path = new Interval(intel.start,intel.end);;
            } else {
                path.end = Math.max(intel.end,path.end);
            }
        }
        ans.add(path);
        return ans;
    }
}
