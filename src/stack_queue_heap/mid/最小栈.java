package stack_queue_heap.mid;

import java.util.Stack;

/**
 * 155. 最小栈
 *
 * @author huangchangjun
 * @date 2025-03-29
 */
public class 最小栈 {
    /**
     * initialize your data structure here.
     */
    private Stack<Integer> s1;
    //利用辅助栈
    private Stack<Integer> s2;

    /**
     * initialize your data structure here.
     */
    public void MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
        //peek() 返回栈顶元素，但不删除它
        if (s2.isEmpty() || s2.peek() >= x) {
            //存当前最小值
            s2.push(x);
        }
    }

    public void pop() {
        // Cannot write like the following:
        // if (s2.peek() == s1.peek()) s2.pop();
        // s1.pop();
        //pop() 返回栈顶元素，并返回它
        int x = s1.pop();
        if (s2.peek() == x) {
            //如果当前栈  ，删除辅助栈栈顶元素
            s2.pop();
        }
    }

    //获取栈顶元素
    public int top() {
        return s1.peek();
    }

    //获取辅助栈中当前最小的值
    public int getMin() {
        return s2.peek();
    }
}
