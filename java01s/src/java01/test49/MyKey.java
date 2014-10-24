/* <<Object Class>>
  -hashCode():인스턴스 별로 고유 값을 리턴
  -equals(): 같은 인스턴스인지 비교(true/false)
  
  Map에 값을 저장할 때 키로 사용할 클래스라면 반드시 그 클래스는 hashCode()와 equals()를 재정의 해야함
  
  String+ 랩퍼클래스(Byte Short Integer Long Float Double)
   -> 기본적으로 hashCode()와 equals()와 toString()등을 재정의 하였다. 아래와같이!
      -> hashCode():인스턴스에 저장된 값이 같다면 같은 hash값을 리턴한다.
      -> equals()  :인스턴스에 저장된 값이 같다면 true리턴
      -> toString():인스턴스의 내용을 출력하도록 재정의함 
       즉, 클래스@hash를 출력하지 않음
      ->finalize():가비지 컬렉터가 가비지를 해제하기 전에 호출.
 */

package java01.test49;

public class MyKey {
	String password;
	int specialNo;
	int secretNo;
	
	public MyKey(String password, int specialNo, int secretNo){
		this.password = password;
		this.specialNo= specialNo;
		this.secretNo = secretNo;
	}
	
	@Override
	public String toString() {
		return "MyKey [password=" + password + ", specialNo=" + specialNo
				+ ", secretNo=" + secretNo + "]";
	}
	
	//password specialNo secret값이 모~두 같을 때는 같은 해시값을 리턴하도록 hashCode()를 재정의 한다.
	@Override
	public int hashCode() {
		String temp = this.toString();
				return temp.hashCode();
	
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		
		if(!(obj instanceof MyKey)) return false; //MyKey의 인스턴스 주소니?
		
		MyKey other = (MyKey) obj;
		if(this.password.equals(other.password) &&
			this.secretNo == other.secretNo &&
			this.specialNo == other.specialNo) {
			return true;
		}
		return false;
	}
	
}
