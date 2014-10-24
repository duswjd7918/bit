package java01.ex1;

import java.util.Scanner;
public class Pizza {
	  Scanner scanner = new Scanner(System.in);
	  int price = 0;

		public void size(){
			System.out.print("Q.사이즈(Size)를 골라주세요!"
			   		+ "1.Medium / 2.Large / 3.Family \nA.");
			   Integer size = scanner.nextInt();
			   
			   switch(size){
				case 1: this.price += 1000;break;
				case 2: this.price += 5000;break;
				case 3: this.price += 10000;break;
				default: System.out.println("잘못입력하셨습니다...");
				}
		}
		public void dough(){
			System.out.print("Q.빵을(도우Dough를) 골라 주세요! "
			   		+ "1.얇은 Thin / "
			   		+ "2.치즈 크러스트 Cheese Crust / "
			   		+ "3.고구마 패이스트 SweetPotato Paste \nA.");
			Integer dough =scanner.nextInt();
		   
			switch(dough){
			case 1: this.price += 10000; break;
			case 2: this.price += 13000; break;
			case 3: this.price += 15000; break;
			default: System.out.println("잘못입력하셨습니다...");
			}
		}
		
		public void topping(){
			 System.out.print("Q.피자에 올라갈 재료를(Toppings토핑을) 골라 주세요! "
				   		+ "1.파인애플(Pineapple) /"
				   		+ "2.체다치즈(Cheda Cheese) / "
				   		+ "3.감자(Potato) /"
				   		+ "4.새우(Shrimp)/ \nA.");
		   
			 Integer topping = scanner.nextInt();
			   
			switch(topping){
				case 1: this.price  += 3000; break;
				case 2: this.price  += 3000; break;
				case 3: this.price  += 5000; break;
				case 4: this.price  += 7000; break;
				default: System.out.println("잘못입력하셨습니다...");
			}
		}
		
		public void beverage(){
			
			System.out.print("Q.음료를(Beverage)골라 주세요! "
			   		+ "1.콜라 (Coke) / "
			   		+ "2.사이다 (Cider) / "
			   		+ "3.환타 Fanta(Orange)/"
					+ "4.안마심(No, thanks)  \n A.");
			Integer beverage = scanner.nextInt();
		    if(beverage != 4) {
		    	this.price += 1000;
		    	System.out.println(" Q.음료 사이즈? 1.500ml /  2.1L  /  3.1.5L \n A.");
		    	Integer beverSize = scanner.nextInt();
		    	
		    	switch(beverSize){
				case 1: this.price  += 0; break;
				case 2: this.price  += 500; break;
				case 3: this.price  += 1000; break;
				default: System.out.println("잘못입력하셨습니다...");
     			}	 
		    }
		}

		public void printTotal(){
			 System.out.println("총 가격은"+this.price +"입니다. 감사합니다♥");  
		}
}