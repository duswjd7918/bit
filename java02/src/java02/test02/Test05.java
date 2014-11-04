/* File 기본 사용!*/
package java02.test02;

import java.io.File;

public class Test05 {

  public static void main(String[] args) throws Exception {
    File f = new File("../../bit/java01s");
  //결과:    /home/bit/git/bit/java02/../../bit/java01s
    System.out.println(f.getAbsolutePath());
    
  //결과:   home/bit/git/bit/java01s 실제움직여짐
    System.out.println(f.getCanonicalPath());
    
  //결과:   ../../bit/java01s
    System.out.println(f.getPath()); 
    
    //결과 :   java01s
    System.out.println(f.getName()); 
  
    //결과:    ../../bit
    System.out.println(f.getParent()); 
  }
}
