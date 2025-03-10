package arraylist.mid;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 *
 * @author huangchangjun
 * @date 2025-03-10
 */
public class 合并区间 {
    public static void main(String[] args) {
        合并区间 test = new 合并区间();
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 3));
        list.add(new Interval(2, 6));
        list.add(new Interval(8, 10));
        list.add(new Interval(15, 18));
        List<Interval> result = test.merge(list);
        for (Interval interval : result) {
            System.out.println(interval.start + " " + interval.end);
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<>();

        // 对区间的 start 进行排序
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start != o2.start) {
                    return o1.start - o2.start;
                } else {
                    return o1.end - o2.end;
                }
            }
        });

        for (int i = 0; i < intervals.size(); i++) {
            Interval now = intervals.get(i);
            if (i == 0) {
                list.add(now);
            } else {
                //判断有无重叠区间（即当前区间的start小于最后一个区间的end）
                Interval last = list.getLast();
                //无重叠区间，直接加入
                if (now.start > last.end) {
                    list.add(now);
                } else {
                    //有重叠，取now的end和最后一个区间的end的较大值作为新区间的end
                    list.removeLast();
                    int newEnd = Math.max(now.end, last.end);
                    Interval newInterval = new Interval(last.start, newEnd);
                    list.add(newInterval);
                }
            }
        }
        return list;
    }

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}

