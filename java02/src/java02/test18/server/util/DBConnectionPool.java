package java02.test18.server.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class DBConnectionPool {
  String driver;
  String url;
  String username;
  String password;
 
  ArrayList<Connection> conList= new ArrayList<>(); //connection 객체를 보관할 바구니준비
  
  public DBConnectionPool(String driver, String url, String username,
      String password) throws Exception {
    this.driver = driver;
    this.url = url;
    this.username = username;
    this.password = password;
  
    Class.forName(driver);
   }
  
  public Connection getConnection() throws Exception { //얻어
    if(conList.size() > 0){
      return conList.remove(0); //conLi의 첫번째꺼 리턴  맨앞
    } else{//없다면 새거 만들어라ㅏ
      return DriverManager.getConnection(url,username,password);
    }
  }
  
  public void returnConnection(Connection con) { //반납해!
   try{ 
    if(!con.isClosed()) {//검사  close되지 않았다면
     conList.add(con);
    }
   }catch(Exception ex) {}
  }
  
  public void closeAll(){
    for(Connection con : conList)
    try{      con.close();    } catch(Exception e){ }
    
  }
  
  
}
