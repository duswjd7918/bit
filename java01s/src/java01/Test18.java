/*조건문퀴드2
 * 다음과 같이 동작하도록 프로그램을 작성하세요
 * java -cp java01.Test18
 * =>결과=>당신은 나이가 어떻게 되는지 다음 보기에서 고르세요
 * 1.10대
 * 2.20대
 * 3.30대
 * 4.40대
 * 5.50대
 * 6.기타
 * 번호는?3
 * 당신은 30대 입니다.
 * 
 * 
 *  * -사용자로부터 키보드 입력값을 받는 법
 * 참고:   java.util.Scanner scanner = new java.util.Scanner(System.in);
 * 	      String input =scanner.nextLine();   //enter받기
 * 
 */

package java01;

public class Test18 {
	public static void main(String args[]){
		System.out.println("당신은 나이가 어떻게 되는지 다음 보기에서 고르세요!");
		System.out.println(" 1.10대 \n 2.20대\n 3.30대\n 4.40대 \n 5.50대\n 6.기타");
		
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		String input =scanner.nextLine();   //enter받기?
		//int input = Integer.parseInt(scanner.nextLine());           방법2!!!
		
		switch(input){
		case "1"://case 1 :													방법2!!!
			System.out.println("당신은 10대입니다."); break;
		case "2":
			System.out.println("당신은 20대입니다."); break;
		case "3":
			System.out.println("당신은 30대입니다.");break;
		case "4":
			System.out.println("당신은 40대입니다.");break;
		case "5":
			System.out.println("당신은 50대입니다.");break;
		default:
			System.out.println("당신은 60세 이상이겠죵?");break;
		}
	}
}
