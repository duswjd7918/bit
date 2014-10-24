/* boxing and unboxing
 * boxing 기본형 값을 가지고 랩퍼객체로 자동으로 만드는 것!@@
 * unboxing 랩퍼 객체에서 기본형 값을 자동 추출하는 것~
 * ㅇ ㅣ 두가지가 자동으로 아루어 지는 것=autoboxing(JDK 1.5이상) 
 */

package java01;

public class Test33 {

	public static void main(String[] args) {
		//boxing
		Integer i =10;  //new Integer(10)와 같아요
		
		//unboxing
		int j=1; 		  //i.intValue()와 같다.
	
	
	}

}
