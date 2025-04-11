package thread.mid;

/**
 * 1115. 交替打印 FooBar
 *
 * @author huangchangjun
 * @date 2025-04-11
 */
public class 交替打印FooBar {
    private int n;
    private String lock = "lock";
    private volatile boolean  flag = true;

    public 交替打印FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                if (!flag) {
                    lock.wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag = false;
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                if (flag) {
                    lock.wait();
                }

                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag = true;
                lock.notifyAll();
            }
        }
    }
}
