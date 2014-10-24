/*   3 단계 목표
 * 역순으로 데이터를 꺼내주는 Iterator 만들기! class name:     ReverseIterator 클래스 추가
 */

package java01.test53.step03;

public class Test03 {

	public static void main(String[] args) {
		
		//ReverseIterator iterator = new ReverseIterator(args);   //요기서
		EvenIterator iterator = new EvenIterator(args);			//요기로 바꿔야...한다는..ㅠㅜ 단점발견
		
		/* Iterator가 바뀌더라도 다음코드는 변경할 필요가 없다.
		 * 이게 Iterator 설계 특징이다.
		 * 즉, 꺼내는 방식에 상관없이 사용하는 쪽에서는
		 * 일관된 이름으로 메소드를 사용할 수 있다는 점이다.!
		 * 
		 * 이렇게 꺼내는 방법을 별도의 객체로 분리함으로써
		 * 실행할 때 유연해진다.
		 * */
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}

	}

}
