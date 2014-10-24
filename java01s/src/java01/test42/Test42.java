package java01.test42;

public class Test42 {

	public static void main(String[] args) {
		Tico c1 = new Tico();
		Jeep c2 = new Jeep();
		Cabrio c3 = new Cabrio();
		
		//Car클래스는 Generalization을 위해 정의한 클래스이다.
		//직접 사용할 목적으로 정의한것이 아니라,
		//서브 클래스들에게 공통 속성이나 메서드를 상속해 주기 위해
		//정의한 클래스당
		//근디!! 다음과 같은 인스턴스를 만들어 사용할 수 있다면,
		//원래의 의도와 달라진다.
		//상속해주는 용도의 클래스는 인스턴스를 사용하지 못하게 막는방법? 다음 예제에...
		Car c4 = new Car();

	}

}
