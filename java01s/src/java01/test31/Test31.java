/*  ♥ 인스턴스 메서드
 * 인스턴스 주소를 줘야지만 호출할 수 있는 메서드
 * 문법: 인스턴스주소. 메서트();
 * 해설: 인스턴스 메서드를 호출할 때 인스턴스의 주소를 앞에 줘
 *  JVM은 인스턴스 변수가 어떤 클래스의 변수인지 알아낸당.
 *  알아낸 클래스의 메서드를 호출한다.
 *  이때, 메서드 앞에 준 인스턴스의 주소를 메서드에 넘긴다.
 *  메서드는 JVM이 호출할 때 넘겨준 인스턴스 주소를 내부 비밀 변수에 저장한다.
 *  비밀변수의 이름은 this.
 */
package java01.test31;



public class Test31 {
   
	public static void main(String[] args) {
	//10 + 2 * 7 - 4 / 2 = ?
    //20 * 3 +76 - 5 = ?
		
	//단계7: result변수를 개별적으로 유지=> 인스턴스 변수
		
		//Calculator 클래스의 명령에 따라 준비된 메모리를 ............. 인스턴스라 한다. 실례
		//그 인스턴스 메모리의 주소를 저장하는 변수를 ....................레퍼런스라 한다.
		Calculator c1 =new Calculator();
		Calculator c2 =new Calculator();
		
		c1.plus(10);
		c2.plus(20);
		
		c1.plus(2);
		c2.multiple(3);
		//Calculator.result=-100; //-접근불가!!!!

		c1.multiple(7);
		c2.plus(76);
		
		c1.minus(4);
		c2.minus(5);
		
		c1.divide(2);
		
		System.out.println("결과는?"+c1.getResult());
		System.out.println("결과는?"+c2.getResult());
	} 
}