package thread.mid;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 1116. 打印零与奇偶数
 *
 * @author huangchangjun
 * @date 2025-04-11
 */
public class 打印零与奇偶数 {
    private int n;
    Semaphore[] semaphores = new Semaphore[3];

    public 打印零与奇偶数(int n) {
        this.n = n;
        semaphores[0] = new Semaphore(1);
        semaphores[1] = new Semaphore(0);
        semaphores[2] = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            semaphores[0].acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                semaphores[1].release();
            } else {
                semaphores[2].release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i = i + 2) {
            semaphores[1].acquire();
            printNumber.accept(i);
            semaphores[0].release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i = i + 2) {
            semaphores[2].acquire();
            printNumber.accept(i);
            semaphores[0].release();
        }
    }
}
