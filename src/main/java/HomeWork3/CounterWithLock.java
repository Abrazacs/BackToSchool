package HomeWork3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class CounterWithLock {
    private Lock lock = new ReentrantLock();
    private int value;

    public void incrementValue(){
        boolean isAcquired = lock.tryLock();
        if(isAcquired){
            try {
                value++;
            } finally {
                lock.unlock();
            }
        }

    }

    public int getValue() {
        return value;
    }
}
