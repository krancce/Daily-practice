import java.util.ArrayList;
import java.util.HashSet;

public class wordBreak_Memo{
  public static boolean wordBreak(String s, ArrayList<String> wordDict) {
       HashSet set = new HashSet(wordDict);
       return wordBreak_Memo(s, set, 0, new Boolean[s.length()]);
   }

   public static boolean wordBreak_Memo(String s, HashSet set, int start, Boolean[] memo){
     if(start == s.length()){
       return true;
     }
     if(memo[start]!=null){
       return memo[start];
     }
     for(int end = start+1; end<=s.length(); end++){
       if(set.contains(s.substring(start,end)) && wordBreak_Memo(s,set,end,memo)){
         return memo[start]=true;
       }
     }
     return memo[start]=false;
   }

   public static void main(String[] args) {
     String s = "catsandog";
     ArrayList<String> wordDict = new ArrayList<String>();
     wordDict.add("cat");
     wordDict.add("cats");
     wordDict.add("sand");
     wordDict.add("and");
     wordDict.add("dog");
     System.out.println(wordBreak(s,wordDict));
   }
}
