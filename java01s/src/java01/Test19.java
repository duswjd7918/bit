/*switch   
 * 특정 값에 따라 명령어의 실행을 분기할 때 사용한당
 * 문법: switch(4바이트 이하 정수 값 byte, short, int, char){
 * 			case 값:   명령어...break;
 * 			..
 * 			default : 명령어             //else의 의미임
 *       }
 * cf)JDK7부터는 switch문에 문자열을 넣을 수 있다.
 */

package java01;

public class Test19 {
	public static void main(String args[]){
		byte b =10;   //ok
		short s =10;//ok
		char c ='가'; //ok
		int i=10;//ok
		/*-------요 위까지가 4byte---------*/
		long l = 10L;// error
		float f =10.0f; //eroor
		double d = 10.0;//error
		boolean bool = true;//error
		String str = "okok"; //ok
		
		
		
		switch(str){

			default:
			System.out.println("test");
		}
	
	}
}
