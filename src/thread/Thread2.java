package thread;

/**
 * 这个线程调用不加锁的方法
 */
public class Thread2 extends Thread implements Runnable {
    static int total = 0;

    @Override
    public void run() {
//        for (int i = 0; i < 1000; i++) {
//            Car car = Car.getCar();
//            car.unlock();
//            System.out.println(total++);
//        }
        try {
            sleep(10000);

        } catch (Exception e) {

        }
        System.out.println("thread 2 测试");
    }
}
