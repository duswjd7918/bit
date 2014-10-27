package java01.test48;

public class Test48 {
	//hashCode() 테스트 >_<
	public static void main(String[] args) {
		Student s1 =new Student("홍길동",10);
		Student s2 =new Student("홍길동",10);
		
		System.out.println(s1.hashCode());//인스턴스 식별자 출력!!!!!      hashCode값 출력
		System.out.println(s2.hashCode());
		
	}

	//toString Test하는 예제였당
	public static void main01(String[] args) {
		Student s1 = new Student("홍길동",10);
		Student s2 = new Student("임꺽정",10);

		/*System.out.println(s1.toString());
		System.out.println(s2.toString());*/
		/*System.out.println(s1); //홍길동,10
		System.out.println(s2);  //같은 결과가 나옴 ㅋㅋㅋㅋㅋㅋ          클래스명@hashCode값
*/	}

}
