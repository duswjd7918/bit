package java02.test03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Test03 implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  static ArrayList<Score> list = new ArrayList<Score>();
  
  static class Score implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float average;
    
    Score(String name, int kor, int eng, int math){
     this.name = name;
     this.kor = kor;
     this.eng = eng;
     this.math = math;
     this.sum = kor + eng + math;
     this.average = sum / 3.0f;
    } 

  }  
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in); 
    
    
    try{
      FileInputStream in = new FileInputStream("score.dat");
      DataInputStream in2 = new DataInputStream(in);
      
      for (int i = 0; i < in2.available(); i++){
        Score score = new Score(in2.readUTF(), in2.readInt(), in2.readInt(), in2.readInt());
        list.add(score);
      }
      
      in2.close();
      in.close();
      
    }catch(FileNotFoundException ex) {
      System.out.println("저장된 파일을 찾지 못하였습니다.");
    }//try
    
    while(true){
      System.out.print("명령 > ");
      String input = scanner.nextLine();
     
      String[] command = input.split(" ");      
      
      switch(command[0]){
      case "help" : help(); break;
      case "add" : add(command[1],Integer.parseInt(command[2]),
                        Integer.parseInt(command[3]),Integer.parseInt(command[4]));break;
      case "list" : list();break;
      case "delete" : delete(Integer.parseInt(command[1]));break;
      case "view" : view(Integer.parseInt(command[1]));break;
      case "update" :update(Integer.parseInt(command[1])); break;
      case "exit" : exit();break;
      default: System.out.println("명령어 똑바로 입력해!!!");
      
      }
      
    }
    
    
  }//main
  
  
  static void help(){
    System.out.println("list \nview 인덱스 \nadd 이름 국어 영어 수학\n"
        + "delete 인덱스\nupdate 인덱스\nexit\n");
  }
  static void add(String name, int kor, int eng, int math){
    list.add(new Score(name,kor,eng,math));
    System.out.println("저장되었습니다.");
  }
  static void list(){
    Score score;
    
    for (int i = 0; i < list.size(); i++) {
      score = list.get(i);
      System.out.println(i+"\t"+score.name+"\t"+score.kor+"\t"+score.eng+"\t"+score.math
          +"\t"+score.sum+"\t"+score.average);
    }
  }
  static void delete(int index){
    Scanner scanner = new Scanner(System.in);

    Score score;
    
    if (index < list.size()){    
      score = list.get(index);
      System.out.println(score.name + "의 성적을 삭제하시겠습니까?( Y / N )");
      String option = scanner.nextLine();

            if(option.equalsIgnoreCase("y")){
              list.remove(index);
              System.out.println("지워졌어요!");
            }else if(option.equalsIgnoreCase("n")){
              System.out.println("변경 취소하였습니다.");
            }


    } else {
      System.out.println("존재하지 않는 인덱스입니다.");
    } 
  }
 
  static void view(int index){
    Score score;
    score = list.get(index);
    System.out.println("인덱스: " +index+
        "\n이름: "+score.name+
        "\n국어: "+score.kor+
        "\n영어: "+score.eng+
        "\n수학: "+score.math+
        "\n합계: "+score.sum+
        "\n평균: "+score.average
        );
  }
  static void update(int index){
    Scanner scanner = new Scanner(System.in);
    Score score;
    score = list.get(index);
    String backupName;
    int backupKor;
    int backupEng;
    int backupMath;
    
    System.out.println("이름("+score.name+")? ");
    String name=scanner.nextLine();
    
    
    if(!name.equals("")){
      backupName = score.name;
      score.name = name;
    }else{
      backupName = score.name;
    }
    
    
    
    System.out.println("국어("+score.kor+")? ");
    String korInput=scanner.nextLine();
    if(!korInput.equals("")){
      int kor = Integer.parseInt(korInput);
      backupKor = score.kor;
      score.kor = kor;
    }else{
      backupKor = score.kor;
    }
    
    
    System.out.println("영어("+score.eng+")? ");
    String engInput=scanner.nextLine();
    if(!engInput.equals("")){
      int eng = Integer.parseInt(engInput);
      backupEng = score.kor;
      score.eng = eng;
    }else{
      backupEng = score.eng;
    }
    
    System.out.println("수학("+score.math+")? ");
    String mathInput=scanner.nextLine();
    if(!mathInput.equals("")){
      int math = Integer.parseInt(mathInput);
      backupMath = score.math;
      score.math = math;
    }else{
      backupMath = score.math;
    }
    
    
    System.out.print("정말 변경하시겠습니까?(Y/N)  ");
    String option = scanner.nextLine();
    if (option.equalsIgnoreCase("Y")){
      score.sum=score.kor+score.eng+score.math;
      score.average = score.sum/3.0f;
      return;
    }else if(option.equalsIgnoreCase("N")) {
      score.name = backupName;
      score.kor = backupKor;
      score.eng = backupEng;
      score.math = backupMath;
      
    }else {
      System.out.println("잘못된 명령입니다!");
    }
    
   
    
    
    
  }
  
  
  static void exit() throws IOException{
    FileOutputStream out = new FileOutputStream("score.dat");
    DataOutputStream out2 = new DataOutputStream(out);
    
    for(int i = 0; i < list.size(); i++) {
      out2.writeUTF(((Score)list.get(i)).name);
      out2.writeInt(((Score)list.get(i)).kor);
      out2.writeInt(((Score)list.get(i)).eng);
      out2.writeInt(((Score)list.get(i)).math);

    }
       
    out2.close();
    out.close();
    
    System.out.println("시스템이 종료 되었습니다.");
    System.exit(0);
  }
}














