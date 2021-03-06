/* 생성자☆★☆★☆★☆★☆★
 * 인스턴스가 생성한 후 자동으로 호출되는 메서드
 * 역할: 인스턴스를 사용하기 전에 유효한 값으로 초기화 하는 일을해
 * ㅈ ㅔ 역할을 할 수 있도록 유효한 값으로 설정한다.
 * 문법: 1)리턴타입이 없어야돼 -> 값을 리턴할 수 없다!!!!!!
 *      2)메서드 이름이 클래스이름과 같아야 한다.
 *      3) 파라미터가 없는 생성자를 기본 생성자라한다. default 생성자잉가봉가
 *      4)생성자를 만들지 않으면 컴파일러가 자동으로 기본 생성자를 만들어준다.
 * 
 */


package java01.test38;
//Score:학생의   이름, 국어,영어 ,수학, 평균, 합계를 저장하는 메모리의 데이터형이다!
public class Score {

		String name;    //인스턴스 변수, 속성(attibute)
		int kor;
		int eng;
		int math;
		int sum;
		float average;

//기본 생성자:파라미터가 없는 생성자
//생성자를 정의하지 않으면 컴파일러가 다음과 같이 자동으로 추가한다.
		//public Score() {		}
		
//생성자추가
		public Score(String name, int kor, int eng, int math){
			this.name =name;
			this.kor =kor;
			this.eng = eng;
			this.math = math;
			compute();
		}
//연산자를 정의하는 문법 = 메서드
//다음 연산자는 국어 영어 수학 점수의 합계를 내는 기능을 수행한다.
		public void compute(){  //operator!
	
			this.sum=this.kor + this.eng + this.math;
			this.average = this.sum / 3.0f;
		}


}