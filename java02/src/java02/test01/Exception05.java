/*  예외 처리의 의미
   1)리턴값으로 예외상황을 알릴 수 없는 경우.
   2)리턴 값으로 예외상황을 알린다 해도 연산결과와 충돌이 일어날 때
   3) 작업코드와 오류처리코드를 분리 ->가동성을 높인당
 ★4)오류가 발생했을 때 시스템을 종료하지 않고 계소 수행할 수 있게한다.
*/
package java02.test01;

import java.util.Scanner;

public class Exception05 {
  public static int divide(int a, int b) /* throws Exception  */ {
    if(b==0)
      throw new Error("0으로 나누지마셈");
    return a/b;
  }
  
  //0으로 나누면 예외가 발생하구  시스템은 멈추게되지. NAVER에겐 있을수없는있어서는안될
  public static void main01(String[] args){
  
      Scanner scanner = new Scanner(System.in);
      int a,b;
      while(true) {
        System.out.print("a?");
          a = Integer.parseInt(scanner.nextLine());
        System.out.print("b?");
          b = Integer.parseInt(scanner.nextLine());
        System.out.println("결과(a/b):" + divide(a,b));
          
        System.out.println("계속하시겠습니다?(y/n)");
        if(scanner.nextLine().equals("n")) 
          break;
      }
      scanner.close();
 
  }
  
//개선안: 0으루 나눠서 예외가 발생하면 간단히 처리하고 계속 실행한다.
  //try catch 써...... 예외를 사용하는 이유다
  public static void main(String[] args){
  
      Scanner scanner = new Scanner(System.in);
      int a,b;
      while(true) {
        System.out.print("a?");
          a = Integer.parseInt(scanner.nextLine());
        System.out.print("b?");
          b = Integer.parseInt(scanner.nextLine());
         try{ //예외가 발생하더라도 간단히 처리하고 계속 다음 명령을 수행!
        System.out.println("결과(a/b):" + divide(a,b));
         }catch(Error ex){
           System.out.println(ex.getMessage());
         }
        System.out.println("계속하시겠습니다?(y/n)");
        if(scanner.nextLine().equals("n")) 
          break;
      }
      scanner.close();
 
  }
  
  
}