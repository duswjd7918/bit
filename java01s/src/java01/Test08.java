/*정수변수
 * byte(1)  -128 ~ 127
 * short(2)  -32768 ~ 32767
 * int(4)    -21억 ~ 21억
 * long(8):  -922경 ~ 922경 
 */

package java01;

public class Test08 {

	public static void main(String[] args) {
		byte minByte = -128;
		byte maxByte = 127;
		
		
		short minShort =-32768;
		short maxShort = 32767;
		
		int minInt=-2147483648;
		int maxInt= 2147483647;
		
		long minLong= Long.MIN_VALUE;
		long maxLong= Long.MAX_VALUE;
		
		//minByte = -129;//메모리의 크기보다 값이 더 크면 오류 발생
		//maxByte = 128;
		
		//정확한 오류내용확인!
		//♬ Literal  :정수 리터럴=>4바이트정수(10,20) / 8바이트정수(10L, 20L...)
	    
		//1. 상수값이 int(4) 타입이라도 메모리에 저장할 수 있으면 허락한다.
		byte b = 127;   //허락ㅇㅇ
		
		//2.상수 값을 메모리에 저장할 수 없으면 원래대로 오류를 발생한당
		/*byte b2 = 128;  //ㄴㄴ  int를 byte메모리에 저장할 수 없어!
		short s = 32768;*/
		
		/*byte b3 = 30L; //8바이트 상수값 저장 불가! ㄴㄴ
		short s2 =30L; //     ㄴㄴ
		int i =30L;   //      ㄴㄴ*/
		long l = 30L; //허락    ㅇㅇ 
	}	

}
