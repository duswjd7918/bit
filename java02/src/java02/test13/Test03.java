package java02.test13;

public class Test03 {

  public static void main(String[] args) {
    //인터페이스를 구현한 익명 이너 클래스 만들기
    //일반 문법!
    class MyClass2 extends Object implements MyInterface {

      @Override
      public void m2() {
        System.out.println("ha ha ha");
        
      }
            
    }
    
    
    //snapshot 1: class명 제거  &&  class 키워드 제거
   /* extends Object implements MyInterface {

      @Override
      public void m2() {
        System.out.println("ha ha ha");
        
      }
            
    }*/
    
    
    //snapshot 2: Object상속문법생략
    // Object를 상속 받지 않으면 자동으로 상속받기 땜에Object생략
    /*implements MyInterface {

      @Override
      public void m2() {
        System.out.println("ha ha ha");
        
      }
            
    }*/

    //snapshot 3: implements 키워드생략
    /*MyInterface  {

      @Override
      public void m2() {
        System.out.println("ha ha ha");
        
      }
            
    }*/
    
    //snapshot 4: instance 생성 명령어 결함
    new MyInterface(){//<-구 현 할   interface이름
      @Override
      public void m2() {
        System.out.println("ha ha ha");
        
      }
      
    }.m2();
  }

}
