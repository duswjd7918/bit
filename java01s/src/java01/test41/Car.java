package java01.test41;

public class Car {

		String maker;
		String model;
		int cc=800;
		boolean diesel;
		java.util.Date releaseDate;
		int capacity=5;
		
		  //기본생성자 無 - > Truck의 super() 안돼안돼~
		
		public Car(String maker, String model, int cc){
			this.maker = maker;
			this.model = model;
			this.cc = cc;
			
		}
}
