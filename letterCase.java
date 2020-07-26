public class letterCase{
  public List<String> letterCase(String s){
    List<String> ans = new ArrayList();
    helper(s,ans,"",0);
    return ans;
  }

  public void helper(String s, List<String> ans, String curr, int index){
    if(index==s.length()){
      ans.add(surr);
      return;
    }
    if(Character.isAlphabetic(s.charAt(index))){
      helper(s,ans,curr+s.substring(index,index+1),index+1);
      helper(s,ans,curr+Character.toString(Character.toLowerCase(s.charAt(index))),index+1);
    }else{
      helper(s,ans,curr+s.charAt(index),index+1);
    }
  }

}
