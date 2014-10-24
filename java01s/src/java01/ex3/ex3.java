package java01.ex3;

public class ex3 {

	public static void main(String[] args) {
				
		byte pb = 20;
		Byte b = new Byte(pb);
		Byte b2 = 40;
		Byte b3 = new Byte((byte) 60);
		
		String s = b.toString();
		Integer i =Integer.parseInt(s);
		Integer i2 =new Integer(20);
		
		System.out.println("i와i2 값이 같니 ? "+i.equals(i2)); //true
		Long l = new Long(20);
		Float f =new Float(20.0f);
		Character c =new Character('A');
		
		System.out.println("b = " + b);    //20
		System.out.println("b3 = " + b3);  //60
		System.out.println("s ="  + s); //20
	}

}
