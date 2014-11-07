package java02.test13;
//import는 컴파일러에게 알려줄 뿐, 컴파일 후 사라진당 ㅇ_ㅇ/    wild카드는 컴파일 시간 오래걸림  -_ =
//만약 다른 패키지라면 다음과 같이 임포트 문을 적는다.
//import java02.test13.Test01;

//static inner 클래스 임포뜨
//방법1. 정확하게 모든 정보를 지정한다.
// ex)패키지명.패키지명.바깥클래스며야.중첩클래스명;
//import java02.test13.Test01.TopLevelInnerClass;

//방법2. import static 구문을 사용하여 static 멤버를 모두 지정하긩
import static java02.test13.Test01.*; //compiler야, Test01 static멤버중에 ㄷ ㅏ 찾아보렴 ^^...

public class InnerClassUser {

  public static void main(String[] args) {
    //1. top level inner class 사용함~~~  ♡_♡
    // 방법(1.)
    Test01.TopLevelInnerClass p = new Test01.TopLevelInnerClass();
    
     //방법(2.)
    //static class를 import하여 사용하긔
    // -> import java02.test13.Test01.TopLevelInnerClass;
    TopLevelInnerClass p2 = new TopLevelInnerClass();
    
    //2.다른 클래스의 member inner class 사용하긔
    Test01.MemberInnerClass p3 = null;
    
    //member inner class는 static 멤버가 아니기 때문에 클래스 이름으로 접근할 수 없당
    //예외: 참조변수를 선언할 때==> 바깥클래스명.멤버이너클래스명 참조변수;
    //p3 = new Test01.MemberInnerClass();   ERROR
    
    //member inner class를 사용하려면 바깥 클래스의 인스턴스가 필요해!
    //=>인스턴스메소드를 호출하려면 인스턴스가 필요하듯!_!
    Test01 outer = new Test01();
    p3 = outer.new MemberInnerClass(); //뭥미...괴상해 결론은 잘 안씀~ㅃㅂ
  }

}
