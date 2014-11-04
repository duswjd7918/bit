/* 문자데이터 읽기!
  FileReader          charset된문자를정확히읽어유니코드로변환
   -text파일을 문자 스트림 객체를 사용하여 읽기   
   -read() : 한 문자 단위로 읽는다. 바이튼ㄴㄴ
   한 문자...란...?  영어(1). 한글(2 ~ 3)byte ...
   문자 스트림은 읽어들인 데이터를 "유니코드"로 변환한다.
 */

package java02.test02;

import java.io.FileReader; //<-    ctrl + shift + o

public class Test08 {

  public static void main(String[] args) throws Exception {
    FileReader in = new FileReader("test01.txt");
    int b = -1;
    while((b=in.read()) != -1) {//읽었다면
      System.out.println(Integer.toHexString(b));// 한글읽음 3byte
    
    }
    in.close();

  }

}
