/*형변환
 *  암시적 형변환(implicit type conversion):
 *  연산을 수행 할 때 JVM의 규칙에 따라 자동으로 형변환 ㅎ되는것.
 *  -규칙
 *  byte,short,char=> int =>long =>float=>double
 *  ★연산의 기본은 int이다.
 *  -왜 형변환을 하니 ?
 *  =>연산을 수행하려면 두개의 값이 같은 데이터형이어야 한다.
 *  
 */

package java01;

public class Test35 {
	public static void main(String args[]) {
		byte b = 10;
		byte b2 = 10;
		short s = 10;
		char c = 10;
		int i = 10;
		long l = 10L;
		float f = 10.0f;
		double d = 10.0;
		
		//byte sum1 = b + s + c + i + l + f + d; //r-value:double
		//byte sum2 =f + b + s + c + i + l ;//r-value:float
		//byte sum3 =b+b2;;//r-value:int★    ★     !!!!!      
		                  //헐  왜 int임? byte,short char값들을 연산할때 int로 변환한 후 연산한다. so 결과는 int타입!
		int x = 5;
		int y = 2;
		System.out.println(x/y);              //암시적
		System.out.println(x/(float)y);       //명시적
		System.out.println((float)x/y);       //  ..
		System.out.println((float)x/(float)y);//  ..
	}

}
