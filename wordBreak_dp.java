import java.util.ArrayList;

public class wordBreak_dp{

  public static boolean wordBreak_dp(String s, ArrayList<String> wordDict){
    int max = 0;
    for(int i=0; i<wordDict.size(); i++){
      if(wordDict.get(i).length()>max){
        max = wordDict.get(i).length();
      }
    }
    boolean[] dp = new boolean[s.length()+1];
    dp[0]=true;

    for(int i=1; i<=s.length(); i++){
      for(int lastWordLength=0; lastWordLength<=max && lastWordLength<=i; lastWordLength++){
        if(!dp[i-lastWordLength]){
          continue;
        }
        if(wordDict.contains(s.substring(i-lastWordLength,i))){
          dp[i]=true;
          break;
        }
      }
    }
    return dp[dp.length-1];
  }
  public static void main(String[] args) {
    String s = "catsandog";
    ArrayList<String> wordDict = new ArrayList<String>();
    wordDict.add("cat");
    wordDict.add("cats");
    wordDict.add("sand");
    wordDict.add("and");
    wordDict.add("dog");
    System.out.println(wordBreak_dp(s,wordDict));
  }

}
