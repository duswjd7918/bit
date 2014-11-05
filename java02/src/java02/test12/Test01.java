/*   JVM이 기본으로 생성하는 쓰레드 조사!
 * 
 * */

package java02.test12;

public class Test01 {
  public static void main(String[] args) {
    //현재 이 명령을 수행하는 Thread 알아내기!
    Thread t = Thread.currentThread();
    System.out.println("1) main호출 쓰레드:"+t.getName());
    
    //main 쓰레드가 소속되어 있는 스레드 그룹 알아내기
    ThreadGroup g =t.getThreadGroup();
    System.out.println("2) main스레드가 소속된 그룹:"+g.getName());
    
    
    //main쓰레드 그룹의 상위 그룹 알아내기
    ThreadGroup parent = g.getParent();
    System.out.println("3) main ThreadGroup의 상위 그룹:"+parent.getName());
    
    //system 스레드 그룹의 상위 크룹 알아내기
    //는 읎다!! system ThreadGroup이 최상위 그룹임
   /* parent = parent.getParent();
    System.out.println("4) system ThreadGroup의 상위 그룹:"+parent.getName());
    */
    
    browseThreadInfo(parent, 0);
    
  }
  
  
  public static void browseThreadInfo(ThreadGroup tg, int level) {
    displaySpaces(level);
    System.out.println("└---["+tg.getName()+"]");
    
    
    
    
    ThreadGroup[] groups = new ThreadGroup[10];
    int groupCount = 0;
    //system ThreadGroup의 하위 스레드 그룹 알아내기
    groupCount = tg.enumerate(groups, false);
    //groups라는 배열줄테니 하위스레드 갯수내놔 반복 ㄴ
    for(int i=0; i<groupCount; i++){
      //System.out.println("└---["+ groups[i].getName()+"]");
      browseThreadInfo(groups[i],level+1);
    }
    
    
    

    Thread[] threads = new Thread[10];
    int threadCount = 0;
    
    threadCount = tg.enumerate(threads, false);//하위 빼구!
    for(int i=0; i<threadCount; i++){
      displaySpaces(level+1);
      System.out.println("└--->"+ threads[i].getName()+"  는 쓰레드염");
    }
  
    
  }
  
  public static void displaySpaces(int count) {
    for(int i=0;i<count;i++){
      System.out.print("  ");
    }
  }
}
