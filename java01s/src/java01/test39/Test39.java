package java01.test39;

public class Test39 {

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
		
		Score s = new Score("홍길동",100,100,90);
		//new Score()에 에러났던이유: 파라미터가 없엇둥
		Score s2 = new Score(); //이렇게도 할 수 있다규!!!!^0^!!!
		s2.name="임꺽정";
		s2.kor = 90;
		s2.eng = 90;
		s2.math =90;
		s2.compute();
		
		System.out.println("이름:"+s.name);
		System.out.println("국어:"+s.kor);
		System.out.println("영어:"+s.eng);
		System.out.println("수학:"+s.math);
		System.out.println("합계:"+s.sum);
		System.out.println("평균:"+s.average);
		
	}

}