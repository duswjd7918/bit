/*상수문자열
  -"문자열"식으로 표현
  -내부적으로 String 클래스의 인스턴스를 생성한다.
  -String pool 역역에 생성한다. (MethodArea에잇던...Stringpool)
  -중복생성되지 않는다.(메모리낭비줄이기위해!!!!!!!!!!)
  
  Method Area 영역에 클래스가 로딩되면,
  각 클래스 별로 상수 문자열의 String인스턴스가 준비된다.
 
  Method Area영역에서 각 클래스 별로 상수 문자열을 준비하는 메모리 영역을
  상수풀(Constant pool)이라고 부른다.
  
  즉, Method Area 안에 클래스가 로딩되고, 로딩된 클래스 안에 상수 문자열이 준비된다.
  
  String pool
  상수 문자열을 보관하는 메모리영역
  Method Area의 일부분이다.
  상수 문자열은 자주 사용되기 때문에 메모리 낭비를 줄이기 위해
  스트링풀이라는 영역에 통합관리한다.
  같은 상수 문자열이 존재할 수 없다. => 중복 생성되지 않는다.
 */

package java01.test50;


class A {
	static String str1 = "Hello";
	static String str2 = "Hello";
}

class B {
	static String str1 = "Hello";
	static String str2 = "Hello";
}		




/*class A {
	
}

class B {
	
}*/


public class StringTest02 {
	
	
	static String str1 = "Hello";
	static String str2 = "Hello";
	
	
	//위주석 /**/클래스는 test50 package가 다 공유할테니 난 아래와같이...
	
			//특정 클래스 안에서만 사용할 클래스라면, 그 클래스 내부에 선언하라!
			//-> 중첩클래스(inner class)라 불러.
			static class A {
				static String str1 = "Hello";
				static String str2 = "Hello";
			}

			static class B {
				static String str1 = "Hello";
				static String str2 = "Hello";
			}		
			
			
			
	public static void main01(String[] args) {
		if(str1 == str2) System.out.println("str1 == str2");
		if(A.str1 == A.str2) System.out.println("A.str1 == A.str2");
		if(B.str1 == B.str2) System.out.println("B.str1 == B.str2");
		
		if(str1 == A.str1) System.out.println("str1 == A.str1");
		if(A.str1 == B.str1) System.out.println("B.str1 == A.str1");
		
	}
	
	public static void main(String[] args) {
		String str1 = "Hello";//String pool에 인스턴스 생성 후 주소 리턴
		String str2 = "Hello";//기존 인스턴스의 주소 리턴
		String str3 = new String("Hello");//Heap에 인스턴스생성
		System.out.println(str1);
		if(str1 == str2) System.out.println("str1==str2"); 
		if(str1 == str3) System.out.println("str1==str3"); //nono
		//자바는 문자열을 객체로 다룬다.
		//문자열을 비교할 때는 equals()를 사용하렴! > _<
		
		//객체ㅇㅣ기 때문에 ==연산자는 주소를 비교해 문자열이 아니구
		//그래서~ 문자열 비교를 할 수가 없지 ==가.
		if(str1.equals(str3)) System.out.println("str1.equals(str3)");
		
		
	}
}
