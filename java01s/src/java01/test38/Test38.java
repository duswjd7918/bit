/*boolean b =(true+false);//byte, short, int와 달리 The  operator is undefinded for the type boolean!
//  && || ^ ! 은 ok~*/
package java01.test38;

public class Test38 {

	public static void main(String[] args) {
		String name = "홍길동";
		int kor =100;
		int eng = 100;
		int math = 90;
		int sum = 290;
		float average =sum/3.0f;   //★
		System.out.println("이름:"+name);
		System.out.println("국어:"+kor);
		System.out.println("영어:"+eng);
		System.out.println("수학:"+math);
		System.out.println("합계:"+sum);
		System.out.println("평균:"+average);
		
		System.out.println("---------------------------------");
		//new Score();   ★★★★★★★★★
		//1)new Score:Score클래스에서 정의된 인스턴스 변수를 Heap에 준비한다.
		//2)():호출할 생성자를 선택하는 명령어.
		//     값을 안줬쪄?
		//     생성자 중에서 파라미터 값을 받지 않는 생성자(기본생성자)호출해@
		//생성자는 나중에 따로 호출할 수 없다.
		//반드시 new명령 다음에 즉시 호출해야 한다.
		
		Score s = new Score("홍길동",100,100,90);
		//new Score()에 에러났던이유: 파라미터가 없엇둥
		
		s.name = "홍길동";
		s.kor = 100;
		s.eng = 100;
		s.math = 90;
		s.compute(); //피연산자인 s   연산자인 compute()메소드 <Score연산자라고도해!
					   //b++에선 피연산자는 b 연산자는++
		System.out.println("이름:"+s.name);
		System.out.println("국어:"+s.kor);
		System.out.println("영어:"+s.eng);
		System.out.println("수학:"+s.math);
		System.out.println("합계:"+s.sum);
		System.out.println("평균:"+s.average);
		
	}

}