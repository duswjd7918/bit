/*배열 - 같은 종류의 데이터를 여러개 저장할 수 있도록 메모리를 여러개 생성하는게지 ㅇㅇ
 *       new 데이터형[개수]
 *       new 데이터형[]{값,값,값};
 */

package java01;


public class Test13 {

	public static void main(String[] args) {
		//예전방식:4바이트 서로 독립되게 준비하는거구
		int kor, eng, math, sci, soc;
		
		kor = 100;
		eng = 80;
		math =34;
		sci = 35;
		soc = 67;
		
		
		
		
		
		
		//배열생성: 4바이트 메모리를 "연속'해서 준비하는거임
		//준비된 메모리의 "첫 바이트 주소"를 변수에 저장해야 한다.
		//이케 주소를 저장하는 변수 :  reference variable(참조변수)
		//C에서는 이걸 포인터라고 부르징 
		int[] scores = new int[5];    //int [scores] = new int[5];  //C방식도 허용 >.<O
	          //△주소변수                 //scores=new byte[7];//뻘짓 ㄴㄴ
		scores = new int[3];      //신규배열 3개 생성 및 주소할당 
									 //위에껀 쓸모없네 ㅃㅃ garbage collector가 수집해감 
									//덩그러니 남는 객체 garbage dangling object
	    scores[0] = 100;
	    scores[1] = 34;
	    scores[2] = 55;
	    
//	    scores[5] = 34;    //<-Runtime Exception :실행 중 발생하는 오류ERROR ! 
	    
	    
	    System.out.println("-----------------------------");
	    //배열 생성: 값을 초기화
	   //초기화를 수행할 때는 배열의 개수를 지정하지 않는당
	    scores = new int[]{100,90,100}; 
	    
	    for(int i=0; i<scores.length; i++){
	    	System.out.println(scores[i]);
	    }
	    
	    
	    //특수 "배열 객체" 생성
	    java.util.ArrayList arr = new java.util.ArrayList();
	    arr.add("홍길동");
	    arr.add(100);
	    arr.add(90);
	    arr.add(100);
	    arr.add(new java.util.Date());
	    
	    for(int i=0; i<arr.size(); i++){
	    	System.out.println(arr.get(i));
	    }
	}

}
