/* QUIZ 
 파일을 복제하는 기능을 구현하세욤
 $Test02 /home/bit/javaide/workspace/java02/img1.jpg(엔터)
 =>img1.jpg파일을 복제하여 img1-01.jpg
 
 HINT 출력은 FileOutputStream 클래스를 사용
 */

package java02.test02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test02 {

  public static void main(String[] args) {
    FileInputStream in = null;
    FileOutputStream out = null;
    try {
      // 1. 입력스트림 객체를 준비한다.
      // 2. 현재 파일의 위치는 프로젝트 디렉토리다.
      in = new FileInputStream(args[0]);
      out = new FileOutputStream("img1-01.jpg");
      int count = 0;
      int b = -1;

      // 2.read()를 통해 "  1바이트    " 읽기!!!
      // 리턴 타입이 int라 해서 4바이트를 읽는건 아니다.
      while ((b = in.read()) != -1) {
        count++;
        out.write(b);
      } // 1byte return return -1면 못읽었다는구

      System.out.println("파일크기:" + count + "바이트입니당");
    } catch (FileNotFoundException ex) {
      System.out.println("img1.jpg 파일을 찾을 수 없습니다");
    } catch (IOException ex) {
      System.out.println("img1.jpg 파일을 찾을 수 없습니다");
    } finally {
      // read()중에 오류가 발생하면 close()를 호출도 못한당 ㅠㅠ
      // 그래서 자원을 해제하는 명령은 finally 블록에 두도록해라
      // 3.File이나 DB, socket등의 자원은 사용한 다음, 명시적으로 해제해야함
      try {
        in.close();
       
      } catch (IOException ex) {
      } // close하다 예외발생시 아무것도안한다.
      try{
        out.close();
      }catch(IOException ex){}
    }
  }
  
}
