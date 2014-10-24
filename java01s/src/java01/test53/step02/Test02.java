/*   2 단계 목표
 * -하드 코딩되어있는 데이터부분을 외부에서 입력받도록 기능 개선~
 */

package java01.test53.step02;

public class Test02 {

	public static void main(String[] args) { //aaa bbb ccc의 주소를 args  !
		
		Iterator iterator = new Iterator(args);  //프로그램 아규먼트(aaabbbccc)로 입력받긔
		while(iterator.hasNext()){              // java (package name)-Test02 aaa bbb ccc
			System.out.println(iterator.next());
		}

	}

}
