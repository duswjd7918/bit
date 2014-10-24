/*반복문3
 * 퀴즈  두와일>.<
 * 1-100출력 단, 4의 배수를 출력하라 
 * 단, 20의 배수일때마다 다음라인을 출력하셈
 * 20배수이지만 60의 배수인 경우엔 @을 출력  
 * */

package java01;

public class Test22 {

	public static void main(String[] args) {
		long startMillisSec = System.currentTimeMillis();
		
		int x=1;
		do{
			if(x%4==0){
				System.out.print(x+",");
				if(x%20==0){
					System.out.println();
					if(x%60==0){System.out.print("@");}
				}
			}
			x++;
		}while(x<=2100000);
		long endMillisSec = System.currentTimeMillis();
		System.out.println(endMillisSec-startMillisSec);
		
		
	}
}
