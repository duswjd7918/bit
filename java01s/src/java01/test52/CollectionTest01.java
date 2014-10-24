/*  Collection API
  :목록 데이터를 다루는 클래스 라이브러리
  :모든 Collection 관련 클래스들은 Collection규칙에 따라서 클래스를 만든다.
    1)List : 데이터 중복 허용
    2)Set  : 데이터 중복 불가
    3)Map  : key-value 쌍으로 데이터관리
 */
package java01.test52;

import java.util.ArrayList;
import java.util.Iterator;

/* ArrayList
 
 */
public class CollectionTest01 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList(); //Collection에는 값의주소!가 저장
		list.add("Hello");//Stringpool에만들어지지 중복은ㄴㄴ고
		list.add(new String("Hello"));
		list.add(10);//add(Object )
						//autoboxing => new Integer(10);
		
		//값 꺼내기 방법1.
		/*for(int i=0; i<list.size() ; i++){
			System.out.println(list.get(i));
		}*/
		
		//값 꺼내기 방법2
		// for (값을 담을 변수:배열 또는 Collection객체){}
		/*for(Object value : list) {
			System.out.println(value);
		}*/
		
		//값 꺼내기 방법3
		// Iterator객체 사용하여 꺼내기 <전문적으루 꺼내주는 자~!!!!!!!!!
		//자바.유틸에있는규칠             <실행횟수 ↓
		// Iterator 패턴
		//  -값을꺼낼때 일관된 방법을 사용: 호출하는 메소드가 같다.
		// -Iterator는 값을 꺼내는 방법(알고리즘)을 객체화시킨 것이다.
		//     객체화?  별도의 독립된 명령어 블록으로 분리함으로써 관리하기쉽디.
		//              다른 알고리즘으로 대체하기도 쉽지!
		Iterator iterator = list.iterator();
		System.out.println(iterator);
		while(iterator.hasNext()){
			System.out.println(iterator.next());
			
		}
	}
}
