package thread;

/**
 * @author huangchangjun
 * @date 2025-04-10
 */
public class 线程交替打印 {
    public static final String LOCK = "LOCK";
    public static boolean flag = true;

    public static void main(String[] args) {
        ThreadOne one = new ThreadOne();
        ThreadTow tow = new ThreadTow();
        one.start();
        tow.start();
    }

    static class ThreadOne extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (LOCK) {
                    if (!flag) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException();
                        }
                    }
                    System.out.println("1");
                    flag = false;
                    LOCK.notify();
                }
            }
        }
    }

    static class ThreadTow extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (LOCK) {
                    if (flag) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException();
                        }
                    }
                    System.out.println("2");
                    flag = true;
                    LOCK.notify();
                }
            }
        }
    }
}
