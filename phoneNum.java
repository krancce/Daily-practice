import java.util.HashMap;
import java.util.ArrayList;
public class phoneNum{

  static ArrayList<String> output = new ArrayList<String>();

  public static void backtrack(String combination, String next_digits){
    HashMap<String,String> map = new HashMap<>();
    map.put("2","abc");
    map.put("3","def");
    map.put("4","ghi");
    map.put("5","jkl");
    map.put("6","mno");
    map.put("7","pqrs");
    map.put("8","tuv");
    map.put("9","wxyz");

    if(next_digits.length()==0){
      output.add(combination);
    }
    else{
      String digit = next_digits.substring(0,1);
      String letters = map.get(digit);
      for(int i=0; i<letters.length(); i++){
        String letter = map.get(digit).substring(i,i+1);
        backtrack(combination+letter,next_digits.substring(1));
      }
    }
  }
  public static ArrayList<String> letterCombinations(String digits){
    if(digits.length()!=0){
      backtrack("",digits);
    }
    return output;
  }

  public static void main(String[] args) {
    System.out.println(letterCombinations("23"));
  }
}
