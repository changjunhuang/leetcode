package thread;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * 测试.class锁对象线程，会不会对其他方法产生影响
 */
public class ThreadTest {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();

        Long start = System.currentTimeMillis();
        try {
            System.out.println("线程测试开始，开始时间 = " +start);
            thread2.start();
            thread1.run();
            thread2.join();

            Long end = System.currentTimeMillis();
            System.out.println("线程测试结束，结束时间 = " + end);
            System.out.println("总耗时 = " + (end - start));
        } catch (Exception e) {

        }
    }
}
