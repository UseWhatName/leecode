import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author by zling
 * @classname FooBar
 * @description TODO
 * @date 2021/2/2 17:57
 */
public class FooBar {

    private int n;
    public FooBar(int n) {
        this.n = n;
    }

    private Semaphore s1 = new Semaphore(1);
    private Semaphore s2 = new Semaphore(0);
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void foo(Runnable printFoo) throws InterruptedException {

        condition.await();
        for (int i = 0; i < n; i++) {
            s1.acquire();
            printFoo.run();
            s2.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            s2.acquire();
            printBar.run();
            s1.release();
        }
    }
}
