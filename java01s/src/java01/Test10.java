/*2진수, 8진수,10진수, 16진수 표현
 * 2진수: 표현불가!  2진수대신 16진수로 ㄱ ㄱ ㄱ ㄱ
 * 8진수는 0으로 시작
 * 10      ..
 * 16     0x로 시작
 */

package java01;

public class Test10 {

	public static void main(String[] args) {
		int i = 13;
		int i2 = 015;
		int i3 = 0xd;  //多2
		int i4 = 0Xd;
		int i5 = 0xD;  //多1
		int i6 = 0XD;
		
		System.out.println(i);
		System.out.println(i2);
		System.out.println(i3);
		System.out.println(i4);
		System.out.println(i5);
		System.out.println(i6);
	}

}
