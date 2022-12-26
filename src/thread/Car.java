package thread;


/**
 * 单例测试类
 */
public class Car {

    private static volatile Car car = null;
    private static Object object = new Object();
    private Car() {
    }

    public static Car getCar() {
        if (car == null) {
            synchronized (Car.class) {
                if (car == null) {
                    car = new Car();
                }
            }
        }
        return car;
    }


    public void unlock() {
        System.out.println("这是一个没有加锁的方法");
    }

    public void lock() {
        synchronized (object) {
            System.out.println("这是一个了加锁的方法");
        }
    }
}
