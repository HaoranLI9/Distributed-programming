package TP2;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
  public static void main(String[] args) {
      int numThreads = 2;
      Lock lock = new PetersonLock();
      for (int i = 0; i < numThreads; i++) {
          new CriticalSectionThread(lock).start();
      }
  }
}