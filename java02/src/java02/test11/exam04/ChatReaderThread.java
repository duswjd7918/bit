package java02.test11.exam04;

import java.awt.TextArea;
import java.util.Scanner;

public class ChatReaderThread extends Thread {
  Scanner in;
  TextArea taContent;

  public ChatReaderThread(Scanner in, TextArea taContent) {
    this.in = in;
    this.taContent = taContent;
  }

  @Override
  public void run() {
    try {
      String message = null;
      while (true) {
        message = in.nextLine();
        if(message.equalsIgnoreCase("quit")){
          taContent.append("연결을 끊었습니다!");
           break;
        }
        taContent.append("==>" + message+ "\n");
        //System.out.println("\n=들어온메시지=>" + message);

      }
    } catch (Exception e) {
      System.out.println("데이터 수신 중 오류 발생!!");
    } 

  }
}