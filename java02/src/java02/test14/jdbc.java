package java02.test14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class jdbc {
  static Scanner scanner;
  static Connection con = null;
  static Statement stmt = null;
  static ResultSet rs = null;

  public static void main(String[] args) {

    try {

      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("JDBC 드라이버 로딩됨");

      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb"
          + "?useUnicode=true&characterEncoding=utf8", "study", /* 사용자 아이디 */
          "study"); /* 사용자 암호 */
      System.out.println("DBMS에 연결됨");

      stmt = con.createStatement();
      System.out.println("statement  객체 준비 완료.");

      loop: while (true) {
        try {

          System.out.print("명령> ");
          scanner = new Scanner(System.in);
          String[] token = scanner.nextLine().split(" ");
          // String[] token = promptCommand();
          String commandInfo = token[0];
          String index = "";

          if (commandInfo == null) {
            System.out.println("해당 명령을 지원하지 않습니다.");
            continue;
          } else if (token[0].equals("exit")) {
            break loop;

          } else {
            switch (commandInfo) {
            case "add":
              break;
            case "list":
              select();
              break;
            case "update":
              index = token[1];
              update(index);
              break;
            case "delete":
              index = token[1];
              delete(index);
              break;
            }
          }// else
        } catch (Exception e) {
          e.printStackTrace();
          System.out.println("명령어 처리 중 오류 발생. 다시 시도해 주세요.");
        }
      }
    } catch (Exception ex1) {
      ex1.printStackTrace();

    } finally {
      try {
        rs.close();
      } catch (Exception ex) {
      }
      System.out.println("ResultSet 객체의 자원을 해제함.");
      try {
        stmt.close();
      } catch (Exception ex) {
      }
      System.out.println("statement 객체의 자원을 해제함.");
      try {
        con.close();
      } catch (Exception ex) {
      }
      System.out.println("DBMS와 연결 끊음");
    }

  }

  private static void update(String index) {
    
    try {
      String PNAME = "", QTY = "", MKNO = "";

      rs = stmt.executeQuery("SELECT T1.PNAME, T1.QTY, T1.MKNO" + 
          " FROM PRODUCTS T1 WHERE T1.PNO="+index);
      while(rs.next()){
        PNAME = rs.getString("PNAME");
        QTY = rs.getInt("QTY") +"";
        MKNO = rs.getInt("MKNO") +"";
      }

      System.out.print("제품명(" + PNAME + ")? ");
      PNAME = scanner.nextLine();
      System.out.print("수량(" + QTY + ")? ");
      QTY = scanner.nextLine();
      System.out.print("제조사(" + MKNO + ")?" );
      MKNO = scanner.nextLine();
      System.out.print("변경하시겠습니까?(y/n) ");
      if (scanner.nextLine().equalsIgnoreCase("y")){


        stmt.executeUpdate("UPDATE PRODUCTS SET" +
            " PNAME='"+ PNAME +"', QTY=" + QTY +", MKNO=" + MKNO +
            " WHERE PNO=" + index);

        System.out.println("변경하였습니다");
      } else {
        System.out.println("변경 취소하였습니다");
      }

    } catch (Exception ex) {
      ex.printStackTrace();

    } finally {
      
    }
  }

  private static void delete(String index) {

    try {
      System.out.println(index +"가 삭제되었습니다.");
      stmt.executeUpdate("delete from PRODUCTS where PNO="
          + Integer.parseInt(index));
    } catch (SQLException e) {

      e.printStackTrace();
    }
  }

  private static void select() {

    try {
      rs = stmt.executeQuery("SELECT T1.PNO, T1.PNAME, T1.QTY, T2.MKNAME "
          + "from PRODUCTS T1 JOIN MAKERS T2 USING(MKNO)");

      int count = 0;
      System.out.println("번호. 제품명................. 수량..... 제조사명......");
      while (rs.next()) {

        System.out.printf("%3s %20s %7s %10s\n", rs.getString("T1.PNO"),
            rs.getString("T1.PNAME"), rs.getString("T1.QTY"),
            rs.getString("T2.MKNAME"));
      }
    } catch (SQLException e) {
      
      e.printStackTrace();
    }

  }
  /************************************************************/
  /*
   * stmt.executeUpdate("INSERT INTO PRODUCTS(PNAME, QTY,MKNO)"+
   * " VALUES('넥서스10',99,6)"); System.out.println("데이터 입력완료");
   *//************************************************************/
  /*
   * stmt.executeUpdate("UPDATE PRODUCTS SET" + " PNAME='넥서스10', QTY =999" +
   * " WHERE PNO=10");
   * 
   * System.out.println("데이터 변경완료");
   *//************************************************************/
  
}
