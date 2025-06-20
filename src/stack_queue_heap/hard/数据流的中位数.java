package stack_queue_heap.hard;

import java.util.PriorityQueue;

/**
 * 295. 数据流的中位数
 *
 * @author huangchangjun
 * @date 2025-04-22
 */
public class 数据流的中位数 {
    PriorityQueue<Integer> queMin;
    PriorityQueue<Integer> queMax;

    public 数据流的中位数() {
        // 队头是小的
        queMin = new PriorityQueue<>((a, b) -> (b - a));
        // 队头是大的
        queMax = new PriorityQueue<>((a, b) -> (a - b));
    }

    public void addNum(int num) {
        if (queMin.isEmpty() || num <= queMin.peek()) {
            queMin.offer(num);
            if (queMax.size() + 1 < queMin.size()) {
                queMax.offer(queMin.poll());
            }
        } else {
            queMax.offer(num);
            if (queMax.size() > queMin.size()) {
                queMin.offer(queMax.poll());
            }
        }
    }

    public double findMedian() {
        if (queMin.size() > queMax.size()) {
            return queMin.peek();
        }
        return (queMin.peek() + queMax.peek()) / 2.0;
    }


}
