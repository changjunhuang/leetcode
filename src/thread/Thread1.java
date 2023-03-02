package thread;

/**
 * 线程类，这个线程调用加锁的方法
 */
public class Thread1 implements Runnable {

    @Override
    public void run() {
//        Car car = Car.getCar();
//        try {
//            Thread.sleep(10000L);
//        } catch (Exception e) {
//            System.out.println("睡眠太久");
//        }
//        car.lock();
        System.out.println("thread 1 测试");
    }
}
