/* main() : JVM이 클래스를 실행할 때 호출하는 함수
 *     => start Entry
 *      다음 소스의 규칙에 따라 작성해라
 *      
 * 자바클래스실행
 * java -classpath [클래스 파일이 있는 경로] [클래스명]
 * 
 * 만약 클래스가 특정 패키지에 소속된 멤버라면,
 * java -classpath [패키지가 있는 경로] [패키지명.클래스명]
 *
 *-classpath 대신 -cp라고 해도됨!!
 *
 *패키지명.클래스명   Fully Qualified Name(Qname)
 */
package java01;

public class Test03 {
	public static void main(String[] args){
		System.out.print("Hello World!!\n");
		//콘솔창으로 출력
	}
}

/*Quiz: 1)net.java63.test 패키지를 생성하라ㅏ
 * 		 2)이 패키지에 HelloWorld 이름을 갖는 클래스를 생성하라
 *       3) 클래스를 실행하면 다음과 같이 출력되게 작성하라~
 *           >나의 첫번째 자바 프로그램!
 *       4)터미널을 사용하여 HelloWorld클래스를 실행하라~
 *
 *Quiz:
 * 		 2)이 패키지에 Ohora 이름을 갖는 클래스를 생성하라
 *       3) 클래스를 실행하면 다음과 같이 출력되게 작성하라~
 *           >1+3 =4이다.
 *          조건: 다음 코드를 삽입하고 v1,v2 변수를 이용하여 출력
 *       4)터미널을 사용하여 HelloWorld클래스를 실행하라~      
 *
*/