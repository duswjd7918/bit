/*   특정 명령어 블록을 쓰레드로 분리하기!!!!!!!!!!  쓰레드 만드는 방법 ★★
 * 방법  1)Thread클래스를 상속받아 만들기
 *      2)Runnable   <-요골 더 마니쎵 ~~~~   ☆★☆★☆☆
 * */

package java02.test12;


//1)Thread클래스를 상속받아 만들기
public class Test02 {
  static class MyThread extends Thread {
    //병행으로 수행할 명령어는 run()메서드에 넣는다
    @Override
    public void run(){
      for(int i=0;i<1000;i++){
       
        System.out.println("MyThread "+i);
      }
    }
  }
  
  //2.Runnable 인터페이스 구현하기
  //이 객체를 바로 실행 할 순 없고 Thread 객체를 통해 실행시킨다.
  static class MyRunnable implements Runnable {
    //병행으로 수행할 명령어는 run()메서드에 넣는다
    @Override
    public void run(){
      for(int i=0;i<1000;i++){
       
        System.out.println("runnable!: "+i);
      }
    }
  }
  
  
  

  public static void main(String[] args) {
    for(int i=0; i<1000; i++){
      double d = 3.14;
      d /= 12.56;
      
      System.out.println("main  :  "+i);
    }
    
    MyThread t = new MyThread();
    t.start();
    
    Thread t2 = new Thread(new MyRunnable());
    t2.start();
    
    
    for(int i=0; i<1000; i++){
      double d = 3.14;
      d /= 12.56;
      double d3 =5.134;
      double d2 = 1.454156;
      System.out.println("main2       :            "+i);
    }
  }
 
}