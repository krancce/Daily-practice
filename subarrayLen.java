public class subarrayLen{
  public int maxSubArrayLen(int[] nums, int k) {
    HashMap<Integer,Integer> map = new HashMap();
    map.put(0,-1);
    int sum = 0;
    int max = 0;
    for(int i=0;i<nums.length;i++){
      sum += nums[i];
      if(map.containsKey(sum-k)){
        int tmp = i-map.get(sum-k);
        max = (tmp>max)? tmp : max;
      }
      if(map.containsKey(sum)){continue;}
      map.put(sum,i);

    }
    return max;
  }
}
