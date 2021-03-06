/* 서브 클래스의 인스턴스 생성과정
 -수퍼클래스의 명령어에 따라 먼저 인스턴스를 변수를 생성한 다음에
 -서브 클래스의 명령어에 따라 인스턴스 변수를 생성한다.
 */ 
  package java01.test41;
 

public class test41 {

	public static void main(String[] args) {
		Car c1 = new Car("현다이","마구타",1997);
		Car c2 = new Car("가이아","M5",2500);
		
		Truck t1 = new Truck();//기본 생성자 호출=default constructor.
		
		/*인스턴스 변수 준비 과정
		1) Car클래스에 선언된 대로 인스턴스 변수를 준비한다.
     		maker, model, cc , diesel, releaseDate,capacity
		1) Truck클래스에 선언된 인스턴스 변수 준비
    		weight
        2) 각 인스턴스 변수는 0으로 초기화 된다.
         -byte,short,int,long   모든비트0
         -float, double = >0.0=>모든비트0
          -char = >'\u0000'   =>모든비트0
           -boolean=>flase=>모든비트0
           -reference->null=>모든 비트0
		3 ) 초기화 문장수행 (super class명령어 부터 실행!!and then sub)
		4) 생성자 호출(Truck()호출 -> Car()호출)
		 */
	/*	
	   1)인스턴스 변수준비
	[maker][model][cc ][diesel][releaseDate][capacity][weight][autoDump]
	
	    2)인스턴스 변수를 0으로 초기화
	[0    ][0    ][0  ][0     ][null(0)    ][0       ][0.0   ][false   ]
	    
	    3)Car class의 초기화 문장 수행
	[0    ][0    ][800][0     ][null(0)    ][5       ][0.0   ][false   ]
		  Truck class의 초기화 문장 수행
	[0    ][0    ][800][0     ][null(0)    ][5       ][1000.0][false   ]
	
		4)Truck 클래스 생성자 호출하는 즉시 Car 생성자 호출( super())
	["미정" ]["미정" ][800][0      ][null(0)    ][5       ][1000.0][false   ]
	     Truck 클래스 생성자 실행
	["미정" ]["미정" ][800][0      ][null(0)    ][5       ][1000.0][true    ]
	*/
	}

}
