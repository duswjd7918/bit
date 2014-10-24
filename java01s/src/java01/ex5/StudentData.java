package java01.ex5;

public class StudentData
{
   private int stuID;
   private String stuName;
   private int stuAge;

   StudentData(int id, String name, int age)
   {
 
       this.stuID = id;
       this.stuName = name;
       this.stuAge = age;
   }

   public int getStuID() {
       return stuID;
   }
   public String getStuName() {
       return stuName;
   }
   public int getStuAge() {
       return stuAge;
   }
   
}
