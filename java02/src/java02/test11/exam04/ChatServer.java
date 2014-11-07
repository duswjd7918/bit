package java02.test11.exam04;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

@SuppressWarnings("serial")
public class ChatServer extends Frame implements ActionListener {
  TextArea taContent = new TextArea();
  TextField tfInput = new TextField(30);
  Button btnSend = new Button("보내기");
  
  String username; //cli꾸
  
  ServerSocket serverSocket;
  Socket socket;
  Scanner in;
  PrintStream out;
  
  public ChatServer() {
    
    this.add(taContent, BorderLayout.CENTER);
    
    Panel bottom = new Panel(new FlowLayout(FlowLayout.LEFT));
    bottom.add(tfInput);
    bottom.add(btnSend);
    
    this.add(bottom, BorderLayout.SOUTH);
    
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        try{
          out.println("quit");
          taContent.append("client와 연결을 종료했습니다\n");
          socket.shutdownInput(); //읽는스트림닫으렴 close로되는게아님 ㅋㅋ
        }catch(Exception exx){}
        try{  in.close();  } catch(Exception exx){       }
        try{  out.close();  } catch(Exception exx){       }
        try{  socket.close();  } catch(Exception exx){       }
        try{  serverSocket.close();  } catch(Exception exx){       }
        System.exit(0);
      }
    });
    
    
    
    btnSend.addActionListener(this);
    tfInput.addActionListener(this);
  }
  
  public void service() {
   try{
     taContent.append("client의 연결을 기다리는 중...   - _-zzzZZ \n");
     serverSocket = new ServerSocket(8888);
     socket = serverSocket.accept();
     
     in = new Scanner(socket.getInputStream());
     out = new PrintStream(socket.getOutputStream());

     String[] message = in.nextLine().split(" ");
     
     taContent.append(message[1]+"님과 연결 되었습니당 ♡.♡\n");
     ChatReaderThread reader = new ChatReaderThread(in,taContent);
     reader.start();
   }catch(Exception ex){
     ex.printStackTrace();
     
   }
    
  }

  public static void main(String[] args) {
    ChatServer wnd = new ChatServer();
    wnd.setSize(400, 600);
    wnd.setVisible(true);
    wnd.service();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
 // 보내기 버튼을 눌렀다면,
      //1) 화면에 보낼 내용을 먼저 출력한다.
      taContent.append("나:"+tfInput.getText()+"\n"); //cli 내꾸의 화면에 먼저 ㅋ.ㅋ
      
      //2)서버에 입력 내용을 보낸당
      out.println(tfInput.getText());
      tfInput.setText(" ");
    
  }
}

