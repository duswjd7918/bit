/*조건문 퀴즈!: 프로그램 아규먼트로 나이를 입력받아  청소년 청년등의 여부를 출력하세요
 참고문법: 문자열을 숫자로 바꾸는 방법 :
 String s = "23";
 int i=Integer.parseInt(s);
 */

package java01;

import java.util.ArrayList;
import java.util.Scanner;

public class Test17 {
	public static void main(String args[]){
		ArrayList age = new ArrayList();
		
		System.out.println("입력 ㄱㄱ");
/*		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();*/
		
			
		for(int i=0; i<args.length; i++){
			age.add(args[i]);
			System.out.print(age.get(i));  //[20]
			int a=(int) age.get(i);
			
			if(a < 18){
				System.out.println("청소년 입니다");
			}else if(a >= 18 && a<40){
				System.out.println("청년일꺼에요");
			}else if(a>=40 && a <50){
				System.out.println("장년입니다.");
			}else if(a>=50 && a<65){
				System.out.println("중년입니다");
			}else {
				System.out.println("힘내세요!");
			}
			
			
		}
	}
}
