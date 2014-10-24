package java01.test51;

class MyStack{ 
	Object[] list = new Object[100];
	int top=0;
	 
	public void push(Object value){
		
		list[top]=value;
		++top;
		
	}
	//마지막에 입력한 값을 꺼낸다.
	public Object pop(){
		
		list[top]=null;
		--top;
		return list[top];
	}
	
}
class MyQueue {
	class Bucket{
		Object value;
		Bucket next;
	}
	
	Bucket start;
	Bucket end;
	
	public MyQueue(){
		start = new Bucket();
		end = start;
		
	}
	
	public void add(Object value){
		end.value = value;
		System.out.println(end.value);
		end.next = new Bucket();
		end = end.next;
		
	}
	//첫번재 입력 값을 꺼낸다.목록에서 제거됨.
	public Object poll(){
		Object temp = start.value;
		start = start.next;
		return temp;
	}
}
public class CollectionTest08 {

	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push("0000");
		stack.push("1111");
		stack.push("2222");
		stack.push("3333");
		for(int i=0; i <4; i++){
			System.out.println(stack.list[i]);
		}
		
		System.out.println("위에는 push후  아래는 pop후");
		for(int i=0; i <4; i++){
			System.out.println(stack.pop());
		}
				/*
		 * 3333
		 * 2222
		 * 1111
		 * 0000
		 * */
	
		System.out.println("-------------*-------------");
		MyQueue queue = new MyQueue();
		queue.add("aaaa");
		queue.add("bbbb");
		queue.add("cccc");
		queue.add("dddd");
		
		
		System.out.println("위는:Queue를 add후,    아래는:  poll후");
		for(int i=0; i <4; i++){
			System.out.println(queue.poll());
		}
		
		/*
    	 aaaa
		 bbbb
		 cccc
		 dddd
		 */
	
	
	
	}
	

}
