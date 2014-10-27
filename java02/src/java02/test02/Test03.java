/*            Quiz
 * 예외처리강화
 * 1) 파일이 존재하지 않으면, 다음 문장 출력
 *  xxxx.xxx파일이 존재하지 않습니다.
 * 2)디렉토리라면
 * xxxx.xxx는 파일이 아니라 디렉토리입니다.
 *
 * 파일 쓸 때,
 * 1) 파일이 이미 존재한다면,
 * xxxx.xxx 파일이 이미 존재합니다. 덮어쓰시겠습니다?(y/n) y
 *             xxxx.xxx.파일을 출력하였습니다.
 * 2)파일이 존재하지 않는다면, 
 * xxxx.xxx파일을 출력하였습니다.
 * 
 * */

package java02.test02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test03 {

  public static void main(String[] args) {
   File f =new File("/home/bit/git/bit/java02/img1.jpg"); //실질주소는f로
    String fileName = f.getName();
    int pos = fileName.lastIndexOf(".");//pos = 4
     
    
    
    
    FileInputStream in = null;
    FileOutputStream out = null;
    try{
      in = new FileInputStream(args[0]); 
   
      int index = args[0].lastIndexOf('.');
      String newFileName = args[0].substring(0, index) + "-01" + args[0].substring(index);
      
      out = new FileOutputStream(newFileName);
      
      int b = 1;
      while ((b = in.read()) != -1 ) {
      
        out.write(b);
      } 
    } catch (FileNotFoundException ex) {
      System.out.println("img1.jpg 파일을 찾을 수 없습니다.");
    } catch (IOException ex) {   
      System.out.println("읽기 오류!");
          
    } finally {
      try {in.close();} catch (IOException ex) {}
      try {out.close();} catch (IOException ex) {}
    }
  }

}
