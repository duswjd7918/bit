/* Connection 객체 얻기
   =>java.sql.Driver 구현체를 통해서 얻을 수 있다.
    => 직접은 ㄴ ㄴ  DriverManager에게 부탁해라. 
    =>DriverManager가 우리를 대신해 java.sql.Driver가
 */
package java02.test14;

import java.sql.Connection;
import java.sql.DriverManager;

public class jdbc02 {

  public static void main(String[] args) {
    Connection con = null; //참조변수가 인터페이스일떄    인스턴스 주소 !를 담을 수 있는거라고 ..
    //인터페이스라서 new  Connection못하
    try{
    //방법1. java.sql.Driver 구현체 로딩한다.
    Class.forName("com.mysql.jdbc.Driver"); //""안에 문자열은 args로 받을 수 있잖음 ㅇㅇ
    System.out.println("JDBC 드라이버 로딩됨.");
    //방법2. DriverManager에게 Connection 객체를 부탁한다.
    
    //LoadBalanceMySQLConnection  (X)
    con = DriverManager.getConnection(
      "jdbc:mysql://localhost:3306/studydb",   //jdbc 접속을 위한 URL정보! DMBS마다 형식이 약간씩 다르당.
      "study",       //사용자 아이디
      "study");      //사용자 암호
    System.out.println("DBMS에 연결됨.");
    } catch(Exception ex) {
      ex.printStackTrace();
    } finally {
      try {con.close();} catch(Exception ex){}
       System.out.println("DBMS와 연결끊음..");
     }
  }

}
