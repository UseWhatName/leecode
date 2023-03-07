import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author by zling
 * @classname Foo
 * @description TODO
 * @date 2021/2/2 17:20
 */
public class Foo {

    public Foo() {
    }

    private CountDownLatch secondtLock = new CountDownLatch(1);
    private CountDownLatch thirdLock = new CountDownLatch(1);

    public void first(Runnable printFirst) {
        printFirst.run();
        secondtLock.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        secondtLock.await();
        printSecond.run();
        thirdLock.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        thirdLock.await();
        printThird.run();
    }

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable1 = () -> System.out.println(1);
        Runnable runnable2 = () -> System.out.println(2);
        Runnable runnable3 = () -> System.out.println(3);
        Foo foo = new Foo();
        Thread thread1 = new Thread(() -> {
                foo.first(runnable1);
        });
        Thread thread2 = new Thread(() -> {
            try {
                foo.second(runnable2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread3 = new Thread(() -> {
            try {
                foo.third(runnable3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread3.start();
        thread2.start();
    }


}
