package TP2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CriticalSectionThread extends Thread {
    private Lock lock;
    private int counter = 0;
    
    public CriticalSectionThread(Lock lock) {
        this.lock = lock;
    }
    
    @Override
    public void run() {
        while (counter < 20) {
            lock.lock();
            try {
                counter++;
                System.out.println("Entered critical section: " + counter);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
