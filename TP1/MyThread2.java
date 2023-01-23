package TP1;
public class MyThread2 extends Thread{
  public MonObjet o;
  public int nbwrite;
  public MyThread2( MonObjet o,int nbwrite){
  this.o=o;
  this.nbwrite=nbwrite;
  }
  public void run(){
  for(int i=0;i<nbwrite;i++)
  {
  o.add();
  Thread.yield();
  }
  System.out.println("la thread "+ThreadID.get()+" a pour last "+o.last.get());
  }
}
// public class MyThread2 extends Thread{
//   public int nbwrite; int x;
//   public ThreadID tID;
//   public int myid;
//   public MyThread2(String name){
//   //this.nbwrite=nbwrite;
//   tID=new ThreadID();
//   myid=tID.get();
//   }
//   public void run(){
//   // tID=new ThreadID();
//   // myid=tID.get();
//   System.out.println("la thread "+tID.get() + " "+myid);
//   try{Thread.sleep(10);}
//   catch(Exception e){e.printStackTrace(); }
//   System.out.println("la thread " +tID.get() + "apres le sommeil ");
//   }
// }

// public class MyThread2 extends Thread{
//   public int nbwrite; int x;
//   public ThreadID tID;
//   public int myid;
//   public MyThread2(String name){
//   //this.nbwrite=nbwrite;
//   // tID=new ThreadID();
//   // myid=tID.get();
//   }
//   public void run(){
//   tID=new ThreadID();
//   myid=tID.get();
//   System.out.println("la thread "+tID.get() + " "+myid);
//   try{Thread.sleep(10);}
//   catch(Exception e){e.printStackTrace(); }
//   System.out.println("la thread " +tID.get() + "apres le sommeil ");
//   }
// }