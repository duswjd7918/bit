/*garbage와  garbage collector
  Garbage란? 참조하는 변수가 없는 메모리
  Garbage Collector란? 가비지의 메모리를 해제하는 객체
 */
package java01;

public class Test14 {

	public static void main(String[] args) {
		int[] p = new int[5];//ex. 배열의 주소가 100번지라고 하자!
		int[] p2 = new int[3];//              200번지라고 하자!
		int[] p3 = p;
		
		p3[2]=100;
		System.out.println(p3[0]);//0
		System.out.println(p[2]);
		
		p2=p;//p2는 100번지
		
		//200번지 배열의 주소는 누가 갖고있나?
		//갖고 있는 변수가 없다!! =>200번지 배열은 쓰레기가되었다!!!
		//그렇다면, 가비지는 언제 청소하나? (사용될 수 없는 메모리 해제 시점)
		//  (1)idle time  =잉여ㄸㅐ
		//   (2)메모리가 부족할때 
		//   (3)가비지 컬렉터가 관리하는 메모리 영역은 Heap임!!!!!!!!!!!
		//    ★잠깐 실행하는 경우는 가비지 컬렉터가 동작하지 않는다.
		//가비지가 생겼다고 가비지 컬렉터가 즉시 동작하는것이 아니다!
		//실무에서 가비지 생성을 최소화 하도록 프로그래밍하자> .<
		
	}

}
