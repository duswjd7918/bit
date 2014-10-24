package java01.ex6;

public class Cube {

	int length;
	int breadth;
	int height;
	public int getVolume() {
		return (length * breadth * height);
	}
	Cube() {
		this(10, 10);
		System.out.println("Cube()");//:Finished with Default Constructor
	}
	Cube(int l, int b) {
		this(l, b, 10);
		System.out.println("Cube(@,@)");//:Finished with Parameterized Constructor having 2 params"
	}
	Cube(int l, int b, int h) {
		length = l;
		breadth = b;
		height = h;
		System.out.println("Cube(@,@,@)");//:Finished with Parameterized Constructor having 3 params");
	}
}
