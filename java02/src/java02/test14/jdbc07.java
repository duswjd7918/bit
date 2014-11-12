/* 
  Insert  실행! ♡
  
  executeUpdate()호출한다.
  
 앗!!! linux에서 한글값 깨질 수 있다. 
  해결책=> 연결 정보에 문자 집합을 설정해야한다.
  JDBC URL에 설정한다.
  ex. jdbc:mysql://host:port/schema?useUnicode=true&characterEncoding=utf8
 */
package java02.test14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbc07 {

  public static void main(String[] args) {
    Connection con = null;
    Statement stmt = null;
//    ResultSet rs = null;
    try {
    
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("JDBC 드라이버 로딩됨");
      
  
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/studydb"
          +"?useUnicode=true&characterEncoding=utf8", 
          "study", /* 사용자 아이디 */
          "study"); /* 사용자 암호 */
      System.out.println("DBMS에 연결됨");
      
    
     stmt = con.createStatement();
     System.out.println("statement  객체 준비 완료.");
     
    stmt.executeUpdate("INSERT INTO PRODUCTS(PNAME, QTY,MKNO)"+
    " VALUES('넥서스10',99,6)");
     System.out.println("데이터 입력완료");
      
    } catch (Exception ex) {
      ex.printStackTrace();
      
    } finally {
     
      try {stmt.close();} catch (Exception ex) {}
      System.out.println("statement 객체의 자원을 해제함.");
      try {con.close();} catch (Exception ex) {}
      System.out.println("DBMS와 연결 끊음");
    }
  }

}
