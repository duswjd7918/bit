/* 프로토콜에 hello명령추가
 * 
 *  클라이언트는 처음접속할 땨 'hello 이름'명령을 보내야한다.
 * 서버는 이름을 기억해줬다가 사용한다.
 * 
 * 
 * */
package java02.test11.exam02;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {
  static Scanner keyboard = new Scanner(System.in);

  static class ChatSkeleton implements Runnable {
    Socket socket;
    Scanner in;
    PrintStream out;

    public ChatSkeleton(Socket socket) throws Exception {
      in = new Scanner(socket.getInputStream());
      out = new PrintStream(socket.getOutputStream());
    }

    @Override
    public void run() {
      String name = null;
      try {

        String message = null, line[] = null;
        while (true) {
          line = in.nextLine().split(" ");
          
          if(line[0].equalsIgnoreCase("hello")){
            name = line[1];
            System.out.println(name+"님이 접속하였습니당.");
              out.println("반갑습니다^*^");
              continue;
           } else if(line[0].equalsIgnoreCase("quit")) {
             System.out.println(name+"님이 연결을 끊었습니다.");
             out.println("goodbye");
             break;
           }
          System.out.println(name +"曰" +line[0]);
          message = prompt();
          out.println(message);
        }
      } catch (Exception e) {
        System.out.println("\n클라이언트와 통신중 예외발생");
        System.out.println(name+"님과의 연결을 종료하였습니다.");
      } finally {
        try {         in.close();        } catch (Exception e) {        }
        try {         out.close();       } catch (Exception e) {        }
        try {         socket.close();    } catch (Exception e) {        }
      }

    }

  }

  public static void main(String[] args) throws Exception {
    System.out.println("서버 소켓 생성");
    ServerSocket ss = new ServerSocket(8888, 2);
    System.out.println("클라이언트의 연결을 기다리는 중...");

    // 클라이언트와 연결이 종료되면 대기열의 다른 클라이언트와 연결한다.
    // 다만, 코딩한 바와 같이 순차적으로 실행한다.
    while (true) {
      Socket socket = ss.accept();
      System.out.println("\n대기중에 있는 클라이언트와 연결됨");

     /* ChatSkeleton chat =new ChatSkeleton(socket);
      Thread t =new Thread();
      t.start();*/
      new Thread(new ChatSkeleton(socket)).start();//실무용>_<
    }
  }

  private static String prompt() {
    System.out.print(">");
    String message = keyboard.nextLine();
    return message;
  }

}
