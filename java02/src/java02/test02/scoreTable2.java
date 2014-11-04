package java02.test02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

 

public class scoreTable2 implements Serializable {

  private static final long serialVersionUID = 1L;
  
  static ArrayList<Score> list = new ArrayList<Score>();

  static class Score implements Serializable {
    
    private static final long serialVersionUID = 1L;
    String name;
    int kor; 
    int eng;
    int math;
    int sum = kor+eng+math;
    float average = sum/3.0f;

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
    
      list.add(new Score(name, kor, eng, math));
       System.out.println("저장되었습니다.\n");   
        
  }//add  

  static void list(){
    Score score ;
    if (list.size() != 0){
      for(int i=0;i<list.size(); i++){
        score =list.get(i);
        System.out.println(i+"\t"+score.name+"\t"+score.kor+"\t"+score.eng+"\t"+score.math);
      }
    } else {
      System.out.println("저장한 점수가 없습니즘");
      return;
    }
  }//list

  

  static void delete(int index){

    if (index < list.size()){
      list.remove(index);
      System.out.println("삭제되었엉숌");
    } else if (index >= list.size()) {
      System.out.println("파일이 없숌");
    }
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

    String backupName;
    int backupKor;
    int backupEng;
    int backupMath;
    
    Score score =(Score) list.get(index);
    

    System.out.print("이름("+ score.name+")?");
    String name = scanner.nextLine();

    if(!name.equals("")){
      backupName = score.name;
      score.name = name;
    } else {
      backupName = score.name;
    }

    

    System.out.print("국어("+ score.kor+")?");
    String kor = scanner.nextLine();

    if(!kor.equals("")){
      int korInput = Integer.parseInt(kor);
      backupKor = score.kor;
      score.kor = korInput;
    } else {
      backupKor = score.kor;
    }

    

    System.out.print("영어("+ score.eng+")?");
    String eng = scanner.nextLine();


    if(!eng.equals("")){
      int engInput = Integer.parseInt(eng);
      backupEng = score.eng;
      score.eng = engInput;
    } else {
      backupEng = score.eng;
    }

    

    System.out.print("수학("+ score.math+")?");
    String math = scanner.nextLine();

    if(!math.equals("")){
      int mathInput = Integer.parseInt(math);
      backupMath = score.math;
      score.math = mathInput;
    } else {
      backupMath = score.math;
    }

    
    System.out.print("증말 변경할꾸야?( Y/ N )");
    String real = scanner.nextLine();

    if(real.equalsIgnoreCase("y")){
      System.out.println("변경 되었습니다.");
    } else {
      score.name = backupName;
      score.kor = backupKor;
      score.eng = backupEng;
      score.math = backupMath;
      System.out.println("변경이 취소되었습니다.");
    }

  }//update

    

  static void exit() throws Exception {
    
    Scanner scanner = new Scanner(System.in);
    System.out.print("종료하시겠습니까?\n 저장 후 종료 : 1\n 저장하지 않고 종료 : 2\n 돌아가기 : 3\n");
    
    String option = scanner.nextLine();
    
    if (option.equals("1")){
      
      FileOutputStream out = new FileOutputStream("score.dat");
      ObjectOutputStream out2 = new ObjectOutputStream(out);
        
      out2.writeObject(list);
   
      System.out.println("저장되었습니다.");
      System.out.print("시스템이 종료됩니다. Bye Bye");
   
      out2.close();
      out.close();
    
      System.exit(0);
    
    } else if(option.equals("2")){
      
      System.out.println("파일을 저장하지 않았습니다.");
      System.out.println("시스템이 종료됩니다. Bye Bye");
      
      System.exit(1);
      
    } else if (option.equals("3")) {
      
      System.out.println("시스템 종료하지 않습니다.");
      
    } else {
      
      System.out.println("잘못된 입력입니다.");
      exit();
    }
  } //exit
  
  
  
  
  public static void main(String[] args) throws Exception {
    
    try{
      FileInputStream in = new FileInputStream("score.dat");
      ObjectInputStream in2 = new ObjectInputStream(in);
     
      list = (ArrayList<Score>)in2.readObject();
      
      in2.close();
      in.close();
   } catch(Exception ex) {
      System.out.println("현재 저장되어있는 점수표가 존재하지 않습니다. \n ");
   } 
    while(true){
     System.out.print("명령> ");
     Scanner scanner = new Scanner(System.in);
     String input = scanner.nextLine();
     String[] command = input.split(" ");
    
     switch(command[0]){
     case "help":  help(); break;
     case "add" : 
         try{
       addA(command[1], Integer.parseInt(command[2]), 
           Integer.parseInt(command[3]), Integer.parseInt(command[4])); 
         }catch(ArrayIndexOutOfBoundsException arrayEx){
           System.out.println("잘못 입력했잖앙!"+arrayEx.getMessage());
           } catch(NumberFormatException numEx){
             System.out.println("잘못 입력했잖앙!"+ numEx.getMessage());
           }
       break;
     case "list": list();break;
     case "delete" : delete(Integer.parseInt(command[1]));break;
     case "view" : try{
                       view(Integer.parseInt(command[1]));
                   }catch(IndexOutOfBoundsException indexEx){
                       System.out.println("index를 잘 주셔야죠   ~"+(list.size()-1)+"까지");
                   }break;
     case "update" :update(Integer.parseInt(command[1])); break;
     case "exit" : exit(); break;
     default: System.out.println("명령어 제대로 입력해라- 3-");
     }//switch

    }//whiletrue
    
   }//main
  
  
 }//scoreTable <3