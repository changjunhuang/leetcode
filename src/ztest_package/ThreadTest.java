package ztest_package;

import java.util.ArrayList;
import java.util.List;

public class ThreadTest extends Thread {

    static int tick = 10000;
    int total = 0;
    static Object ob = "lock";
    static int num = 0;
    int currentNum = 0;

    public ThreadTest(String name) {
        super(name);
    }
    @Override
    public void run() {
        while (tick > 0) {
            synchronized (ob) {
                if (tick > 0) {
                    total++;
                    tick--;
                    currentNum++;
                    System.out.println(getName() + "卖出了" + total + ", 剩余：" + tick);
                } else {
                    System.out.println(num + " 票已售光！！");
                    num++;
                }
            }

        }
    }
}


class Main {
    public static void main(String[] args) {
        List<ThreadTest> threadTestList = new ArrayList<>();
        int threadTotal = 0;
        while (threadTotal < 100) {
            ThreadTest threadTest = new ThreadTest("第" + threadTotal + "个黄牛");
            threadTestList.add(threadTest);
            threadTotal++;
        }
        for (ThreadTest threadTest : threadTestList) {
            threadTest.start();
        }
    }
}
