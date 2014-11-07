/*
*InnerClass
 => 무분별한 클래스 노출을 막기 위해
  =>특정 클래스 안에서만 사용하는 클래스인 경우
  그 클래스 내부에서 정의함우로써
  외부에 노출되는걸 막을 수 있다.
  =>관리가 쉽당!
 * 클래스종류
  1.패키지 멤버클래스 <=일반적으로 만드는 클래스    Test13
  2.중첩(inner)클래스 Account가 inner여서 Test04 Test05에 Account04 05처럼 만들필요없었지
    1)top level inner class
    2)member inner class
    3)local inner class
    4)anonymous inner class
*/

package java02.test13;

//0)패키지 멤버 클래스
//public or default 접근제어만 가능.
//private  protected ㄴㄴ
//cf) inner class는 특정클래스의 멤버이기때문에
//     메서드나 변수처럼 모든 접근제어를 지정할 수 있다 ^^
//     public, (default), protected, private
public class Test01 {
  static int i;
  int j;
  
  static void x(){
    i=100; //ok
    //j=100;//error! instance변수에 접근 ㄴ ㄴ static메서드나 블록은 this라는 내장변수가 없다 ★★!!!!!!!!!!!!
  }
  void y(){ //<-인스턴스 메서드임
    i=100;//ok 인스턴스 메서드나 블록은 클래스변수를 바로 접근할 수 있다.
    j=100;//ok 인스턴스메서드는 블록은 this라는 내장변수가 있다 생략됐긔
  }
  //1)top level inner class
  //   :static으로 선언된 inner class
  //   :static이기 때무네 다른클래스에서도 사용가능~
  //목적-작은 크기의 클래스들을 묶고싶을 때 top level inner class사용
  //     작은 크기의 클래스를 패키지에 나열하면 관리가 번거롭잖음 ㅇㅇ
  static class TopLevelInnerClass {
    //inner 클래스는 바깥클래스의 멤버에 접근할 수 있다.
    //inner 클래스도 메서드나 변수와 같이 그 클래스의 멤버이기때문이당
   //static명령에서는 오로지 바깥 클ㄹㅐ스의 "static멤버"(변수, 메소드)만 접근가능 
    public void test(){
      i = 10; //바깥클래스의 static 변수를 사용할 수 있다.
      //j=200;// error 바깥클래스의 인스턴스주소를 알 수 없다.
    }
  }
  
  //2)member inner class
  class MemberInnerClass{
    //멤버이너클래스는 내부적으로 바깥 클래스의 인스턴스 주소를 갖고잇당
    //바깥클래스의 인스턴스주소 = >바깥클래스명.this  ☎
    public void test() {
       i=200;//당연히 non-static block에서는 static 멤버 사용 가능!
       
       //member이너 클래스에선 바깥클래스의 인스턴스멤버를 사용할수있돵
       j=300;
       
       //위의 코드는 컴파일 시 다음과 같이 바뀐당 ☆_☆
      //->   Test01.this.j = 400;
       
       //만약, 이너클래스에 같은 이름을 가진 변수가 있다면,
       //구분하기 위해 개발자가 다음과 같이 명시적으로 선언해야 한다. ☏
       Test01.this.j = 400;//memberInnerclass말고 바깥!
       
    }
    
  }
  
  public static void main(String[] args) {
  //3)local inner class
    //특정 메서드에서만 사용가능~~~~~~~~~
    class LocalInnerClass {
      public void test(){
        i=20;
        
        //static 블록은 바깥 클래스의 인스턴스 주소를 가리킬 수 없당
        //Test01.this.j=20;//ERROR why?  스테틱블럭이자늉 바깥쪽꺼ㄴ
        
      }
    }
  }
  
  public void instanceMethod(){
    class LocalInnerClass{
      public void test(){
        i=20;
        Test01.this.j = 20;//ok
      }
      
    }
  }
  
  
}
