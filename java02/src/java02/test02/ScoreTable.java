package java02.test02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreTable {
  static ArrayList list = new ArrayList();
  
  static class Score {
   String name;
   int kor;
   int eng;
   int math;
    int sum = kor+eng+math;
    float average = sum/3.0f;
    Scanner scanner = new Scanner(System.in);
    
   
  
   Score(String name, int kor, int eng, int math){
     this.name = name;
     this.kor = kor;
     this.eng = eng;
     this.math = math;
     this.sum = kor+eng+math;
     this.average = sum/3.0f;
               
    }//Score
 }//Score class
   
  static void help(){
    System.out.println("list\nview 인덱스\nadd 이름 국어 영어 수학\n"
        + "delete 인덱스\nupdate 인덱스 \nexit\n");
  }//help
  
  static void addA(String name, int kor, int eng, int math) {
    //ArrayList list = new ArrayList();
    //Score score= new Score(name, kor, eng, math);
    list.add(new Score(name, kor, eng, math));
    System.out.println(list);
    System.out.println("저장되었습니다.\n");
   
  }//add
  
  static void list(){
    Score score ;
    for(int i=0;i<list.size(); i++){
    score = (Score) list.get(i);
    System.out.println(i+"\t"+score.name+"\t"+score.kor+"\t"+score.eng+"\t"+score.math);
    }
  }//list
  
  static void delete(int index){
    list.remove(index);
    System.out.println("삭제되었엉숌");
  }//delete
  
  static void view(int index){
    Score score =(Score) list.get(index);
    System.out.println("인덱스: "+index+"\n"
        +"이름: "+ score.name+"\n"
        +"국어: " +score.kor+"\n"
        +"영어: " +score.eng+"\n"
        +"수학: " +score.math+"\n"
        +"합계: " +score.sum+"\n"
        +"평균: " +score.average+"\n"
        
        );

  }//view
  
  static void update(int index){
    Scanner scanner = new Scanner(System.in);
    Score score =(Score) list.get(index);

    
    
    System.out.print("이름("+ score.name+")?");
    String name = scanner.nextLine();
    if(!name.equals("\n")){
      score.name = name;
    } else {
      return;
    }
    
    System.out.print("국어("+ score.kor+")?");
    String kor = scanner.nextLine();
    int korInput = Integer.parseInt(kor);
    if(!name.equals("\n")){
      score.kor = korInput;
    } else {
      return;
    }
    
    System.out.print("영어("+ score.kor+")?");
    String eng = scanner.nextLine();
    int engInput = Integer.parseInt(eng);
    if(!eng.equals("\n")){
      score.eng = engInput;
    } else {
      return;
    }
    
    System.out.print("수학("+ score.math+")?");
    String math = scanner.nextLine();
    int mathInput = Integer.parseInt(math);
    if(!math.equals("\n")){
      score.math = mathInput;
    } else {
      return;
    }
    
    System.out.print("증말 변경할꾸야?(y/n)");
    String real = scanner.nextLine();
    if(real.equals("y")){
      
    } else {
      return;
    }
  }//update
    
  void exit() throws FileNotFoundException {
    FileOutputStream out = new FileOutputStream("score.dat");
  }//exit
  
  
  
  
  
  
  public static void main(String[] args) {
    
  
    int index=0;
    while(true){
     System.out.print("명령> ");
     Scanner scanner = new Scanner(System.in);
     String input = scanner.nextLine();
     String[] command = input.split(" ");
    
     switch(command[0]){
     case "help":  help(); break;
     case "add" : 

       addA(command[1], Integer.parseInt(command[2]), 
           Integer.parseInt(command[3]), Integer.parseInt(command[4])); 
       System.out.println(list.get(0));
       break;
     case "list": list();break;
     case "delete" : delete(Integer.parseInt(command[1]));break;
     case "view" : view(Integer.parseInt(command[1]));break;
     case "update" :update(Integer.parseInt(command[1])); break;
     default: System.out.println("명령어 제대로 입력해라");
     }//switch

    }//while
   }//main



}//Score Table