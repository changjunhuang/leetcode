package thread;

/**
 * 测试.class锁对象线程，会不会对其他方法产生影响
 */
public class ThreadTest  {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();

        try {
            thread2.run();
            thread1.run();
        }catch (Exception e){

        }
    }
}
