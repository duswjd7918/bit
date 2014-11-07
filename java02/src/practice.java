
public class practice {

  public static void main(String[] args) {
   Thread1 th1 = new Thread1();
   Thread2 th2 = new Thread2();
   
   th1.setPriority(10);
   th2.setPriority(1);
   System.out.println("th1의 priority: "+ th1.getPriority());
   System.out.println("th2의 priority: "+ th2.getPriority());
   
   
   th1.start(); th2.start();
  }

}

class Thread1 extends Thread{
  public void run(){
    
    for(int i=0; i<300; i++){
      System.out.print("♡");
      for(int x=0; x<10000000; x++);
    }
  }
}

class Thread2 extends Thread{
  public void run(){
    for(int i=0; i<300; i++){
      System.out.print("♥");
      for(int x=0; x<10000000; x++);
    }
    
  }
  
}