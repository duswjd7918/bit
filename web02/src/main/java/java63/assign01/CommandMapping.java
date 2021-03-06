package java63.assign01;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java63.assign01.annotation.Command;

import org.reflections.ReflectionUtils;

public class CommandMapping {
  public static class CommandInfo {
    public Object instance;
    public Method method;
  }
  
  HashMap<String,CommandInfo> commandMap = new HashMap<>();
  
  @SuppressWarnings("unchecked")
  public void prepare(Collection<Object> objList) throws Exception {
    Set<Method> methods = null;
    Command commandAnno = null;
    CommandInfo commandInfo = null;
    
    for (Object obj : objList) {
    	System.out.println("obj : "+obj);
      methods = ReflectionUtils.getMethods(
          obj.getClass(),
          ReflectionUtils.withAnnotation(Command.class));
      
      for (Method m :methods) {
        commandAnno = m.getAnnotation(Command.class);
        commandInfo = new CommandInfo();
        commandInfo.instance = obj;
        commandInfo.method = m;
        commandMap.put(commandAnno.value(), commandInfo);
      }
    }
  }
  
  public CommandInfo getCommandInfo(String command) {
    return commandMap.get(command);
  }
}


