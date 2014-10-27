/*     예외 발생을 먼~~~~~~~~~~~~~ 호출자에게 던지고자할 때
 -바로 전 호출자가 아닌 ㄷ ㅓ 상위의 호출자에게 오류정보를 던지고 싶을 ㄸ ㅐ !
 -RuntimeException객체를 사용하라.
 
 -RuntimeException은 Exception 의 자식이지만, Error처럼 동작한다.
 Q.아니ㅡ 강사님... 그냥 Error 사용하면 안되나요.?
 A.Error는 시스템 오류를 담을 때 사용한다.
   따라서 애플리케이션에서 Error을 사용하는것은 바람직하지 않다.!
   그럼에두 불구하구 Error처럼 예외를 던지고 싶을 때가 있는데 
   그럴 경우를 대비해 만든 클래스가 RuntimeException!
 */

package java02.test01;

import java.util.Scanner;
//RuntimeException을 사용하지 않을때의 고통 ㅠㅠ
//-> 상위 호출자에게 오류를 던지기 위해
//   메서드 선언에 만드시 throws 명령을 붙여야한다.
//ex) printCompute(), printContent(), printPage()ㅇ   ㅔ    
public class Exception06 {
  static int a;
  static int b;
  static String op;
  
  static class Calculator {
    //Exception 계열의 예외를 던지는 메서드는 
    //반드시 메서드 선언부에 throws Exception처럼 지정해야해
    public static int compute(int a, int b, String op)  throws Exception {
      switch(op){
      case "+": return a+b;
      case "-": return a-b;  
      default: throw new Exception("지원하지 않는 연산자입니당");
      }
    }//compute
  }//static class Calc

  //compute에서 발생하는 예외를 처리하기 싫으면 상위호출자에게 넘긴다.
  //문법: throws 예외명
  public static void printResult() throws Exception{
    System.out.println("a=" + a);
    System.out.println("b=" + b);
    System.out.println("result=" + Calculator.compute(a,b,op));
  }
//쌤쌤  printResult()에서 던진 예외를 처리하기 싫으믄 상위호출자에게 넘귐
  public static void printContent() throws Exception{ 
    System.out.println("(2)*******************");
     printResult();
    System.out.println("(3)*******************");
  }
  
  public static void printPage() throws Exception{
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
    
    //compute에서 발생된 예외를 printResult()가 아닌
    //main에서 처리!
    try {
    printPage();
    } catch(Exception ex) {
      System.out.println(ex.getMessage());
    }
  }//this is the last brace of main()

}
