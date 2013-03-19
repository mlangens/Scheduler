package Scheduler;

import java.util.StringTokenizer;

class DescriptionTokenizer {  
  public static int getId(Object description) {
    StringTokenizer tokenizer = new StringTokenizer((String) description);
    return Integer.parseInt((String) tokenizer.nextElement());    
  } 
  
  public static int getInit(Object description) {
    StringTokenizer tokenizer = new StringTokenizer((String) description);
    tokenizer.nextElement();
    return Integer.parseInt((String) tokenizer.nextElement());    
  }
  
  public static int getBurst(Object description) {
    StringTokenizer tokenizer = new StringTokenizer((String) description);
    tokenizer.nextElement();
    tokenizer.nextElement();
    return Integer.parseInt((String) tokenizer.nextElement());    
  }  
}
