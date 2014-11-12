/* update
 * 
 * executeUpdate(SQL)호출하면돼 ^____________^ ~
 */
package java02.test14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbc08 {

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
     
    stmt.executeUpdate("UPDATE PRODUCTS SET" + 
        " PNAME='넥서스10', QTY =999" +
        " WHERE PNO=10");
     
    System.out.println("데이터 변경완료");
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
