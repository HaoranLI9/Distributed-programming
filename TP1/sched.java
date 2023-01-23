package TP1;

public class sched extends Thread{
  resultat res=new resultat(5);
  public sched( resultat t){res=t;}
  public void echange( int i,int j){
  int tmp=res.tab[i];
  res.tab[i]=res.tab[j];
  res.tab[j]=tmp;};
  public void run (){
  for ( int k=0; k<10000 ; k++){
  int a= (int)(Math.random()*5);
  int b= (int)(Math.random()*5);
  echange ( a,b);
  }
  }
  public static void main(String[] args) {
  resultat t=new resultat(5); int i=0;int k;
  for(k=0;k<5;k++) t.tab[k]=k;
  for( k=0;k<5;k++) System.out.print(t.tab[k]);
  System.out.println();
  Thread th1=new sched(t); th1.start();
  Thread th2=new sched(t); th2.start();
  Thread th3=new sched(t); th3.start();
  try{th1.join();th2.join();th3.join();}
  catch(Exception e){e.printStackTrace();};
  for(k=0;k<5;k++) System.out.print(t.tab[k] );
  }
}