package java02.test11.exam04;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatClient01 extends Frame{
  TextField tfserverAddr = new TextField(20);
  TextField tfName =new TextField(10);
  Button btnConnect = new Button("연결");
  TextArea taContent = new TextArea();
  TextField tfInput = new TextField(30);
  Button btnSend = new Button("보내깅");
  
  String username;
  String serverAddress;
  
  public ChatClient01(){
    //window 준비
    Panel toolbar = new Panel(new FlowLayout(FlowLayout.LEFT));
    toolbar.add(new Label("서버:"));//단순 ㅌㅅㅌ
    toolbar.add(tfserverAddr);
    toolbar.add(new Label("이름:"));
    toolbar.add(tfName);
    toolbar.add(btnConnect);
    
    this.add(toolbar,BorderLayout.NORTH);
    
    this.add(taContent, BorderLayout.CENTER);
    
    Panel bottom = new Panel();
    bottom.add(tfInput);
    bottom.add(btnSend);
    this.add(bottom,BorderLayout.SOUTH);
    
    //리스너 등록
   //1)window 이벤트를 처리할 리스너 객체등록
   //WindowListener 인터페이스를 구현한 객체여야한다.
    this.addWindowListener(new MyWindowListener());//종료버튼누르면꺼지는이벤트뜽록
    
    //ActionEvent는 버튼을 눌렀을 때 발생하는 이벤트다.
    //connectBtn.addActionListener(new MyConnectListener());//치아라 촌시럽다
    //실무에선 한번밖에 안쓸객체라면 익명 이너 클래스로 정의!
    btnConnect.addActionListener(new ActionListener(){//<-ActionListener는 인터페이스엿죠
      public void actionPerformed(ActionEvent e){
        //바깥클래스의 인스턴스변수를 사용할 때는 정확하게 바깥클래스의 this를 지정하거나
        //아니면 차라리 생략을 해 
        //단, 로컬변수나 이너클래스에 같은 이름을 가진 변수가 있다면 생략 불가하다!
        /*ChatClient.this.*/username = tfName.getText();
        System.out.println("연결버튼 눌렀뉑 ㅎ .ㅎ"
            + "\n사용자 이름:"+username
            + "\n서버주소: "+serverAddress);
      }
      
    });//익명이너클래수만둘
    
    
    //보내기버튼을 눌렀을 때 발생하는 이벤트다.
   // sendBtn.addActionListener(new MySendListener());
    btnSend.addActionListener(new ActionListener(){
      
      public void actionPerformed(ActionEvent e){
        System.out.println("보내기 버튼 눌렀뉑 ㅎ .ㅎ");
      }
      
    });
    
    
  }
  
  
  public static void main(String[] args){
    ChatClient01 wnd = new ChatClient01();
    wnd.setSize(400,600);
    wnd.setVisible(true);
  }
//WindowListener를 직접 구혀하지 말고 미리 구현한 windowAdapter를 상속받아라 제발,.
  class MyWindowListener extends WindowAdapter{
    @Override
    public void windowClosing(WindowEvent e){
      System.exit(0); //JVM 종 료.
    }
    
    
  }
  
/*  class MyConnectListener implements ActionListener{//상속 ㄴ 메소드하나뿐임
    //아래 button눌르때마다 호출된다.
    @Override
    public void actionPerformed(ActionEvent e){
      System.out.println("연결버튼 눌렀뉑 ㅎ .ㅎ");
    }
  }

  class MySendListener implements ActionListener{//상속 ㄴ 메소드하나뿐임
    //아래 button눌르때마다 호출된다.
    @Override
    public void actionPerformed(ActionEvent e){
      System.out.println("보내기 버튼 눌렀뉑 ㅎ .ㅎ");
    }
  }*/
}
//사기다.사기.
//람다문법: 함수를 등록하는 것 ㅊ   ㅓ  럼  !만드는고얌  실제론 객체가 등록