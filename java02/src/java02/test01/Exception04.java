/* Error계열 예외는 예외처리를 하지 않아도 컴파일 오류가 발생 ㄴㄴ
  니가 뭘 알겠니 ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
  
   System에서 발생하는 오류; 애플리케이션에서 처리할 방법은 없을꾸야

- 문법 : throw new Error("오류 내용");
- 메서드 선언부: 예외 객체를 지정할 필요가 없당
- 호출자: try catch를 사용하지 않아두 댕

이유/의미: "이건  시스템 오류라서 내가 처리할 문제가 아닐세! 난 몰라! "
          "아 물론 내가 처리할 수도 있즹ㅇㅇ"
*/
package java02.test01;

public class Exception04 {
  public static int divide(int a, int b) /* throws Exception  */ {
    if(b==0)
      throw new Error("0으로 나누지마셈");
    return a/b;
  }
  public static void main01(String[] args) {
    //Error 계열의 예외는 애플리케이션에서 어찌할 바가 아니야
    //그래서 try...catch...를 사용하지 않는다
    //결국 divide()에서 발생한 예외는 JVM에게 전달!
    
    
    
    /*try {*/
      int result = divide(10,0);
   /* } catch (Exception e) {
      System.out.println(e.getMessage());
    }*/
   
  }
//그러나 굳이 처리하고자 한다면 해도돼! try catch ㅇㅇ
  public static void main(String[] args){
    try {
      int result = divide(10,0);
    }catch (Error e) {
       System.out.println("0이드래요~");
     }
    

  }
}
