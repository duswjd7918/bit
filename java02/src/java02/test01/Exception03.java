/* 예외상황발생 시 던질 수 있는 클래스 Throwable
  
  서브클래스: Error, Exception
  #시스템 관련 예외는 Error 계열의 객체데 담아 던진다.
   ->개발자가 처리할 수 없는 예외상황   X
  #애플리케이션 관련 예외는 Exception 계열의 객체에 담아 던진다.
   ->개발자가 처리할 수 있는 예외상황   O
  
  Q. 왜 복잡하게 예외정보를 담는 클래스가 많은겨 ?? Throwable하나가 아닌
  A. 예외상황을 좀 더 쉽게 구분하기 위해! => 예외처리를 상황에 따라 조정하기 쉽게.
  
  개발할때 보통 Exception 계열의 예외를 발생시킨다.

*/
package java02.test01;

public class Exception03 {
  
  //여러종류의 예외를 던지기
  public static int compute(int a, int b, String op) throws Exception, ArithmeticException {
      
    
    if(op == null) {
      throw new Exception("연산자를 지정하세여~!");
    }
    
    switch(op){
    case "+": return a+b;
    case "-": return a-b;  
    case "*": return a*b;  
    case "/": 
      if(b==0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
      return a/b;  
    default: throw new Exception("지원하지 않는 연산자입니당");
    }
  }

  
  
  
  //여러 종류의 예외를 처리하기~ catch로~
  public static void main(String[] args) {
    //catch 문 작성 시 자식 예외부터 처리하라!!! ArithmetidE -> Exc   
    //이유: 다형적 변수때문이얌
    try {
       int result = compute(10,20,"+");
       System.out.println(result);
    }catch(ArithmeticException ex){
      System.out.println("연산오류!");
      
    }catch(Exception ex){
      System.out.println("실행오류!");
      
    }/*catch(Exception ex){
      System.out.println("순서!");
    }*/

  }

}
