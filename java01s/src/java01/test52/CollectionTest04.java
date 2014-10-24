/*  HashMap사용하기
 * 키-값 형태! 
  key-value 쌍으로 데이터를 관리한다.
 * 키로 사용할 클래스는 hashCode(), equals()를 재정의 해야한다.
  =>인스턴스가 다르더라고 값이 같으면 같은 해시코드를 리턴하도록 구현 해야한다.
  => 값(value)이 같으면 equals()가 true를 리턴한다.
 * 기존에 자바에서 제공하는 클래스 중에서 String과 랩퍼클래스들은
  hashCode()와 equals()를 재정의 했기 때문ㅇㅔ key로 사용할 수 있다.
 
 */

package java01.test52;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class CollectionTest04 {
	
	//member inner class
	// 인스턴스 메서드나 같은 멤버 이너 클래스만이 이 클래스를 사용할 수 있다. ♣
	//cf) class member란?   클래스를 구성하고 있는 원소 : 변수, 메서드, 이너클래스
	
	//top level inner class (static붙었긔).                        ♠
	//: member inner class에 static붙인 클래스.
	//클래스 메서드나 static 블록에서 사용할 수 있다.
	static class Score { //class Scoreㄴㄴ인듯
		String name;
		int kor;
		int eng;
		int math;
		
		public Score(String n, int k, int e, int m){
			name=n;
			kor=k;
			eng=e;
			math=m;
		}
	}
	/*static블록에서는 오로지 클래스 변수 밑 클래스 메서드만 사용할 수 있다.
	 * 이유>
	 * class A {
	 * 	 int value;
	 * 
	 *   void print(){
	 * 	   System.out.println(value);
	 *    }
	 *    
	 *   static void test(){
	 *    print();//호출가능하다면 어떤일이 벌어질까여 ? ㅠ ㅠ
	 *    }
	 * } 
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		HashMap<String,Score> map = new HashMap<String,Score>(); 
		map.put("1111", new Score("홍길동",100,100,100));
		//key는 중복될 수 없다. 따라서 임꺽정 데이터는 기존 데이터를 덮어버린다.
		// ->홍길동 데이터는 날아감.
		map.put("1111", new Score("임꺽정",100,100,100));
		map.put("2222", new Score("유관순",100,100,100));
		
		System.out.println(map.get("1111").name);
		System.out.println(map.get("2222").name);
		
		//quiz:   key를 모든다고 가정하고 map에 저장된 값을 모두 출력하시요!
		//hint:   API문서를 보세용
		//방법1: EntrySet활용
       System.out.println("---------quiz solution1----------");
		Set<Entry<String,Score>> kvSet = map.entrySet();
		for(Entry<String,Score> entry:kvSet){
			System.out.println(entry.getKey()+ ":"+entry.getValue().name);
		}
		//방법2: 먼저 key목록을 얻은 다음에, 그 키를 사용하여 값을 꺼내기
		 System.out.println("---------quiz solution2----------");
		Set<String> keySet = map.keySet();
		for(String key: keySet){
			System.out.println(key +":" +map.get(key).name);
		}
		//방법3: key값을 알 필요가 없다면, 값만 꺼내기
		System.out.println("---------quiz solution3----------");
		Collection<Score> valueList = map.values();
		for(Score value :valueList) {
			System.out.println(value.name);
		}
		
		}

}
