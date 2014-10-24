package java01.ex4;

public class Profile {
	 String name = "YeonjungBae";
	 double birthDay = 19920520;
	 double today = 20141020;
	 double age ;
	 
	 protected void getAge(){
		 this.age= ((this.today - this.birthDay)/10000)+1.0;
	 }
	 
	 protected String getData() {
		 getAge();
		 return (this.name + "'s age : " +this.age);
	 }

	protected void setData(String name, double birthDay, double today) {
		this.name = name;
		this.birthDay = birthDay;
		this.today = today;
	}
	
	
}