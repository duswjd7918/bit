/*조건문:명령어의 흐름을 조건에 따라 분기하는것.
 * if(조건) else ~
 * if(조건){...} else {...}
 */

package java01;

public class Test16 {
	public static void main(String args[]){
		int age= 20;
		if(age <18){
			System.out.println("청소년 입니다");
		}else if(age >= 18 && age<40){
			System.out.println("청년일꺼에요");
		}else if(age>=40 && age <50){
			System.out.println("장년입니다.");
		}else if(age>=50 && age<65){
			System.out.println("중년입     !!!니다");
		}else {
			System.out.println("힘내세요   !");
		} 
	}
}
