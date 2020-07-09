public class maxSub{
  public int maxSubArray(int[] nums) {
    int currMax = nums[0];
    int cumMax = currMax;
    for(int i=1;i<nums.length;i++){
      if(currMax<nums[i]&&currMax<0){
        currMax = nums[i];
      }else{
        currMax += nums[i];
      }
      cumMax = Math.max(cumMax,currMax);
    }
    return cumMax;
   }
}
