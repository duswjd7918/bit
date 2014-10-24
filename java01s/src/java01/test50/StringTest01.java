/* String클래스
 -char[] 배열에 유니코드 문자열 저장
 -문자열을 다루는 다양한 메서드를 구비하고잇다.
 -immutable 객체->값을 저장한 다음 변경할 수 없다 !!!!! 변 경 못 훼 이
 */
package java01.test50;

public class StringTest01 {

	public static void main(String[] args) {
		String str1 = new String("Hello");
		String str2 = str1;
		String str3 = new String("Hello");

		//인스턴스의 주소를 비교했긔
		if(str1 == str2) System.out.println("str1==str2");
		if(str1 != str3) System.out.println("str1!=str3");
	
		//인스턴스의 값 비교하긔
		//String 클래스는 Object로부터 상속받은 equals()를 오버라이딩함(재정의함ㅋㅋ)
		//How?  인스턴스에 저장된 문자열이 같은지 비교하는것으로 변경!
		// 원래의 equals()는(오브젝트로 상속받은거) 는 인스턴스가 같은지를 비교하고있다.
		if(str1.equals(str3)) System.out.println("str1.equals(str3)");
	}

}
