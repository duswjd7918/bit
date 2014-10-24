package java01.test53.step05;

public class ReverseIterator extends Iterator {      /* */

	int cursor;
	public ReverseIterator(){
		
	}	

	@Override
	public void setList(String[] list)
	{	
		/* super 키워드: 오버라이딩 전의 메서드를 가리킬 때 사용 ! super.super.-()(X)   
		 * -super는 수퍼클래스를 가리키는 것이 아니다~ 주의 요망!*/
		super.setList(list); //기존기능은 그대로두고      @
		//this.list = list;
		cursor = list.length-1; //새 명령 추가.  +알파   @
	}
	public boolean hasNext(){
		if(cursor >= 0)	
			return true;
		else 
			return false;
	}

	public String next(){
		return list[cursor--];		
	}

}
