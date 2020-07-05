public class targetSum{
  int count = 0;
  public void helper(int[] num,int s,int index,int total){
    if(index==num.length){
      if(total==s){
        count++;
      }
    }else{
      helper(num,s,index+1,total+num[index]);
      helper(num,s,index+1,total-num[index]);
    }


  }
  public int findTargetSumWays(int[] nums, int S) {
    helper(nums,S,0,0);
    return count;
  }
}
