package java01.test52;

public class Episode {
	static int global;
	int value;
	
	static void m() {
		global = 20;
		
		//클래스메서드는 this변수가 없다. 그럼 인스턴스메서드에는 있고???????
		//		this.value = 20;
		//this.m2();//error  instance method에 접근할수없지- 3-
	}
	
	void m2(){
		
	}
	public static void main(String[] args){
		Episode p = new Episode();
		//static이 붙은 메서드(클래스 메서드)도  인스턴스 주소p로 호출할 수 있다. ◈
		//BUT!!!!!!! 클래스 매서드에는 this라는 내부 변수가 없기 때문에
		//인스턴스 주소를 전달 할 길이 없다!

		m();//        good같은 클래스에 소속되어 있으면 클래스명 생략가능~
		Episode.m();//good
		
		p.m();      //bad ◈ 개발자 왜저러냐  - _-a
		
		//p.m2();   //◎
	}
}
