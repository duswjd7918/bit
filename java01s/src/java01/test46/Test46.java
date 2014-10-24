package java01.test46;

public class Test46 {

	public static void main(String[] args) {
		/*ClassA obj1 = new ClassA();
		System.out.println(obj1.i);*/
		
		ClassB obj2 = new ClassB();
		System.out.println(obj2.i);//ClassA에 있던..
		System.out.println(obj2.j);//ClassB에 있던
		System.out.println(obj2.x);
	
	}

}
