package java01.test44;

public class Soldier extends Mover {
	int attack;
	int level;
	
	//Mover로부터 상속받은 move()메서드를 서브클래스의 역할에 맞게 재정의하는것! 오버라이딩 Overriding
	//문법: 재정의 하려는 클래스와 같은 시그너쳐(Signature)를 갖는 메소드를 만들어라!
	//       단, 공개범위는 축소되면 안돼!
	//		 파라미터 변수 이름은 달라도 상관 없당
	
	//Signature란? 메서드의 이름과 리턴 타입, 파라미터 타입을 말한다 ^.^
	//C언어에서는 function prototype이라고 부른다.
	
	@Override   //이 Annotation의 메서드를 재정의 하는지 검사하라고 컴파일러에게 지시함~
	public void move(int dir) {
		System.out.println("군인뚜벅 뚜벅... 걷...는...다..");
		
	}
}
