/* ♥메서드(함수)
 * -특정 기능을 수행하는 명령어를 묶어놓은것
 * -파라미터: 기능을 수행하는 필요한 정보를 전달
 * -리턴값: 기능을 수행한 후 결과를 전달한다.
 * -문법
 *   공개여부 스태틱여부 리턴타입 메서드명(타입 변수명, 타입 변수명, ...) {
 *   	return 값;
 *   }
 *  
 *   ex.
 *   
 *   int plus(int i, int b){
 *   	return i+b;
 *   }
 *   
 * ♥클래스변수
 * 클래스를 로딩할 때 준비되는 변수
 * Method Area영역에 준비됨.
 * JVM이 실행을 종료할 때 까지 유지
 * 
 * cf.로컬변수
 *      =함수가 호출될 때 준비되는 변수
 *     함수 호출이 끝나면 제거된다.
 *     STACK영역에 준비됨
 *     
 * cf.인스턴스변수 
 *      =인스턴스가 생성될 때 준비되는 변수
 *      HEAP영역에 준비됨
 *      가비지 컬렉터에 의해 해제되기 전까지 존재한다.
 * */


package java01;

import java.util.Scanner;

//주제: 사용자로부터 두개의 값과 연산자를 입력 받아  계산한 후 
//      그 결과를 출력한다.
//실행 예:
// $값1? 10
// $값2? 20
// $연산자? +
// $10 +20 = 30입니다.

//단계4:클래스 변수 도입! compute와 displayResult()에서 공유할 값을 보관
public class Test27 {
   //클래스변수 선언
   static int v1;
   static int v2;
   static String op;
   static int result;
	
	static void displayResult(){
		System.out.println("******************");
		System.out.printf("%d %s %d = %d",v1, op,	v2,	result);
		System.out.println("\n******************");
	}	
	
	static void compute() {
		
		switch(op){
		case "+": result= v1+v2; break;
		case "-": result= v1-v2; break;
		case "*": result= v1*v2; break;
		case "/": result= v1/v2; break;
	    }
		
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("값1?");
		v1 =Integer.parseInt(scanner.nextLine()); 
		System.out.println("값2?");
		 v2 =Integer.parseInt(scanner.nextLine());
		System.out.println("연산자?");
		 op =scanner.nextLine();
		
		
		compute();
		displayResult();//메서드호출: 반드시 호출할 때 정확하게 파라미터를 넘겨야 한다.

		
	}
}