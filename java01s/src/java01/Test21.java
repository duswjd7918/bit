/*반복문
 * -while(조건) {...};
 * 
 * -do명령문; while(조건);
 * -do{...} while(조건);
 * 
 * -for(초기화명령문; 조건; 증가문) {...}
 * -for(변수:배열이나 Collection타입 객체) {...}    //for in과 비슷 '~'
 */

package java01;

public class Test21 {

	public static void main(String[] args) {
		//퀴즈!!
		//1에서 20까지 출력하라, 단 짝수는 3의 배수는 출력하지 말규 while사용
		int i=1;
		while(i<=20){
			if(i%3!=0){
				System.out.println(i);
			}
			i++;
		}

	}

}
