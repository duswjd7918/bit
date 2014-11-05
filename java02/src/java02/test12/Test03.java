package java02.test12;

import java.util.Date;

public class Test03 {

  static class MyAlarm implements Runnable {

    @Override
    public void run() {
      int count = 0;

      while (true) {
        if (count++ > 10) {
          break;
        }
        Date today = new Date();
        System.out.println("\n" + today);
        try {
          Thread.currentThread().sleep(1000); // 현재 쓰레드를 재워라 ㅋㅋㅋ코오~

        } catch (Exception e) { }
      }//wh
    }//run

    }//MyAlarm

  public static void main(String[] args) {
    new Thread(new MyAlarm()).start(); // 이런거 많이 볼 수 있을꺼야 실무
    
    for (int i = 0; i < 10000000; i++) {
      double d1 = 3.14159;
      double d2 = 123.456;
      d1 = d1 / d2;
      if ((i % 10000) == 0)
        System.out.print(".");
    }
  }//main

}
