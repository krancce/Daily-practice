import java.util.Stack;
public class  ParenthesisIsValid{
  public static boolean isValid(String s){
    String[] tmp = s.split("");
    Stack<String> stack = new Stack<String>();

    for(int i=0; i<tmp.length; i++){
      if(tmp[i].equals("(") || tmp[i].equals("[") || tmp[i].equals("{")){
        stack.push(tmp[i]);
      }

      if(tmp[i].equals(")")){
        if(stack.empty()){
          return false;
        }
        else if(!stack.peek().equals("(")){
          return false;
        }
        else{
          stack.pop();
        }
      }

      if(tmp[i].equals("]")){
        if(stack.empty()){
          return false;
        }
        else if(!stack.peek().equals("[")){
          return false;
        }
        else{
          stack.pop();
        }
      }

      if(tmp[i].equals("}")){
        if(stack.empty()){
          return false;
        }
        else if(!stack.peek().equals("{")){
          return false;
        }
        else{
          stack.pop();
        }
      }
    }
    return true;
  }


  public static void main(String[] args) {
    System.out.println(isValid("(){}[]"));
    System.out.println(isValid("{[()]}"));
    System.out.println(isValid("({)}"));
  }
}
