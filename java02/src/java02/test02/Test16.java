/* Buffer의 사용
  한 바이트씩 데이터를 읽는것보다,
  여러바이트를 한꺼번에 읽는게 속도가 더 빠름
 
  이유: 데이터읽기 속도= Data Seek Time + Data Access Time
  예) 퀀텀하드
  Data Seek Time(데이터의 위치를 찾는 시간):4.2ms -> 0.0042sec
  Data Transfer time(데이터 전송 시간): 3Gb/sec=0.000003sec /1byte
 
  1byte 읽기시간 = 0.0042 + 0.000003=0.004203초 //0.0042면 전송시간보다 더 걸리는거지 배보다 배꼽이 더크다 야 무슨 -0-
  100byte읽기 시간 = 0.004203초 * 100초 = 0.4203초
  
  한번 찾을 때 100바이트 읽기= 0.0042 + (0.000003 * 100) = 0.0045초
  
  예전 메모리 (10ns) = 0.00000001초 
      = 1억 * 0.00000001초 =1초 
      = 1억 * 0.004203초  =  420300초 //하드디스크에서 읽어들이는 시간    4.8일
     
 */
package java02.test02;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class Test16 {
  //BufferedInputStream 도구 사용
  public static void main(String[] args) throws Exception {
    FileInputStream in =new FileInputStream("/home/bit/test.pdf");
    BufferedInputStream in2 = new BufferedInputStream(in);
    //8192byte사이즈의 기본 버퍼가잇긔

    int b = 0;
    long start = System.currentTimeMillis();
    while((b = in2.read())!=-1){    }//read에  buf배열의 주소를 준다.
    long end = System.currentTimeMillis();
    System.out.println(end-start);
    in.close();
  }
  
  
  
  //버퍼 사용 전
  public static void main01(String[] args) throws Exception {
    FileInputStream in =new FileInputStream("/home/bit/test.pdf");

    int b ;
    long start = System.currentTimeMillis();
    while((b = in.read())!=-1){    }
    long end = System.currentTimeMillis();
    System.out.println(end-start);
    in.close();
  }
  
//버퍼 사용 후
  public static void main02(String[] args) throws Exception {
    FileInputStream in =new FileInputStream("/home/bit/test.pdf");
    byte[] buf = new byte[1024];
    int len = 0;
    long start = System.currentTimeMillis();
    while((len = in.read(buf))!=-1){    }//read에  buf배열의 주소를 준다.
    long end = System.currentTimeMillis();
    System.out.println(end-start);
    in.close();
  }

}