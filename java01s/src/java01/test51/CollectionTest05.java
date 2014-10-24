/* LinkedList 데이터 구조 2
 - insert()와 remove() 구현
 */
package java01.test51;



/* 버킷 관리 */
class MyLinkedList2 {
  class Bucket {
    Object value;
    Bucket next;
  }
  
  Bucket start;
  Bucket end;
  int size;
  Bucket cursor;/////////내가만듬ㄷ ㄷ ㄷ ㄷ ㄷ ㄷ 
  public MyLinkedList2() {
    start = new Bucket();
    end = start;
  }
  
  public int add(Object value) {
    end.value = value;
    end.next = new Bucket();
    end = end.next;
    return ++size;
  }

  public int size() {
    return size;
  }
  
  public Object get(int index) {
    if (index < 0 || index >= this.size) 
      return null;
    
    Bucket cursor = start;
    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    } //for
    return cursor.value;
  }
  
  public int insert(int index, Object value) {
	  if(index < 0 || index >= this.size) {
		  System.out.println("범위내로하셈 insert안해주꾸얌!!!  + ㅅ + "); 
		  return -1;
		  }
	  else {
		  Bucket empty = new Bucket();
		  Bucket cursor = start;
		  Bucket temp = start;
		  
		    for (int i = 0; i < this.size; i++) {
		    	if(index == i) {
		    		if(index==0) {
		    			start = empty;
//		    			cursor = empty;
		    			temp = empty;
		    			
		    			empty.value = value;
		    			empty.next = cursor;
		    				    			
		    		} 
		    		
		    		else {
		    			temp.next = cursor.next; //전꺼가 다음꺼 가리키는거
		    			empty.value = value; // 새로만든 empty에 value를 넣으셈
		    			temp.next = empty;   // 새로만든 empty주소를  전 객체가 가르키게 해
		    			empty.next = cursor.next; //새로만든 empty가 다음객체를 가르키도록 해
		    		}
		    		
		    		
		    	}
		    	else{  
		    		temp=cursor;
		    		cursor = cursor.next; 
		    			    			
		    	}
		    } 
		  size++;
		  return 0;
		    } 
		  
		 
    
  }
  
  public int remove(int index) {
	  if(index < 0 || index>= this.size) {
		  System.out.println("범위내로하셈- _- remove안해주꾸ㅇ ㅑ !!"); 
		  return -1;
		  }
	  else {
		  
		  Bucket cursor = start;
		  Bucket temp = start;
		  
		    for (int i = 0; i < this.size; i++) {
		    	if(index == i) {
		    		if(index==0) {
		    			start = cursor.next;
		    			cursor = cursor.next;
		    				    			
		    		} else {
		    		temp.next = cursor.next; //전꺼가 다음꺼 가리키는거
		    		}   		
		    		return 0;
		    	}
		    	else{  
		    		temp=cursor;
		    		cursor = cursor.next; 
		    			    			
		    	}
		    } 
		  size--;
		  return 0;
	  }
  }
}

public class CollectionTest05 {
  public static void printArray(MyLinkedList2 list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }// for
  }

  public static void main(String[] args) {
    MyLinkedList2 arr = new MyLinkedList2();
    arr.add("00000");
    arr.add("11111");
    arr.add("22222");
    arr.add("33333");
    arr.add("44444");
    arr.add("55555");
    arr.add("66666");
    arr.add("77777");

    System.out.println("-----------------");
    printArray(arr);
    
  /*  System.out.println("   -10에 입력: -----------------");
    arr.insert(-10, "-10에 입력");
    printArray(arr);
    
    System.out.println("    30에 입력: -----------------");
    arr.insert(30, "30에 입력");
    printArray(arr);
    */
    System.out.println("    0번에 입력: -----------------");
    arr.insert(0, "!!!!!!");
    printArray(arr);
    
    System.out.println("    9번에 입력: -----------------");
    arr.insert(8, "@@@@@@@");
    printArray(arr);
    
    System.out.println("    4번에 입력: -----------------");
    arr.insert(4, "######");
    printArray(arr);
    
/*    System.out.println("        -30번 삭제: -------------");
    arr.remove(-30);
    printArray(arr);
    
    System.out.println("        30번 삭제: -------------");
    arr.remove(30);
    printArray(arr);*/
    
    System.out.println("        0번 삭제: -------------");
    arr.remove(0);
    printArray(arr);
    
    System.out.println("         10번 삭제: -------------");
    arr.remove(10);
    printArray(arr);
    
    System.out.println("         4번 삭제: -------------");
    arr.remove(4);
    printArray(arr);
    
  }
}