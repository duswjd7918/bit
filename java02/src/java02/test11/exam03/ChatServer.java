package java02.test11.exam03;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
  static Scanner keyboard;
  
  
  public static void main(String[] args) {
    ServerSocket ss = null;
    Socket socket = null;
    Scanner in = null;
    PrintStream out = null;
    try { 
      keyboard = new Scanner(System.in);
      ss = new ServerSocket(8888);
      
      System.out.println("cli의 연결을 기둘리고있긔");
      socket = ss.accept();
      System.out.println("cli가 연결 되었습니당");
      
      in = new Scanner(socket.getInputStream());
      out = new PrintStream(socket.getOutputStream());
      
      ChatReaderThread readerThread =new ChatReaderThread(in);
      readerThread.start();
      
      String message= null;
      while(true) { //commmmmmmmmmon
        message=prompt();
        out.println(message);
      }
    }catch (Exception e){ //오류 뮤쉬
      
    }finally{

      try{in.close();}catch(Exception e){}
      try{out.close();}catch(Exception e){}
      try{socket.close();}catch(Exception e){}
      try{ss.close();}catch(Exception e){}
      try{keyboard.close();}catch(Exception e){}
    }

  }
  
  private static String prompt() {//commmmmmmmmmon
    System.out.print(">");
    String message = keyboard.nextLine();
    return message;
  }

}
