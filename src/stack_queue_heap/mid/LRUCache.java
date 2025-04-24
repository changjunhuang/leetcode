package stack_queue_heap.mid;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * LRU最近最久未使用缓存
 */
public class LRUCache {

    //记录数据的
    Map<Integer, Integer> map;
    //记录最近最久未使用的顺序
    Queue<Integer> queue;
    //设计缓存大小
    int size;

    public LRUCache(int capacity) {
        queue = new LinkedBlockingQueue<>();
        map = new HashMap<>(capacity);
        size = capacity;
    }

    public int get(int key) {
        if (!queue.contains(key)) {
            return -1;
        }
        queue.remove(key);
        queue.add(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if (queue.contains(key)) {
            //删除相应节点
            queue.remove(key);
        } else {
            //队列缓存满，删除头节点，最久未使用的
            if (queue.size() == size) {
                // 弹出队头元素，返回队头的值
                int count = queue.poll();
                map.remove(count);
            }
        }
        //新增加入的节点
        queue.add(key);
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */