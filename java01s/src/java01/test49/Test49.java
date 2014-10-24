/*Map에 data를 저장할 때 문자열이 아닌 특별한 객체를 사용하기!
 * 
 * */
package java01.test49;

import java.util.HashMap;

public class Test49 {
	//Map에 데이터를 저장할 때 "특수 키"를 사용하기 ★★
	public static void main(String[] args) {

		MyKey key1 = new MyKey("1234abcd",100,1255);
		MyKey key2 = new MyKey("1234abcd",100,1255);//  열쇠복제
		
		Integer key3 = new Integer(10);           //보통 이거써
		Integer key4 = new Integer(10);
		 
		String key5 = new String("1234abcd");     //보통 이것도 써
		String key6 = new String("1234abcd");
		
		HashMap 냉장고2 = new HashMap(); //????????????????????????
		
		//Map에 데이터를 저장할 때 원리? 
		//키 객체의 hash값을 사용하여 저장한다. ★★
		냉장고2.put(key1, "보약");//key value
	
		//그리구 어머니는 놀러가셨당...
		// 아들 퇴근!
		
		//키로 냉장고를 열어본다.
		//Map에서 값을 꺼낼 때의 원리
		//1)저장할 때 사용한 키의 해시값이 같은지 조사
		//2)equals()를 호출하여 값이 같은지 조사
		System.out.println(냉장고2.get(key2));
		
		//주소가 다름을 증명
		System.out.println("----------------------------");
		System.out.println("key1 == key2?" + (key1==key2));  //false 같지 않지  주소가
		System.out.println("key3 == key4?" + (key3==key4));  //..
		System.out.println("key5 == key6?" + (key5==key6));  //..
		
		
		System.out.println("-----------------");
		System.out.println(key1.hashCode());//31168322             달 !
		System.out.println(key2.hashCode());//달랐다가 같아짐ㅋ
 		System.out.println(key3.hashCode());//10           같
		System.out.println(key4.hashCode());//10		     같
		System.out.println(key5.hashCode());//-1859998844  같
		System.out.println(key6.hashCode());//-1859998844  같
		
		/*왜!!!!!   Integer 객체와 String객체 해시값이 같을까?
		 = 원래 Object에서 상속받은 원래 메소드는 인스턴스가 다르면 
		   해시값도 다르도록 프로그램되어있다.
		   근데, String클래스와 Wrapper클래스(랩퍼클래스 Byte , Integer..)는
		   상속받은 hash코드를 재정의 하였다.
		   =>어케?  비록 인스턴스가 다르더라도 값이 같다면 같은 해시값을 리턴하도록 재정의 한것이다.
		*/
	
	
		//equals()리턴값
		System.out.println("---------");
		System.out.println("key1.equals(key2)? "+ key1.equals(key2));
		System.out.println("key3.equals(key4)? "+ key3.equals(key4));
		System.out.println("key5.equals(key6)? "+ key5.equals(key6));
	
	}
	
	
	
	
	
	
	//Map에 데이터를 저장할 때 문자열을 키로 사용하기
	public static void main01(String[] args) {
	HashMap studentMap = new HashMap();
	studentMap.put("s001",new Student("홍길동",10));  //키 &값(주소)
	studentMap.put("s002",new Student("임꺽정",10));
	
	System.out.println(studentMap.get("s001"));//get(key)으로 저장된 인스턴스 주소를 건내
	//Map과 배열(index로)과 다른점    : Map은 문자열(s001)로 객체를 저장할 수 있다. = 인스턴스의 주소를 저장할 수 있다.

	}

}
