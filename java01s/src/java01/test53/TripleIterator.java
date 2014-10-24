package java01.test53;

import java01.test53.step05.Iterator;

public class TripleIterator extends Iterator{
	int cursor;

	@Override
	public boolean hasNext() {
		//  상속받은 변수에 접근할 수 없다? 왜왜왜왜왜왜
		//list는 접근 범위가 default니까.
		//default는 클래스 멤버, 패키지 멤버만 접근ㄱㅏ능
		//해결책:     자식클래스도 접근 가능하도록 접근범위를 조정해야함
		//HOW? protected로 선언하라
		//protected는 클래스멤버/ 패키지멤버/(다름 패키지의)자식(도 ok)클래스 접근가능
		if(cursor < list.length-1) 
			return true;
		 else	
			 return false;
	}

	@Override
	public String next() {
		
		String value = list[cursor];
		cursor += 3;
		return value;
		
	}
}
