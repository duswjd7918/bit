package java01.ex4;

public class ex4 {

	public static void main(String[] args) {
		Profile p1 = new Profile();
		Profile p2 = new Profile();

		System.out.println(p1.getData());
		//이름, 생년월일(YYYYMMDD), 오늘날짜(YYYYMMDD)
		p2.setData("JisungPark",19810225, 20141020);
		System.out.println(p2.getData());
		
	}

}
