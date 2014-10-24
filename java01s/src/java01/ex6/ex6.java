package java01.ex6;

public class ex6 {

	public static void main(String[] args) {
		Cube cubeObj1= new Cube();
		Cube cubeObj2 = new Cube(10, 20, 30);
		System.out.println("Volume of Cube1 is : " + cubeObj1.getVolume());//1000
		System.out.println("Volume of Cube2 is : " + cubeObj2.getVolume());//6000
	}
}
