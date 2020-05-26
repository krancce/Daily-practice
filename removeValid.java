import java.lang.StringBuilder;
import java.util.Stack;

class removeValid {
    public String minRemoveToMakeValid(String s) {
      StringBuilder sb = new StringBuilder();
      int opens = 0;
      int count = 0;
      Stack<Character> leftP = new Stack<Character>();
      Stack<Integer> leftPos = new Stack<Integer>();
      Stack<Integer> deletePos = new Stack<Integer>();

      for(char ch: s.toCharArray()){
        if(ch == '('){
          opens++;
          leftP.push(ch);
          leftPos.push(count);
        }else if(ch == ')'){
          if(leftP.empty()){
            deletePos.push(count);
          }else if (opens != 0) {
            opens--;
            leftP.pop();
            leftPos.pop();
          }
        }
        count++;
      }

      while(!leftP.empty()){
        deletePos.push(leftPos.pop());
        leftP.pop();
      }
      int tmp = 0;
      for(char ch: s.toCharArray()){
        if(deletePos.search(tmp)==-1){
          sb.append(ch);
        }
        tmp++;
      }

      return sb.toString();
    }

}
