import java.util.LinkedList;
import java.util.Queue;
public class lookandsay{
  public static String countAndSay(int n){
    String solution ="";
    if(n==1){
      return "1";
    }
    else{
      Queue<String> test = new LinkedList<>();
      test.add("1");
      int counter = 1;
      while (counter!=n){
        Queue<String> sol = new LinkedList<>();
        int size = test.size();
        int count = 0;
        String tmp ="";
        for(int i=0; i<size; i++){
          if(!tmp.equals("")&&tmp.equals(test.peek())){
            count++;
            test.remove();
          }else if(tmp.equals("")){
            tmp=test.remove();
            count++;
          }else{
            i--;
            sol.add(String.valueOf(count));
            sol.add(tmp);
            tmp=test.peek();
            count=0;
          }
        }
        if(!tmp.equals("")&&count!=0){
          sol.add(String.valueOf(count));
          sol.add(tmp);

        }
        test=sol;
        counter++;
      }
      while(test.size()!=0){
        solution=solution+test.remove();
      }
    }
    return solution;
  }

  public static void main(String[] args) {
    System.out.println(countAndSay(6));
  }
}
