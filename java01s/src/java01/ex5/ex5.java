package java01.ex5;

public class ex5{
   public static void main(String args[]){
   
       StudentData myobj1 = new StudentData(1,"YeonjungBae",23);
       System.out.println("Student Name is: "+myobj1.getStuName());
       System.out.println("Student Age is: "+myobj1.getStuAge());
       
       StudentData myobj2 = new StudentData(2, "SujiBae", 21);
       System.out.println("Student Name is: "+myobj2.getStuName());
       System.out.println("Student Age is: "+myobj2.getStuAge());
   
       StudentData myobj3 = new StudentData(3, "DoonaBae", 36);
       System.out.println("Student Name is: "+myobj3.getStuName());
       System.out.println("Student Age is: "+myobj3.getStuAge());
       
       System.out.println("나이 제일 많은 사람은...");
       	
       	if(myobj1.getStuAge() > myobj2.getStuAge()){
       			if(myobj1.getStuAge() > myobj3.getStuAge()){
       				System.out.println(myobj1.getStuName());
       			} else System.out.println(myobj3.getStuName());
           } else {
        	   		if(myobj2.getStuAge() > myobj3.getStuAge()){
        	   			System.out.println(myobj2.getStuName());
        	   		} else System.out.println(myobj3.getStuName());   		
           	}
     
    }
}