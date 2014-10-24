/*    4단계 목표
   Iterator 변경을 자유롭게 하기!!!!
   Test04 사용할 Iterator를 대체하기 쉽게 하자!@
  -해결책 
  1) Iterator 클래스 이름을 외부에서 받자!
  2)"외부"에서 받은 클래스로 Iterator 객체를 생성하자!
  3)그 객체를 사용하여 값을 꺼내자>_<!!!!!!@!!@!!!@@
  
  -어떤 값을 외부에서 받는 방법 (해결책 2에서 나옴ㅋ)
  1)프로그램 파라미터(아규먼트)
  2)JVM 파라미터 (아규먼트) VM argument  ★ ☆ ★ ☆ ★
     ex. java -D이름=값 -D이름=값Test04 파라미터 값 파라미터값 파라미터값 ...
     그러면 VM에게 전달된 값을 어떻게 알아내는가? ㅡ  소스를 보시지요ㅛㅛㅛ    main01 참조!
 */ 


package java01.test53.step04;

import java.util.Enumeration;
import java.util.Properties;

import java.lang.reflect.Method;

public class Test04 {
	public static void main(String[] args) throws Exception { //java -D이름=값 -D ....
		//System.getProperty("환경변수 명")
		//     =     -D 옵션으로 넘어온 값 및 JVM 환경변수 값을 꺼낸다.
		String iteratorClassName = System.getProperty("iterator"); 
						//System이라는 클래스의 도구인 ▲getProperty의 능력 : iterator라는 이름의 "값"리턴
		System.out.println(iteratorClassName);		//==>java01.test53.step04.Iterator
		//클래스 이름(패키지명 포함)으로 객체 생성하기
		// 1)                 ▼  클래스를 로딩하라      ((( 클래스정보를담은곳 Class)))
		Class clazz = Class.forName(iteratorClassName);
		  //mainarea에 넣어 Iterator를 
		
		// 2) Class객체clazz를 사용하여 인스턴스 생성▼ 
		Iterator iterator = (Iterator)clazz.newInstance();
		
		//3) Iterator를 사용하기 전에 필요한 값을 설정한다.
		iterator.setList(args);
		
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		//Iterator 클래스의 메섣 이름을 출력
		//반사API인 Method쓰장
		Method[] methods = clazz.getMethods();
		for(Method method : methods){
			System.out.println(method.getName());
		}

		//안타깝게도 다른 Iterator는 사용할 수 없덩..
		//다음 단계를 보기 바래ㅐㅐㅐㅐㅐㅐㅐㅐㅐㅐ ^ㅇ^
		
	}
	
	//▼ JVM 프로퍼티값 꺼내기 예제
	public static void main01(String[] args) {
		//값알고싶으믄 이름을주면 값을뻐내지요                [클래스명]
		//$java -Diterator=okok -Dname=haha -Dage=23 java01.test53.step04.Test04 11 22 33 44 55 
		//     -Diterator=okokokokokokokok
		//$java -D이름=값 -D이름=값 Test04 111 222 333 444 555 666
		//         _______
		//         ㄴ>   System.Property(이름) 값
		//-D옵션으로 전달된 값을 꺼낼 때 
		//SYstem.getProperty(파라미터명) 사용하라.
		/*	System.out.println(System.getProperty("iterator"));
    	System.out.println(System.getProperty("name"));
		System.out.println(System.getProperty("age"));*/
		
		System.out.println("----------------");
		
		
		//-D옵션으로 전달된 값을 담고있는 객체를 왕창!! 꺼낸당
		Properties props = System.getProperties();
		Enumeration keyList = props.keys();
		String key =null;
		while(keyList.hasMoreElements()){
			key =(String)keyList.nextElement();
			System.out.println(key+"->"+props.getProperty(key));
		}
		
		EvenIterator iterator = new EvenIterator(args);
		
		/* Iterator가 바뀌더라도 다음코드는 변경할 필요가 없다.
		 * 이게 Iterator 설계 특징이다.
		 * 즉, 꺼내는 방식에 상관없이 사용하는 쪽에서는
		 * 일관된 이름으로 메소드를 사용할 수 있다는 점이다.!
		 * 
		 * 이렇게 꺼내는 방법을 별도의 객체로 분리함으로써
		 * 실행할 때 유연해진다.
		 * */
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}

	}

}
