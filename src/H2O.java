import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author by zling
 * @classname H2O
 * @description TODO
 * @date 2021/2/4 17:01
 */
public class H2O {

    public H2O() {

    }
    private Semaphore sh = new Semaphore(2);
    private Semaphore so = new Semaphore(0);

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        sh.acquire();
        releaseHydrogen.run();
        so.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        so.acquire(2);
        releaseOxygen.run();
        sh.release(2);
    }


    public static void main(String[] args) {

        int n = 42;
        H2O h2O = new H2O();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Runnable runnableH = () -> System.out.println("H");
        Runnable runnableO = () -> System.out.println("O");
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        for(int i = 0; i < n; ++i) {
            if(i % 3 == 0) {
                executorService.submit(() -> {
                    try {
                        countDownLatch.await();
                        h2O.hydrogen(runnableH);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            } else {
                executorService.submit(() -> {
                    try {
                        countDownLatch.await();
                        h2O.oxygen(runnableO);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }
        countDownLatch.countDown();
    }
}
