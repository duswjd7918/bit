/* 목표1:오픈 소스 Reflections를 사용하여 클래스 찾기
   목표2:의존객체 자동 주입
   
   Dependency Injection=>그 클래스가 사용하는 객체를 애플리케이션을 시작할 때
   자동으로 주입하는 것 !
   
   Inversion of Control(역제어 = 폭포에 나뭇가지) >dependencyInjection
   1)사례1 이벤트처리
   2)사례2 의존 객체 주입!
   ex)컴터(의존객체)는 수업(업무)에 필한 것이지만 직접만드는게 아니고
   센터(전체 총괄하는 매니저 ;test01)에서 제공(주입)
   
   할 일!
   
   1.ListCommand 클래스에 의존 객체를 주입할 수 있도록 소스변경~
      1)의존객체를 저장하기 위해 ScoreDao 인스턴스변수 추가
      2)의존객체를 저장하기 위해 setScoreDao()메서드를 추가한다.
   2.나머지 Command클래스들도 소스 변경하라!
   3.Command 클래스를 로딩하여 객체를 생성한 후, commandMap에 등록하기 전에
   의존 객체를 먼저 주입한다.
 */
package java02.test08;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import java02.test08.annotation.Component;

import org.reflections.Reflections;

public class Test01 {
  Scanner scanner;
  ScoreDao scoreDao;
  HashMap<String, Command> commandMap;

  public void init() throws Exception {
    scoreDao = new ScoreDao();
    try {
      scoreDao.load();
    } catch (Exception e) {
      System.out.println("데이터 로딩 중 오류가 발생하였습니다.");
    }

    scanner = new Scanner(System.in);

    commandMap = new HashMap<String, Command>();

    Reflections reflections = new Reflections("java02.test08");
    Set<Class<?>> clazzList = reflections
        .getTypesAnnotatedWith(Component.class); //class목록리털ㄴ

    Command command = null;
    Component component = null;

    Method method = null;
    for (Class clazz : clazzList) {
      component = (Component) clazz.getAnnotation(Component.class);
      command = (Command) clazz.newInstance();
      commandMap.put(component.value(), command);
        try {
          // 만약, setScoreDao가 있다면 호출하여 ScoreDao객체를 주입한다.
          // Class관리자로부터 해당 클래스의 Method 객체를 얻는다.
          // invoke()를 사용하여 메서드를 호출한당~
          method = clazz.getMethod("setScoreDao", ScoreDao.class);// <-method이름은
                                                                  // setScoreDao
                                                                  // ScoreDao.class타입
                                                               
          // System.out.println(clazz.getName() + "." + method.getName());
          method.invoke(command, scoreDao); //의 존 주 입
          //위와 같은 소스임      그치만 위가 낫당 ㅇ commmand.setScoreDao(scoreDao)
        } catch (Exception e) {
        }
        // scanner의존객체주입 setScanner라는 것의 객체에 대해서ㅓㅓㅓ
        try {
          method = clazz.getMethod("setScanner", Scanner.class);
          System.out.println(clazz.getName() + "." + method.getName());
          method.invoke(command, scanner);
        } catch (Exception e) {

        }

     
    }
  }

  public void service() {
    Command command = null;
    loop: while (true) {
      try {
        String[] token = promptCommand();
        command = commandMap.get(token[0]);

        if (command == null) {
          System.out.println("해당 명령을 지원하지 않습니다.");
          continue;
        }

        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("scoreDao", scoreDao);
        params.put("scanner", scanner);

        ArrayList<String> options = new ArrayList<String>();
        for (int i = 1; i < token.length; i++) {
          options.add(token[i]);
        }
        params.put("options", options);

        command.service(params);

        if (token[0].equals("exit"))
          break loop;

      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("명령어 처리 중 오류 발생. 다시 시도해 주세요.");
      }
    }
  }

  public void destroy() {
    scanner.close();
  }

  private String[] promptCommand() {
    System.out.print("명령>");
    String[] token = scanner.nextLine().split(" ");
    return token;
  }

  public static void main(String[] args) throws Exception {
    Test01 app = new Test01();
    app.init();
    app.service();
    app.destroy();
  }

}
