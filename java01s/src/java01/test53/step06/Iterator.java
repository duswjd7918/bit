/*Iterator를 클래스에서 자격을 의미하는 인터페이스로 바꾼다.
- 인터페이스?  자격!  규칙! 을 정의하는 문법.
- 인터페이스 문법:  자격 , 규칙에 대한 메서드를 선언
					상수 클래스 변수가 올 수 있다.
   메서드: MUST be  "abstract public"
   변수  : MUST be  "public static final"

*/

package java01.test53.step06;

//인터페이스는 자격을 갖추기 위해 가져야할 메서드 선언.
public interface Iterator {
  
  
  /*     생 략 가 능      */
  /*public static final*/// public int  i;
	
  /*abstract public    */ void setList(String[] list) ;  // 규 칙 은 공 개 해 야 돼
  
  /*abstract public    */ boolean hasNext();    // 전 방 100m 속 도 감 시 카 메 라 있 다
  
  /*abstract public    */ String next();
  
}