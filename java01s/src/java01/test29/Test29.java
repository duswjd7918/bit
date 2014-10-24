/*  ♥ 캡슐화 ♥
 *   클래스를 정의한 의도와 다르게 변수나 메서드를 사용할 경우
 *   오류가 발생하게 된다.
 *   1)변수에 무효한 값을 넣는다거나,
 *   2)내부에서 호출한 메서드를 외부에서 직접 호출한다거나,       등
 *  
 *   =>클래스 작성자가 의도한 대로만 사용하도록 접근을 제한하는 문법!
 *   =>최소한의 안전장치ㅣㅣㅣㅣㅣㅣㅣ
 *   
 *   문법: [접근 제어자(Access Modifier)]  타입    변수명;
 *         [접근 제어자(Access Modifier)] 리턴타입  메서드명(..) {...}
 *         
 *         접근 제어자
 *         1)private    :클래스 멤버만 접근 가능!
 *         2)protected  :같은 클래스에서 접근 가능 자식 클래스 접근가능
 *         3)(default)  :같은 패키지의 클래스만 접근가능
 *         4)public     :모두 접근 가능~
 *  */


package java01.test29;

import java.util.Scanner;

//주제: Calculator의 그능을 이용하여 다음계산을 수행해! 단, 계산은 순차적으로 진행해라
//(연산자 우선순위 적용 ㄴㄴ)
//실행 예:10 + 2 * 7 - 4 / 2 = ?


//단계6 result변수의 외부 접근 차단    캡슐화!
public class Test29 {
   
	public static void main(String[] args) {
	//10 + 2 * 7 - 4 / 2 = ?
    //★★★★클래스 변수나 인스턴스 변수는 자동 초기화된다.
	//다음과 같이 별도로 초기화할 필요는 없 != Calculator.result=0;
		
		
		Calculator.plus(10);
		Calculator.plus(2);
		Calculator.multiple(7);
		//Calculator.result=-100; //-접근불가!!!!
		Calculator.minus(4);
		Calculator.divide(2);
		
		System.out.println("결과는?"+Calculator.getResult());
	} 
}