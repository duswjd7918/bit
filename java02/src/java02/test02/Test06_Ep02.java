/*재귀호출의 이해*/

package java02.test02;

public class Test06_Ep02 {

  //QUIZ: 1부터 50까지 sum - 함수호출
  public static void main(String[] args) {
   
    System.out.println(f(50));
    
  }
  public static int f(int no){
       if(no==1){
         return no;
         }
       else{      
         return no + f(no-1); 
        }
  }

  
}
