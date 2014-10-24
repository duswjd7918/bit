/*인스턴스 블록  no뜬금            0.00001%실무에서 안만나 파라미터도없고 ㅗㅗ
 -인스턴스 생성->    초기화 문장수행->   (인스턴스 블럭 실행-,  생성자 실행)
 */

package java01.test46;

public class ClassA {
	int i=1;
	int j=2;
	
	//인스턴스 블록 no뜬금
	{
		System.out.println("ClassA의 인스턴스 블록1..ㄴ뜬금");
		i=100;
		j=200;
	
	}
	
	
	public ClassA() {//default 생성자
		
		System.out.println("ClassA의  생성자호츄루");
		i=10;
		j=20;
	}
	
	
	{
		System.out.println("ClassA의  인스턴스 블록2..ㄴ뜬금");
		i=1000;
		j=2000;
	
	}
}
