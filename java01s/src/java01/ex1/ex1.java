package java01.ex1;
import java.util.Scanner;

/* 피자를 시켜야징 ~ 얼마일까?*/
public class ex1 {

	public static void main(String[] args) {
		
	   System.out.println("환영^*^ 내가 만드는 Pizza ! "
				+ "질문에 따라 피자를 차근차근 만들어 주세욤 !\n");
		
	   System.out.print("Q.(How many)몇 판 시키실건가요?\nA.");
	   Scanner scanner = new Scanner(System.in);
	   Integer number = scanner.nextInt();
	   Pizza pizza= new Pizza();
	
	   for(int i=1; i<=number ; i++){
	      System.out.println("---"+i+"번째 피자---");
		   pizza.size();
		   pizza.dough();
		   pizza.topping();
	   }
      System.out.println("------------");
	   pizza.beverage();
	   pizza.printTotal();
	}

}