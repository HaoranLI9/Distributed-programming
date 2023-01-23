package TP2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.function.IntPredicate;

class Bakery implements Lock {
  boolean[] flag;
  int[] label;
  public Bakery(int n) {
      flag = new boolean[n];
      label = new int[n];
      for (int i = 0; i < n; i++) {
          flag[i] = false;
          label[i] = 0;
      }
  }
  public void lock() {
      int i = ThreadID.get();
      flag[i] = true;
      label[i] = max(label) + 1;
      while (exists(k -> flag[k] && (label[k] < label[i] || (label[k] == label[i] && k < i)))) {};  
  }

  public void unlock() {
      int i = ThreadID.get();
      flag[i] = false;
  }
  private int max(int[] arr) {
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < arr.length; i++) {
          max = Math.max(max, arr[i]);
      }
      return max;
  }
  private boolean exists(IntPredicate p) {
      for (int i = 0; i < flag.length; i++) {
          if (p.test(i)) {
              return true;
          }
      }
      return false;
  }
@Override
public void lockInterruptibly() throws InterruptedException {
    // TODO Auto-generated method stub
    
}
@Override
public Condition newCondition() {
    // TODO Auto-generated method stub
    return null;
}
@Override
public boolean tryLock() {
    // TODO Auto-generated method stub
    return false;
}
@Override
public boolean tryLock(long arg0, TimeUnit arg1) throws InterruptedException {
    // TODO Auto-generated method stub
    return false;
}
}