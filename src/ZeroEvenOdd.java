import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * @author by zling
 * @classname ZeroEvenOdd
 * @description TODO
 * @date 2021/2/3 09:40
 */
public class ZeroEvenOdd {

    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    private Semaphore zeroSe = new Semaphore(1);
    private Semaphore evenSe = new Semaphore(0);
    private Semaphore oddSe = new Semaphore(0);

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i = 0; i < n; i++) {
            zeroSe.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                oddSe.release();
            } else {
                evenSe.release();
            }
        }
    }

    // 偶数
    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i = 2; i <= n; i += 2) {
            evenSe.acquire();
            printNumber.accept(i);
            zeroSe.release();
        }
    }

    // 奇数
    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i <= n; i += 2) {
            oddSe.acquire();
            printNumber.accept(i);
            zeroSe.release();
        }
    }


    public static void main(String[] args) {
        int n = 20;
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);
        IntConsumer intConsumer = value -> System.out.println(value);

        Thread thread1 = new Thread(() -> {
            try {
                zeroEvenOdd.zero(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                zeroEvenOdd.odd(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread3 = new Thread(() -> {
            try {
                zeroEvenOdd.even(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();

    }



}
