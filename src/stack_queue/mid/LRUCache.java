package stack_queue.mid;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * LRU最近最久未使用缓存
 */
public class LRUCache {

    Map<Integer, Integer> map;  //记录数据的
    Queue<Integer> queue;       //记录最近最久未使用的顺序
    int size;                   //设计缓存大小

    public LRUCache(int capacity) {
        queue = new LinkedBlockingQueue<>();
        map = new HashMap<>(capacity);
        size = capacity;
    }

    public int get(int key) {
        if (!queue.contains(key)) {
            return -1;
        }
        queue.remove(key);     //排序顺序
        queue.add(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if (queue.contains(key)) {
            queue.remove(key);     //删除相应节点
        } else {
            if (queue.size() == size) {     //队列缓存满，删除头节点，最久未使用的
                int count = queue.poll();
                map.remove(count);
            }
        }
        queue.add(key);     //新增 加入 的节点
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */