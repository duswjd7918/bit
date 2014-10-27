/*예외처리를 위한 문법이 없었을 때   long long time ago...
 * 메서드의 리턴값을 통해 호출자에게 예외상황을 알렸다.
 * 따라서 호출자는 늘 리턴값을 검사해야 했다.
 * 
 * => 늘 메서드의 리턴 값을 체크하는 if문이 존재했고...
 *  작업코드와 에러처리코드가 뒤 섞여 있다...
 *  =>레알 문제는 리턴값이 때로는  실제 결과있을 수 있당.  divide(999999,-1)
 * */
package java02.test01;

public class Exception01 {
  public static float divide(float a, float b){
    if(b==0){ //예외상황 발생
      return -999999.0f; //특별한 값 리턴
    }
    return a / b;
  }
  
  
  public static void main(String[] args) {
   float result = divide(10,0);
   if(result != -999999.0f) {
    System.out.println("결과는 : "+result);  //작업코드
   } else {
     System.out.println("계산 중 오류 발생!");//에러처리코드
   }
  }

}
