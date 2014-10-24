//역할 : 계산기 역할을 수행한다!
package java01.test31;

public class Calculator {
	//인스턴스 변수 선언 => static제거
	//==>인스턴스 변수는 클래스 로딩할 때 준비되지 않는다!
	//==>별도의 명령을 내려야만 준비한다.
	//-->명령 내리는 법?  new Calculator();
	//           해석:JVM 듣거라. Calculator클래스에 선언된 인스턴스 변수를 
	//			Heap메모리에 준비해 & 시작 주소를 리턴해!
	private int result; //클래스 멤버만 접근 가능하도록 제한한다.
	
	//인스턴스 변수를 사용하려면 그 인스턴스의 시작 주소를 알아야 한다.
	//따라서, 메서드의 파라미터에 인스턴스 주소를 넘겨줘

	int getResult(){
		return this.result;
	}
	
	  //Calculator this,
	  //this변수는 내부에 숨겨진 변수다.
	  //메서드를 호출할 때 사용한 인스턴스의 주소를 보관한다.
	  //만약, 인스턴스 변수를 사용할 때 this를 붙이지 않으믄,
	  //컴퍼일러가 자동으로 있다고 가정하고 컴파일 한다. 
	  //result += value //this. 생략 가능 ( O )	 
	
	
	
	
	void plus(int value){
		this.result += value;
	}
	void minus(int value){
		this.result -= value;
	}
	void multiple(int value){
		this.result *= value;
	}
	void divide(int value){
	    this.result /= value;
	}
	
}