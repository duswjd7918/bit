package java01.test53.step05;

public class GeneralIterator extends Iterator {
	
	int cursor;
	public GeneralIterator(){		
	}
/*	public GeneralIterator(String[] list){
		this.list = list;
		
	}
	public void setList(String[] list)
	{	
		this.list = list;
	}*/
	public boolean hasNext(){
		if(cursor < list.length)	return true;
		else return false;
	}

	public String next(){
		return list[cursor++];		
	}

}
