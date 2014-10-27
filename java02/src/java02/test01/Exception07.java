/* RuntimeException 계열(자식다포함)을 사용하여   ^*^ 
    Exception06의 고통을 해결한다 !
 */

package java02.test01;

import java.util.Scanner;   
public class Exception07 {
  static int a;
  static int b;
  static String op;
  
  static class Calculator {
    //Exception 대신 RuntimeException을 던진다
    //=> Error처럼 메서드 선언부에 지정하지 않아두 된다.
    public static int compute(int a, int b, String op) /* throws Exception*/ {
      switch(op){
      case "+": return a+b;
      case "-": return a-b;  
      default: throw new RuntimeException("지원하지 않는 연산자입니당");
      }
    }
  }
  //compute()에서는 RuntimeException을 던진다.
  //try catch로 처리하지 않으면,
  //★★★자동★★★으로 상위 호출자에게 던진다.
  //throws 절을 선언하지 않아두 된다.
  public static void printResult() /*throws Exception*/{
    System.out.println("a=" + a);
    System.out.println("b=" + b);
    System.out.println("result=" + Calculator.compute(a,b,op));
  }
//쌤쌤  printResult()에서 던진 예외를 처리하기 싫으믄 상위호출자에게 넘귐
  public static void printContent() /*throws Exception*/{ 
    System.out.println("(2)*******************");
     printResult();
    System.out.println("(3)*******************");
  }
  
  //이케 일반 메서드 호출하듯 printContent()를 호출하수있다.
  //throw절 생략->코드 간결해지지
  public static void printPage() /*throws Exception*/{
    System.out.println("(1)머리말정보...");
    printContent();
    System.out.println("(4)꼬리말정보...");
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("a = ");
    a = Integer.parseInt(scanner.nextLine());
    System.out.println("b = ");
    b = Integer.parseInt(scanner.nextLine());
    System.out.println("연산자능 = ");
    op = scanner.nextLine();
    
    //compute에서 발생된 예외를 중간의 메서드에선 처리할 필요가 읎다.
    //이렇게 첨 호출자가 통합하여 처리하면 돼
    //오류 관리가 쉽고 ,  코드가 간결해짐.
    try {
    printPage();
    } catch(Exception ex) {
      System.out.println(ex.getMessage());
    }
  }
  
}
