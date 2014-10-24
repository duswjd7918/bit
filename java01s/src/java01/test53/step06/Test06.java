//Test06은 그대로 두고 다른걸 변경하면서 ReFactoring
package java01.test53.step06;


public class Test06 {
  public static void main(String[] args) throws Exception {
    String iteratorClassName = System.getProperty("iterator");
    
    Class clazz = Class.forName(iteratorClassName);
    Iterator iterator = (Iterator)clazz.newInstance();
    iterator.setList(args);
    
    while(iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}

