package HomeWork3;


import java.util.ArrayList;
import java.util.List;

public class CounterTest {

    public static void main(String[] args) throws InterruptedException {
        CounterWithLock counterWithLock = new CounterWithLock();
        int qtyOfThreads = 6;
        int value = 1000;
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i<qtyOfThreads; i++){
            Thread thread = new Thread(()->{
                while (counterWithLock.getValue()!=value){
                    counterWithLock.incrementValue();
                    System.out.println(Thread.currentThread().getId());
                }
            });
            threads.add(thread);
        }
        for (Thread t:threads) {
            t.start();
        }
        for (Thread t:threads) {
            t.join();
        }
        System.out.println(counterWithLock.getValue());

    }
}
