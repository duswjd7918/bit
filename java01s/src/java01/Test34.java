/*형변환
 * 정의: 다른 데이터 형의 임시 메모리를 만들고 값을 복사하는 것!
 * 명시적 형변환(explicit type conversion): 명령어를 사용하여 형변환을 지정하는것!
 *  (임시 메모리의 데이터형)값;
 *  예) int i =10;
 *  byte b =(byte)i;
 * 암시적 형변환: JVM이 내부 규칙에 따라 자동으로 형반환 하는 것!->Test35.java
 */

package java01;

public class Test34 {
	public static void main(String args[]) {
		int i = 10;
		//l-value, r-value?
		// 할당 연산자를 기준으로 왼쪽의 메모리를 l-value라 한다.
		// 할당 연산자를 기준으로 오른쪽 상수 값이나 변수를 r-value라 한다.
		//left value는 반드시 메모리 여야하고!
		//right value는 메모리 or 상수 값이다!
		//비록 상수 값이 4바이트 정수지만, 메모리(l-value)에 넣을 수 있으면 허락 ㅇ
		byte b = 10;
		
		//상수가 아닌 경우는 값을 l-value에 넣을 수 있다 하더라고 허락 ㄴ
		//byte b2 =i; //error!
		
		//해결책
		//r-value 을 강제로 l-value에 넣는 방법!
		//l-value = (데이터형)r-value;
		//단, r-value가 l-value에 온전히 저장 될 수 있다는 확신이 있어야... 
		byte b3 =(byte) i;
		//i는 10이라는 값이기 때문에 1바이트로 만들어 b3에 넣더라도 문제 없다!
		
		//그러나! 다음의 경우를 조심조심!
		int i2 = 128;
		byte b4 = (byte) i2;
		//JVM은 i2의 값에서 상위 3바이트를 날리고 마지막 바이트를 b4에 넣는다. =>문제다뭄ㄴ제!!
		//왜냐구??  0000 0000 0000 0000 0000 0001 0000 0000
		System.out.println(b4);
	}

}
