/*Quiz
 * for문을 사용하삼*/

package java01;

public class Test24 {

	public static void main(String[] args) {

		for(int x=4; x<100; x+=4){
			
			if(x%4==0){
				System.out.print(x+",");
				if(x%20==0){
					System.out.println();
					if(x%60==0){
						System.out.print("@");
					}
				}
			}
		}
		
	}

}