package array;

/**
 * Created by JZL on 17/4/11.
 */

/**
 * Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].

 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 1) return intervals;
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        List<Interval> rst = new LinkedList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for(Interval interval : intervals) {
            if(interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                rst.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }

        }
        rst.add(new Interval(start, end));
        return rst;
    }

    public static void main(String args[]) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        List<Interval> rst = new MergeIntervals().merge(intervals);
    }
}
