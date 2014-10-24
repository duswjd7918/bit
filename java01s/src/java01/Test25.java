/*Quiz
 * for in을 사용하삼*/

package java01;

import java.util.ArrayList;

public class Test25 {

	public static void main(String[] args) {

		int[] scores= new int[]{100,90,80};
		//배열에서 값을 순차적으로 꺼낸당 :-D
		for(int value :scores){ //value가 index가 아니라는거
			System.out.println(value);
		}
		
		System.out.println("-----------------");
		java.util.ArrayList list =new java.util.ArrayList();
		list.add("홍길덩");
		list.add("100");
		list.add("90");
		list.add("50");
		
		//collection객체에 저장된 값을 순차적으로 하나씩 꺼낸다ㅏㅏㅏㅏ
		for(Object value :list) { //객체ㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔ엪ㄴㅇ ㄴㄹ 듏
			System.out.println(value);
			
		}
		
	}

}