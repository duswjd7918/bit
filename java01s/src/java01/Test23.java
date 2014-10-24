package java01;

public class Test23 {
	public static void main(String[] args) {
		long startMillisSec = System.currentTimeMillis();
	
		int x=0;
		do{
			x+=4;
			if(x%4==0){
				System.out.print(x+",");
				if(x%20==0){
					System.out.println();
					if(x%60==0){System.out.print("@");}
				}
			}
		}while(x<100);
		

		long endMillisSec = System.currentTimeMillis();
		System.out.println(endMillisSec-startMillisSec);
	}
}
